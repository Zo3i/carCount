/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.car.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.car.entity.CarTeam;
import com.jeesite.modules.car.dao.CarTeamDao;

/**
 * 代码生成表Service
 * @author jo
 * @version 2021-01-31
 */
@Service
@Transactional(readOnly=true)
public class CarTeamService extends CrudService<CarTeamDao, CarTeam> {
	
	/**
	 * 获取单条数据
	 * @param carTeam
	 * @return
	 */
	@Override
	public CarTeam get(CarTeam carTeam) {
		return super.get(carTeam);
	}
	
	/**
	 * 查询分页数据
	 * @param carTeam 查询条件
	 * @param carTeam.page 分页对象
	 * @return
	 */
	@Override
	public Page<CarTeam> findPage(CarTeam carTeam) {
		return super.findPage(carTeam);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param carTeam
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(CarTeam carTeam) {
		super.save(carTeam);
	}
	
	/**
	 * 更新状态
	 * @param carTeam
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(CarTeam carTeam) {
		super.updateStatus(carTeam);
	}
	
	/**
	 * 删除数据
	 * @param carTeam
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(CarTeam carTeam) {
		super.delete(carTeam);
	}
	
}