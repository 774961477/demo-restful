package org.spring.springboot.domain;

import lombok.Data;

/**
 * 系统用户实体类
 *
 * Created by bysocket on 07/02/2017.
 */
@Data
public class Advertisement {

	private String id;
	private String columnId;
	private String title;
	private String url;
	private String imgPath;
	private String state;
	
}
