package org.wecancodeit.sonofreviewssite.model;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.wecancodeit.sonofreviewssite.repository.TagRepository;

//@RunWith(SpringRunner.class)
//@DataJpaTest
public class ReviewTest {
	
	@Autowired
	TagRepository tagRepo;

	@Test
	public void shouldAddATag() {
		Review underTest = new Review();
		Tag tag = new Tag("foo");
		
		underTest.addTag(tag);
		System.out.println(underTest.getTags());
		
	}
	
}
