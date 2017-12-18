package org.spring.springboot.domain;

import java.util.List;

import lombok.Data;

@Data
public class UserMenuDto {
	private String id;
	private List<String> menuIds;
	private String userId;
	
}
