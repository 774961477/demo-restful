package org.spring.springboot.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class ResumeDto {
	private String id;
	private String openId;
	private String formId;
	private String userName;
	private String phone;
	private String userEdu;
	private String position;
	private String industry;
	private String positionName;
	private String industryName;
	private String salary;
	private String location;
	private String photo;
	private String state;
	private Date createTime;
	
	private List<WorkExp> workList;
	
	private List<EduExp> eduList;

}
