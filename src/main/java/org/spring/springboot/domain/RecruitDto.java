package org.spring.springboot.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class RecruitDto {
	private String id;
	private String companyName;
	private String companyPosition;
	private String companyPositionName;
	private String companyIndustry;
	private String companyIndustryName;
	private String salary;
	private String salarys;
	private String positions;
	private String photos;
	private String companyLocation;
	private String remark;
	private String state;
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date createTtime;
}
