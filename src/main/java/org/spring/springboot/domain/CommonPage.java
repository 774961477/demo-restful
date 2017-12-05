package org.spring.springboot.domain;

import lombok.Data;

@Data
public class CommonPage {
	private String type;
	private Integer pageSize;
	private Integer pageNum;

}
