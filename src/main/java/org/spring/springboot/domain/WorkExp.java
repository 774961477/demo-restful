package org.spring.springboot.domain;

import java.util.Date;

import lombok.Data;

@Data
public class WorkExp {
	private String id;
	private String companyName;
	private String openId;
	private String startDate;
	private String endDate;
	private String position;
	private String remark;
	private String state;
	private Date createTime;

}
