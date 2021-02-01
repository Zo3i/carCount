/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.car.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.modules.car.entity.CarDiver;
import com.jeesite.modules.car.entity.CarTeam;
import com.jeesite.modules.car.service.CarDiverService;
import com.jeesite.modules.car.service.CarTeamService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.checkerframework.checker.units.qual.A;
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
import com.jeesite.modules.car.entity.CarSubTeam;
import com.jeesite.modules.car.service.CarSubTeamService;

import java.util.List;

/**
 * car_sub_teamController
 * @author jo
 * @version 2021-01-31
 */
@Controller
@RequestMapping(value = "${adminPath}/car/carSubTeam")
public class CarSubTeamController extends BaseController {

	@Autowired
	private CarSubTeamService carSubTeamService;
	@Autowired
	private CarTeamService teamService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public CarSubTeam get(String id, boolean isNewRecord) {
		return carSubTeamService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("car:carSubTeam:view")
	@RequestMapping(value = {"list", ""})
	public String list(CarSubTeam carSubTeam, Model model) {
		model.addAttribute("carSubTeam", carSubTeam);
		return "modules/car/carSubTeamList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("car:carSubTeam:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<CarSubTeam> listData(CarSubTeam carSubTeam, HttpServletRequest request, HttpServletResponse response) {
		carSubTeam.setPage(new Page<>(request, response));
		Page<CarSubTeam> page = carSubTeamService.findPage(carSubTeam);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("car:carSubTeam:view")
	@RequestMapping(value = "form")
	public String form(CarSubTeam carSubTeam, Model model) {
		List<CarTeam> teams = teamService.findList(new CarTeam());

		model.addAttribute("teams", teams);
		model.addAttribute("carSubTeam", carSubTeam);
		return "modules/car/carSubTeamForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("car:carSubTeam:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated CarSubTeam carSubTeam) {
		carSubTeamService.save(carSubTeam);
		return renderResult(Global.TRUE, text("保存car_sub_team成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("car:carSubTeam:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(CarSubTeam carSubTeam) {
		carSubTeamService.delete(carSubTeam);
		return renderResult(Global.TRUE, text("删除car_sub_team成功！"));
	}
	
}