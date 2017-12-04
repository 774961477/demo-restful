package org.spring.springboot.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Message {
	private String id;
	private String replyId;
	private String openId;
	private String formId;
	private String content;
	private String answer;
	private String question;
	private String flag;
	private String state;
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date createTime;

}
