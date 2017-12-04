package org.spring.springboot.domain;

import lombok.Data;

@Data
public class Column {
	private String id;
	private String columnName;
	private String columnParentName;
	private String parentId;
	private String columnImgPath;
	private String columnSort;
	private String state;
}
