package org.spring.springboot.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * 商家实体类
 *
 * Created by bysocket on 07/02/2017.
 */
@Data
public class StoreDto {
	private String id;
	private String storeName;
	private String storeImgPath;
	private String storeColumn;
	private String columnParentId;
	private String storeColumnName;
	private String storeLocation;
	private String storePhone;
	private String type;
	private String latitude;
	private String longitude;
	private String storeDetail;
	private String storeDiscount;
	private String storePrice;
	private float storeStars;
	private String topFlag;
	private Integer sortBy;
	private Integer viewCount;
	private String createUserId;
	private String state;
	private String distance;
	private int commentNumbers;
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date createTime;
}
