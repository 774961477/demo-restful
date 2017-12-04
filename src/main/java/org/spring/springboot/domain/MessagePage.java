package org.spring.springboot.domain;

import lombok.Data;

@Data
public class MessagePage {
	private String openId;
	private Integer pageSize;
	private Integer pageNum;

}
