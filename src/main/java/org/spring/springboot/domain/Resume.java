package org.spring.springboot.domain;

import java.util.Date;
import java.util.List;

import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelCollection;
import org.jeecgframework.poi.excel.annotation.ExcelTarget;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@ExcelTarget("resume")
public class Resume {
	private String id;
	private String openId;
	private String formId;
	@Excel(name = "姓名", orderNum = "1",needMerge = true, isImportField = "userName")
	private String userName;
	@Excel(name = "联系方式", orderNum = "2", needMerge = true, isImportField = "phone")
	private String phone;
	@Excel(name = "学历", orderNum = "3", needMerge = true,isImportField = "userEdu")
	private String userEdu;
	private String position;
	@Excel(name = "意向职位", orderNum = "4", needMerge = true, isImportField = "positionName")
	private String positionName;
	private String industry;
	@Excel(name = "意向行业", orderNum = "5",needMerge = true,  isImportField = "industryName")
	private String industryName;

	@Excel(name = "薪资要求", orderNum = "6",needMerge = true,  isImportField = "salary")
	private String salary;
	@Excel(name = "求职区域", orderNum = "7",needMerge = true,  isImportField = "location")
	private String location;
	
	@Excel(name = "工作经历", orderNum = "8",needMerge = true,  isImportField = "location")
	private String work;
	
	@Excel(name = "教育经历", orderNum = "9",needMerge = true,  isImportField = "location")
	private String school;

	private String photo;
	private String state;
	@Excel(name = "发布时间", orderNum = "10", needMerge = true,exportFormat = "yyyy-MM-dd", isImportField = "createTime")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date createTime;

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date startDate;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date endDate;
	
	
	/*
	@ExcelCollection(name = "工作经历", orderNum = "8")
	private List<WorkExp> workList;
	@ExcelCollection(name = "教育经历", orderNum = "9")
	private List<EduExp> eduList;
	*/

}
