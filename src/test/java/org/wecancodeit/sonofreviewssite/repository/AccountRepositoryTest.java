package org.wecancodeit.sonofreviewssite.repository;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wecancodeit.sonofreviewssite.model.Account;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {
	@Resource
	AccountRepository repo;

	@Test
	public void shouldReturnAllAccounts() {
		// Arrange
		Account Account = repo.save(new Account(""));
		Account Account2 = repo.save(new Account(""));

		// Act
		Iterable<Account> result = repo.findAll();

		// Assert
		assertThat(result, hasItems(Account));
	}
}
