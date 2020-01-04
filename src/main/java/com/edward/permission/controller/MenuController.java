package com.edward.permission.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edward.permission.dto.MenuDto;
import com.edward.permission.response.DefaultResponse;
import com.edward.permission.service.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuController extends DefaultController {
	
	@Autowired
	private MenuService menuService;

	@GetMapping("/{accountId}")
	public DefaultResponse getMenusByAccountId(@PathVariable("accountId") Long accountId)
	{
		try {
			List<MenuDto> result = menuService.getMenusByAccountId(accountId);
			return new DefaultResponse().setData(result);
			
		} catch (Exception e) {
			return super.renderErrorResponse(e);
		}
	}
	
}
