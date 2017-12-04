package org.spring.springboot.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * 系统用户实体类
 *
 * Created by bysocket on 07/02/2017.
 */
@Data
public class AdvertisementDto {

	private String id;
	private String title;
	private String url;
	private String columnId;
	private String columnName;
	private String imgPath;
	private String state;
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date createTime;
	
}
