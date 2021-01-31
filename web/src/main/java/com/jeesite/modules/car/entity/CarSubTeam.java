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
 * car_sub_teamEntity
 * @author jo
 * @version 2021-01-31
 */
@Table(name="car_sub_team", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(includeEntity=DataEntity.class),
		@Column(name="name", attrName="name", label="小车队名称", queryType=QueryType.LIKE),
		@Column(name="team_id", attrName="teamId", label="所属车队"),
	}, orderBy="a.update_date DESC"
)
public class CarSubTeam extends DataEntity<CarSubTeam> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 小车队名称
	private String teamId;		// 所属车队
	private String teamName;
	
	public CarSubTeam() {
		this(null);
	}

	public CarSubTeam(String id){
		super(id);
	}
	
	@Length(min=0, max=255, message="小车队名称长度不能超过 255 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
}