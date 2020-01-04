package com.edward.permission.dto;

import com.edward.permission.entity.Account;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class AccountDto {
	
	@JsonProperty("account_id")
	@Getter @Setter
	private Long accountId;
	
	@JsonProperty("account")
	@Getter @Setter
	private String account;
	
	@JsonProperty("name")
	@Getter @Setter
	private String name;
	
	@JsonProperty("sex")
	@Getter @Setter
	private Character sex;
	
	public static AccountDto valueOf(Account account) 
	{
		return AccountDto.builder().accountId(account.getAccountId()).account(account.getAccount())
								   .name(account.getName()).sex(account.getSex()).build();
	}
	
}
