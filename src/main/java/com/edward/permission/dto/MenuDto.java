package com.edward.permission.dto;

import com.edward.permission.entity.Menu;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class MenuDto {

	@JsonProperty("menu_id")
	@Getter @Setter
	private Long menuId;
	
	@JsonProperty("detail")
	@Getter @Setter
	private String detail;
	
	public static MenuDto valueOf(Menu menu) 
	{
		return MenuDto.builder().menuId(menu.getMenuId()).detail(menu.getDetail()).build();
	}
	
}
