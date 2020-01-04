package com.edward.permission.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edward.permission.dto.RoleDto;
import com.edward.permission.entity.Role;
import com.edward.permission.enumeration.APICode;
import com.edward.permission.exception.ApiException;
import com.edward.permission.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepo;
	
	public List<RoleDto> getAllRoles() throws Exception
	{
		List<RoleDto> roleList = new ArrayList<>();
		Iterable<Role> roleIter = roleRepo.findAll();
		for (Iterator<Role> iterator = roleIter.iterator(); iterator.hasNext();) {
			roleList.add(RoleDto.valueOf(iterator.next()));
		}
		
		return roleList;
	}
	
	public RoleDto getRole(Long roleId) throws Exception
	{
		Optional<Role> roleOpt = roleRepo.findById(roleId);
		if (roleOpt.isPresent()) {
			return RoleDto.valueOf(roleOpt.get());
		} else {
			throw new ApiException(APICode.InvalidParameter, "invalid-role-id");
		}
	}
	
}
