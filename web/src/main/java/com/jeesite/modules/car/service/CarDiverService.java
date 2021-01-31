/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.car.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.car.entity.CarDiver;
import com.jeesite.modules.car.dao.CarDiverDao;

/**
 * car_diverService
 * @author jo
 * @version 2021-01-31
 */
@Service
@Transactional(readOnly=true)
public class CarDiverService extends CrudService<CarDiverDao, CarDiver> {
	
	/**
	 * 获取单条数据
	 * @param carDiver
	 * @return
	 */
	@Override
	public CarDiver get(CarDiver carDiver) {
		return super.get(carDiver);
	}
	
	/**
	 * 查询分页数据
	 * @param carDiver 查询条件
	 * @param carDiver.page 分页对象
	 * @return
	 */
	@Override
	public Page<CarDiver> findPage(CarDiver carDiver) {
		return super.findPage(carDiver);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param carDiver
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(CarDiver carDiver) {
		super.save(carDiver);
	}
	
	/**
	 * 更新状态
	 * @param carDiver
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(CarDiver carDiver) {
		super.updateStatus(carDiver);
	}
	
	/**
	 * 删除数据
	 * @param carDiver
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(CarDiver carDiver) {
		super.delete(carDiver);
	}
	
}