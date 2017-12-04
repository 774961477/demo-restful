package org.spring.springboot.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class StoreJoin {
	private String id;
	private String openId;
	private String formId;
	private String storeName;
	private String  storePhone;
	private String  storeContact;
	private String  sendMessage;
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date  createTime;

}
