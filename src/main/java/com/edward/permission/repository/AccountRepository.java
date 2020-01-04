package com.edward.permission.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edward.permission.entity.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

}
