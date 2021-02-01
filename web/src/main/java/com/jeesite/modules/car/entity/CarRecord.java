/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.car.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * car_recordEntity
 * @author jo
 * @version 2021-01-31
 */
@Table(name="car_record", alias="a", columns={
		@Column(name="driver_id", attrName="driverId", label="driver_id"),
		@Column(name="date", attrName="date", label="date"),
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="amount", attrName="amount", label="amount"),
		@Column(name="times", attrName="times", label="times"),
		@Column(includeEntity=DataEntity.class),
		@Column(name="team_id", attrName="teamId", label="team_id"),
		@Column(name="sub_team_id", attrName="subTeamId", label="sub_team_id"),
	}, orderBy="a.update_date DESC"
)
public class CarRecord extends DataEntity<CarRecord> {
	
	private static final long serialVersionUID = 1L;
	private String driverId;		// driver_id
	private Date date;		// date
	private Double amount;		// amount
	private Integer times;		// times
	private String teamId;		// team_id
	private String subTeamId;		// sub_team_id

	private String driverName;
	private String teamName;
	private String subTeamName;
	
	public CarRecord() {
		this(null);
	}

	public CarRecord(String id){
		super(id);
	}
	
	@Length(min=0, max=32, message="driver_id长度不能超过 32 个字符")
	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public Integer getTimes() {
		return times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}
	
	@Length(min=0, max=32, message="team_id长度不能超过 32 个字符")
	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	
	@Length(min=0, max=32, message="sub_team_id长度不能超过 32 个字符")
	public String getSubTeamId() {
		return subTeamId;
	}

	public void setSubTeamId(String subTeamId) {
		this.subTeamId = subTeamId;
	}


	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
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