package com.edward.permission.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edward.permission.entity.Menu;

@Repository
public interface MenuRepository extends CrudRepository<Menu, Long> {

}
