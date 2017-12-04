package org.spring.springboot.domain;

import lombok.Data;

/**
 * 系统用户实体类
 *
 * Created by bysocket on 07/02/2017.
 */
@Data
public class ShiroUser {

	private String id;
	private String userName;
	private String loginName;
	private String password;
	private int roleId;
	private String state;
	
}
