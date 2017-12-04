package org.spring.springboot.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class Common {
	private String id;
	private String name;
	private String code;
	private String type;
	private String state;
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date create_time;

}
