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
public class StoreSignUp {
	private String id;
	private String userId;
	private String storeId;
	private String storeName;
	private String userName;
	private String userPhone;
	private String openId;
	private String formId;
	private String remark;
	private String state;
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date createTime;
}
