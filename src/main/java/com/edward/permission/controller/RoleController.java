package com.edward.permission.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edward.permission.dto.RoleDto;
import com.edward.permission.response.DefaultResponse;
import com.edward.permission.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController extends DefaultController {
	
	@Autowired
	private RoleService roleService;

	@GetMapping
	public DefaultResponse getAllRoles() 
	{
		try {
			List<RoleDto> result = roleService.getAllRoles();
			return new DefaultResponse().setData(result);
			
		} catch (Exception e) {
			return super.renderErrorResponse(e);
		}
	}
	
	@GetMapping("/{roleId}")
	public DefaultResponse getRole(@PathVariable("roleId") Long roleId)
	{
		try {
			RoleDto roleDto = roleService.getRole(roleId);
			return new DefaultResponse().setData(roleDto);
			
		} catch (Exception e) {
			return super.renderErrorResponse(e);
		}
	}
	
}
