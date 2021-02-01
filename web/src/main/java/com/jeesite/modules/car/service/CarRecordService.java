/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.car.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.car.entity.CarRecord;
import com.jeesite.modules.car.dao.CarRecordDao;

/**
 * car_recordService
 * @author jo
 * @version 2021-01-31
 */
@Service
@Transactional(readOnly=true)
public class CarRecordService extends CrudService<CarRecordDao, CarRecord> {
	
	/**
	 * 获取单条数据
	 * @param carRecord
	 * @return
	 */
	@Override
	public CarRecord get(CarRecord carRecord) {
		return super.get(carRecord);
	}
	
	/**
	 * 查询分页数据
	 * @param carRecord 查询条件
	 * @param carRecord.page 分页对象
	 * @return
	 */
	@Override
	public Page<CarRecord> findPage(CarRecord carRecord) {
		return super.findPage(carRecord);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param carRecord
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(CarRecord carRecord) {
		super.save(carRecord);
	}
	
	/**
	 * 更新状态
	 * @param carRecord
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(CarRecord carRecord) {
		super.updateStatus(carRecord);
	}
	
	/**
	 * 删除数据
	 * @param carRecord
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(CarRecord carRecord) {
		super.delete(carRecord);
	}
	
}