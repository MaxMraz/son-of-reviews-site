package org.wecancodeit.sonofreviewssite.repository;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wecancodeit.sonofreviewssite.model.Tag;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TagRepositoryTest {
	@Resource
	TagRepository repo;

	@Test
	public void shouldReturnAllTags() {
		// Arrange
		Tag tag = repo.save(new Tag(""));
		Tag tag2 = repo.save(new Tag(""));

		// Act
		Iterable<Tag> result = repo.findAll();

		// Assert
		assertThat(result, hasItems(tag));
	}
}
