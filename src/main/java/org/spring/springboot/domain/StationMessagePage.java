package org.spring.springboot.domain;

import lombok.Data;

@Data
public class StationMessagePage {
	private String userId;
	private Integer pageSize;
	private Integer pageNum;

}
