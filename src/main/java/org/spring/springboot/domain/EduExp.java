package org.spring.springboot.domain;

import java.util.Date;

import org.jeecgframework.poi.excel.annotation.Excel;

import lombok.Data;

@Data
public class EduExp {
	private String id;
	private String openId;
	@Excel(name = "就读学校", isImportField = "school")
	private String school;
	@Excel(name = "开始时间", isImportField = "startDate")
	private String startDate;
	@Excel(name = "结束时间", isImportField = "endDate")
	private String endDate;
	
	private String state;
	private Date createTime;
}
