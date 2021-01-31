/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.car.entity;

import com.jeesite.common.shiro.realms.S;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * car_diverEntity
 * @author jo
 * @version 2021-01-31
 */
@Table(name="car_diver", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(includeEntity=DataEntity.class),
		@Column(name="name", attrName="name", label="name", queryType=QueryType.LIKE),
		@Column(name="order", attrName="order", label="order"),
		@Column(name="car_number", attrName="carNumber", label="car_number"),
		@Column(name="team_id", attrName="teamId", label="team_id"),
		@Column(name="sub_team_id", attrName="subTeamId", label="sub_team_id"),
	}, orderBy="a.update_date DESC"
)
public class CarDiver extends DataEntity<CarDiver> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// name
	private Integer order;		// order
	private String carNumber;		// car_number
	private String teamId;		// team_id
	private String subTeamId;		// sub_team_id

	private String teamName;
	private String subTeamName;
	
	public CarDiver() {
		this(null);
	}

	public CarDiver(String id){
		super(id);
	}
	
	@Length(min=0, max=255, message="name长度不能超过 255 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}
	
	@Length(min=0, max=64, message="car_number长度不能超过 64 个字符")
	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	
	@Length(min=0, max=64, message="team_id长度不能超过 64 个字符")
	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	
	@Length(min=0, max=64, message="sub_team_id长度不能超过 64 个字符")
	public String getSubTeamId() {
		return subTeamId;
	}

	public void setSubTeamId(String subTeamId) {
		this.subTeamId = subTeamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getSubTeamName() {
		return subTeamName;
	}

	public void setSubTeamName(String subTeamName) {
		this.subTeamName = subTeamName;
	}
}