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
public class Store {
	private String id;
	private String storeName;
	private String storeColumn;
	private String storeImgPath;
	private String storePhone;
	private String type;
	private String storeLocation;
	private String latitude;
	private String longitude;
	private String storeDetail;
	private String storeDiscount;
	private String topFlag;
	private String state;
	private String storePrice;
	private float storeStars;
	private String createUserId;
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date createTime;
	private Integer viewCount;
	private Integer sortBy;
}
