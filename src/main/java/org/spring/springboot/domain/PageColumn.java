package org.spring.springboot.domain;

import lombok.Data;

@Data
public class PageColumn {
	private Integer pageNum;
	private Integer pageSize;
	private String parentId;
}
