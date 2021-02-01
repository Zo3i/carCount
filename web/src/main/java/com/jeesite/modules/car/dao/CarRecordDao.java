/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.car.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.car.entity.CarRecord;

/**
 * car_recordDAO接口
 * @author jo
 * @version 2021-01-31
 */
@MyBatisDao
public interface CarRecordDao extends CrudDao<CarRecord> {
	
}