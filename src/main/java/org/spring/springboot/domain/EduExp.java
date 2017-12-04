package org.spring.springboot.domain;

import java.util.Date;

import lombok.Data;

@Data
public class EduExp {
	private String id;
	private String openId;
	private String startDate;
	private String endDate;
	private String school;
	private String state;
	private Date createTime;
}
