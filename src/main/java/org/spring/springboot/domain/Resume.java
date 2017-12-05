package org.spring.springboot.domain;

import java.util.Date;

import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelTarget;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@ExcelTarget("resume") 
public class Resume {
	private String id;
	private String openId;
	private String formId;
	@Excel(name = "姓名", orderNum = "1", mergeVertical = true, isImportField = "userName")
	private String userName;
	@Excel(name = "联系方式", orderNum = "2", mergeVertical = true, isImportField = "phone")
	private String phone;
	@Excel(name = "学历", orderNum = "3", mergeVertical = true, isImportField = "userEdu")
	private String userEdu;
	private String position;
	@Excel(name = "意向职位", orderNum = "4", mergeVertical = true, isImportField = "positionName")
	private String positionName;
	private String industry;
	@Excel(name = "意向行业", orderNum = "5", mergeVertical = true, isImportField = "industryName")
	private String industryName;
	
	@Excel(name = "薪资要求", orderNum = "6", mergeVertical = true, isImportField = "salary")
	private String salary;
	@Excel(name = "求职区域", orderNum = "7", mergeVertical = true, isImportField = "location")
	private String location;
	
	private String photo;
	private String state;
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date createTime;

}
