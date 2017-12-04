package org.spring.springboot.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Resume {
	private String id;
	private String openId;
	private String formId;
	private String userName;
	private String phone;
	private String userEdu;
	private String position;
	private String positionName;
	private String industry;
	private String industryName;
	private String salary;
	private String location;
	private String photo;
	private String state;
	private Date createTime;

}
