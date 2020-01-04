package com.edward.permission.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edward.permission.dto.MenuDto;
import com.edward.permission.entity.Account;
import com.edward.permission.entity.AccountRole;
import com.edward.permission.entity.Menu;
import com.edward.permission.enumeration.APICode;
import com.edward.permission.exception.ApiException;
import com.edward.permission.repository.AccountRepository;
import com.edward.permission.repository.MenuRepository;

@Service
public class MenuService {

	@Autowired
	private AccountRepository accountRepo;
	@Autowired
	private MenuRepository menuRepo;
	
	public List<MenuDto> getAllMenus() 
	{
		List<MenuDto> menuList = new ArrayList<>();
		Iterable<Menu> menuIter = menuRepo.findAll();
		for (Iterator<Menu> iterator = menuIter.iterator(); iterator.hasNext();) {
			menuList.add(MenuDto.valueOf(iterator.next()));
		}
		
		return menuList;
	}
	
	public List<MenuDto> getMenusByAccountId(Long accountId) throws Exception
	{
		List<MenuDto> menuList = new ArrayList<>();
		Optional<Account> accountOpt = accountRepo.findById(accountId);
		if (!accountOpt.isPresent()) {
			throw new ApiException(APICode.InvalidParameter, "invalid-account-id");
		} else {
			Set<AccountRole> accountRoles = accountOpt.get().getAccountRole();
			for (AccountRole ar : accountRoles) {
				Set<Menu> menus = ar.getRole().getMenus();
				for (Menu menu : menus) {
					menuList.add(MenuDto.valueOf(menu));
				}
			}
		}
		
		return menuList;
	}
	
}
