package org.spring.springboot.domain;

import lombok.Data;

@Data
public class CommentPage {
	private Integer pageNum;
	private Integer pageSize;
	private String storeId;
}
