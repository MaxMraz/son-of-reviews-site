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

	@Test
	public void shouldReturnAllContacts() {
		// Arrange
		Category category = new Category("a");
		Review review = new Review ("a","a","a","a","a", category);
		Account account = new Account("a");
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
