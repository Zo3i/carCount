/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.car.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.modules.car.entity.CarSubTeam;
import com.jeesite.modules.car.entity.CarTeam;
import com.jeesite.modules.car.service.CarSubTeamService;
import com.jeesite.modules.car.service.CarTeamService;
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
import com.jeesite.modules.car.entity.CarDiver;
import com.jeesite.modules.car.service.CarDiverService;

import java.util.List;

/**
 * car_diverController
 * @author jo
 * @version 2021-01-31
 */
@Controller
@RequestMapping(value = "${adminPath}/car/carDiver")
public class CarDiverController extends BaseController {

	@Autowired
	private CarDiverService carDiverService;
	@Autowired
	private CarTeamService carTeamService;
	@Autowired
	private CarSubTeamService carSubTeamService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public CarDiver get(String id, boolean isNewRecord) {
		return carDiverService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("car:carDiver:view")
	@RequestMapping(value = {"list", ""})
	public String list(CarDiver carDiver, Model model) {
		model.addAttribute("carDiver", carDiver);
		return "modules/car/carDiverList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("car:carDiver:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<CarDiver> listData(CarDiver carDiver, HttpServletRequest request, HttpServletResponse response) {
		carDiver.setPage(new Page<>(request, response));
		Page<CarDiver> page = carDiverService.findPage(carDiver);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("car:carDiver:view")
	@RequestMapping(value = "form")
	public String form(CarDiver carDiver, Model model) {

		List<CarTeam> teams = carTeamService.findList(new CarTeam());
		List<CarSubTeam> subTeams = carSubTeamService.findList(new CarSubTeam());

		model.addAttribute("teams", teams);
		model.addAttribute("subTeams", subTeams);
		model.addAttribute("carDiver", carDiver);
		return "modules/car/carDiverForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("car:carDiver:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated CarDiver carDiver) {
		carDiverService.save(carDiver);
		return renderResult(Global.TRUE, text("保存car_diver成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("car:carDiver:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(CarDiver carDiver) {
		carDiverService.delete(carDiver);
		return renderResult(Global.TRUE, text("删除car_diver成功！"));
	}
	
}