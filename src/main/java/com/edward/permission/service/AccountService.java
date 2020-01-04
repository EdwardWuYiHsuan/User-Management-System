package com.edward.permission.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edward.permission.dto.AccountDto;
import com.edward.permission.entity.AccountRole;
import com.edward.permission.entity.Role;
import com.edward.permission.enumeration.APICode;
import com.edward.permission.exception.ApiException;
import com.edward.permission.repository.RoleRepository;

@Service
public class AccountService {

	@Autowired
	private RoleRepository roleRepo;
	
	public List<AccountDto> getAccountsByRoleId(Long roleId) throws Exception
	{
		List<AccountDto> accountList = new ArrayList<>();
		Optional<Role> roleOpt = roleRepo.findById(roleId);
		if (!roleOpt.isPresent()) {
			throw new ApiException(APICode.InvalidParameter, "invalid-role-id");
		} else {
			Set<AccountRole> accountRoles = roleOpt.get().getAccountRole();
			for (AccountRole ar : accountRoles) {
				AccountDto accountDto = AccountDto.valueOf(ar.getAccount());
				accountList.add(accountDto);
			}
			
			return accountList;
		}
	}
	
}
