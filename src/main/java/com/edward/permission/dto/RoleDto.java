package com.edward.permission.dto;

import com.edward.permission.entity.Role;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class RoleDto {

	@JsonProperty("role_id")
	@Getter @Setter
	private Long roleId;
	
	@JsonProperty("name")
	@Getter @Setter
	private String name;
	
	public static RoleDto valueOf(Role role) 
	{
		return RoleDto.builder().roleId(role.getRoleId()).name(role.getName()).build();
	}
	
}
