package org.wecancodeit.sonofreviewssite.repository;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.sonofreviewssite.model.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

}
