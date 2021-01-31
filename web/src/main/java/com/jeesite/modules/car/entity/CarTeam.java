/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.car.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 代码生成表Entity
 * @author jo
 * @version 2021-01-31
 */
@Table(name="car_team", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(includeEntity=DataEntity.class),
		@Column(name="name", attrName="name", label="name", queryType=QueryType.LIKE),
	}, orderBy="a.update_date DESC"
)
public class CarTeam extends DataEntity<CarTeam> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// name
	
	public CarTeam() {
		this(null);
	}

	public CarTeam(String id){
		super(id);
	}
	
	@Length(min=0, max=255, message="name长度不能超过 255 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}