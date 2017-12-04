package org.spring.springboot.domain;

import lombok.Data;

@Data
public class SignPage {
	private Integer pageNum;
	private Integer pageSize;
	private String openId;
	private String storeId;
	private String userId;
}
