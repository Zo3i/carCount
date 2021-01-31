/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.car.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.car.entity.CarTeam;
import com.jeesite.modules.car.service.CarTeamService;

/**
 * 代码生成表Controller
 * @author jo
 * @version 2021-01-31
 */
@Controller
@RequestMapping(value = "${adminPath}/car/carTeam")
public class CarTeamController extends BaseController {

	@Autowired
	private CarTeamService carTeamService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public CarTeam get(String id, boolean isNewRecord) {
		return carTeamService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("car:carTeam:view")
	@RequestMapping(value = {"list", ""})
	public String list(CarTeam carTeam, Model model) {
		model.addAttribute("carTeam", carTeam);
		return "modules/car/carTeamList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("car:carTeam:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<CarTeam> listData(CarTeam carTeam, HttpServletRequest request, HttpServletResponse response) {
		carTeam.setPage(new Page<>(request, response));
		Page<CarTeam> page = carTeamService.findPage(carTeam);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("car:carTeam:view")
	@RequestMapping(value = "form")
	public String form(CarTeam carTeam, Model model) {
		model.addAttribute("carTeam", carTeam);
		return "modules/car/carTeamForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("car:carTeam:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated CarTeam carTeam) {
		carTeamService.save(carTeam);
		return renderResult(Global.TRUE, text("保存代码生成表成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("car:carTeam:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(CarTeam carTeam) {
		carTeamService.delete(carTeam);
		return renderResult(Global.TRUE, text("删除代码生成表成功！"));
	}
	
}