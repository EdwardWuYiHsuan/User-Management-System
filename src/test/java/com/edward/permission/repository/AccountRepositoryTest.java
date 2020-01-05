package com.edward.permission.repository;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.edward.permission.entity.Account;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

	@Autowired
	private AccountRepository accountRepo;
	
	@Autowired
    private TestEntityManager testEntityManager;
	
	@Test
	public void findById() 
	{
		final String accountRef = "test_account", nameRef = "test_name";
		final Character sexRef = Character.valueOf('M');
		
		Account account = Account.builder().account(accountRef).name(nameRef).sex(sexRef).build();
		account = testEntityManager.persist(account);
		testEntityManager.flush();

		Optional<Account> accountOpt = accountRepo.findById(account.getAccountId());
		Assert.assertTrue(accountOpt.isPresent());
		
		Account testAccount = accountOpt.get();
		Assert.assertEquals(accountRef, testAccount.getAccount());
		Assert.assertEquals(nameRef, testAccount.getName());
		Assert.assertEquals(sexRef, testAccount.getSex());
	}
	
}
