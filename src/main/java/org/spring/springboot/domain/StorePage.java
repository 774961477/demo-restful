package org.spring.springboot.domain;

import lombok.Data;

@Data
public class StorePage {
	private Integer pageNum;
	private Integer pageSize;
	private String columnId;
	private String columnParentId;
	private String topFlag;
	private String createUserId;
	private String storeName;
	private Integer sortBy;
	private String latitude;
	private String longitude;
}
