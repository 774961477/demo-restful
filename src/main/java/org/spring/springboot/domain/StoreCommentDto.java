package org.spring.springboot.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class StoreCommentDto {
	private String id;
	private float stars;
	private String nickName;
	private String avatarUrl;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone="GMT+8")
	private Date createTime;
	private String comment;
	
}
