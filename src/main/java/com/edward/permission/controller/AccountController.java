package com.edward.permission.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edward.permission.dto.AccountDto;
import com.edward.permission.response.DefaultResponse;
import com.edward.permission.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController extends DefaultController {
	
	@Autowired
	private AccountService accountService;

	@GetMapping
	public DefaultResponse getAllAccounts() 
	{
		try {
			List<AccountDto> result = accountService.getAllAccounts();
			return new DefaultResponse().setData(result);
			
		} catch (Exception e) {
			return super.renderErrorResponse(e);
		}
	}
	
	@GetMapping("/{roleId}")
	public DefaultResponse getAccountsByRoleId(@PathVariable("roleId") Long roleId)
	{
		try {
			List<AccountDto> result = accountService.getAccountsByRoleId(roleId);
			return new DefaultResponse().setData(result);
			
		} catch (Exception e) {
			return super.renderErrorResponse(e);
		}
	}
	
}
