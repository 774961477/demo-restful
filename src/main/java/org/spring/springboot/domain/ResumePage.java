package org.spring.springboot.domain;

import java.util.Date;

import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelTarget;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ResumePage {
	private String industry;
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date startDate;
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date endDate;
	private Integer pageSize;
	private Integer pageNum;

}
