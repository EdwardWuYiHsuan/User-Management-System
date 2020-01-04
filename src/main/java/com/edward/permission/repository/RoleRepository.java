package com.edward.permission.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edward.permission.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

}
