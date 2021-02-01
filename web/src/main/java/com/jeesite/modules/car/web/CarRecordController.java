/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.car.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.modules.car.entity.CarDiver;
import com.jeesite.modules.car.service.CarDiverService;
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
import com.jeesite.modules.car.entity.CarRecord;
import com.jeesite.modules.car.service.CarRecordService;

import java.util.List;

/**
 * car_recordController
 * @author jo
 * @version 2021-01-31
 */
@Controller
@RequestMapping(value = "${adminPath}/car/carRecord")
public class CarRecordController extends BaseController {

	@Autowired
	private CarRecordService carRecordService;
	@Autowired
	private CarDiverService carDiverService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public CarRecord get(String id, boolean isNewRecord) {
		return carRecordService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("car:carRecord:view")
	@RequestMapping(value = {"list", ""})
	public String list(CarRecord carRecord, Model model) {
		model.addAttribute("carRecord", carRecord);
		return "modules/car/carRecordList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("car:carRecord:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<CarRecord> listData(CarRecord carRecord, HttpServletRequest request, HttpServletResponse response) {
		carRecord.setPage(new Page<>(request, response));
		Page<CarRecord> page = carRecordService.findPage(carRecord);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("car:carRecord:view")
	@RequestMapping(value = "form")
	public String form(CarRecord carRecord, Model model) {

		List<CarDiver> carDivers = carDiverService.findList(new CarDiver());

		model.addAttribute("carDivers", carDivers);
		model.addAttribute("carRecord", carRecord);

		return "modules/car/carRecordForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("car:carRecord:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated CarRecord carRecord) {

		// 车队
		CarDiver carDiver = carDiverService.get(carRecord.getDriverId());
		carRecord.setTeamId(carDiver.getTeamId());
		carRecord.setSubTeamId(carDiver.getSubTeamId());

		carRecordService.save(carRecord);
		return renderResult(Global.TRUE, text("保存car_record成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("car:carRecord:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(CarRecord carRecord) {
		carRecordService.delete(carRecord);
		return renderResult(Global.TRUE, text("删除car_record成功！"));
	}
	
}