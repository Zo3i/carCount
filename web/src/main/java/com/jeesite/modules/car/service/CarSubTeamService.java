/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.car.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.car.entity.CarSubTeam;
import com.jeesite.modules.car.dao.CarSubTeamDao;

/**
 * car_sub_teamService
 * @author jo
 * @version 2021-01-31
 */
@Service
@Transactional(readOnly=true)
public class CarSubTeamService extends CrudService<CarSubTeamDao, CarSubTeam> {
	
	/**
	 * 获取单条数据
	 * @param carSubTeam
	 * @return
	 */
	@Override
	public CarSubTeam get(CarSubTeam carSubTeam) {
		return super.get(carSubTeam);
	}
	
	/**
	 * 查询分页数据
	 * @param carSubTeam 查询条件
	 * @param carSubTeam.page 分页对象
	 * @return
	 */
	@Override
	public Page<CarSubTeam> findPage(CarSubTeam carSubTeam) {
		return super.findPage(carSubTeam);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param carSubTeam
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(CarSubTeam carSubTeam) {
		super.save(carSubTeam);
	}
	
	/**
	 * 更新状态
	 * @param carSubTeam
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(CarSubTeam carSubTeam) {
		super.updateStatus(carSubTeam);
	}
	
	/**
	 * 删除数据
	 * @param carSubTeam
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(CarSubTeam carSubTeam) {
		super.delete(carSubTeam);
	}
	
}