package org.wecancodeit.sonofreviewssite.model;

import java.util.Collection;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wecancodeit.sonofreviewssite.model.Account;
import org.wecancodeit.sonofreviewssite.repository.TagRepository;
import org.junit.Test;

//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class ReviewTest {
//	
//	@Autowired
//	TagRepository tagRepo;
//
//	@Test
//	public void shouldAddATag() {
//		Review underTest = new Review();
//		Tag tag = new Tag("foo");
//		
//		underTest.addTag(tag);
//		System.out.println(underTest.getTags());
//		
//	}
//	
//}
