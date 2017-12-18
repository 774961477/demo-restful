package org.spring.springboot.domain;

import java.util.Date;

import org.jeecgframework.poi.excel.annotation.Excel;

import lombok.Data;

@Data
public class WorkExp {
	private String id;
	@Excel(name = "公司名称", isImportField = "companyName")
	private String companyName;
	private String openId;
	@Excel(name = "开始时间", isImportField = "startDate")
	private String startDate;
	@Excel(name = "结束时间", isImportField = "startDate")
	private String endDate;
	private String position;
	private String remark;
	private String state;
	private Date createTime;

}
