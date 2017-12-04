package org.spring.springboot.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * 商家实体类
 *
 * Created by bysocket on 07/02/2017.
 */
@Data
public class StoreComment {
	private String id;
	private String storeId;
	private String openId;
	private float stars;
	private String formId;
	private String comment;
	
	private String state;
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date createTime;
}
