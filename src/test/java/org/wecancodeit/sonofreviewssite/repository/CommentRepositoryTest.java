package org.wecancodeit.sonofreviewssite.repository;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wecancodeit.sonofreviewssite.model.Comment;
import org.wecancodeit.sonofreviewssite.model.Review;
import org.wecancodeit.sonofreviewssite.model.Account;
import org.wecancodeit.sonofreviewssite.model.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {
	@Resource
	CommentRepository repo;
	@Resource
	CategoryRepository categoryRepo;
	@Resource
	ReviewRepository reviewRepo;
	@Resource
	AccountRepository accountRepo;

	@Test
	public void shouldReturnAllComments() {
		// Arrange
		Category category = new Category("a");
		categoryRepo.save(category);
		Review review = new Review ("a","a","a","a","a", category);
		reviewRepo.save(review);
		Account account = new Account("a");
		accountRepo.save(account);
		Comment comment = new Comment(account, "a", review);
		Comment comment2 = new Comment(account, "b", review);
		comment = repo.save(comment);
		comment2 = repo.save(comment2);

		// Act
		Iterable<Comment> result = repo.findAll();

		// Assert
		assertThat(result, hasItems(comment));
	}
}
