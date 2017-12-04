package org.spring.springboot.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * 城市实体类
 *
 * Created by bysocket on 07/02/2017.
 */
@Data
public class User {

	private String id;
	private String code;
	private String openId;
	private String nickName;
	private int gender;
	private String avatarUrl;
	private String city;
	private String province;
	private String country;
	private String phone;
	private String qq;
	private String idCard;
	private String realName;
	private String remark;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone="GMT+8")
	private Date createTime;
	
}
