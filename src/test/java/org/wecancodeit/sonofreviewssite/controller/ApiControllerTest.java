package org.wecancodeit.sonofreviewssite.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.wecancodeit.sonofreviewssite.model.Account;
import org.wecancodeit.sonofreviewssite.model.Category;
import org.wecancodeit.sonofreviewssite.model.Comment;
import org.wecancodeit.sonofreviewssite.model.Review;
import org.wecancodeit.sonofreviewssite.model.Tag;
import org.wecancodeit.sonofreviewssite.repository.AccountRepository;
import org.wecancodeit.sonofreviewssite.repository.CategoryRepository;
import org.wecancodeit.sonofreviewssite.repository.CommentRepository;
import org.wecancodeit.sonofreviewssite.repository.ReviewRepository;
import org.wecancodeit.sonofreviewssite.repository.TagRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(ReviewController.class)
public class ApiControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ReviewRepository reviewRepo;
	@MockBean
	private CategoryRepository categoryRepo;
	@MockBean
	private AccountRepository accountRepo;
	@MockBean
	private CommentRepository commentRepo;
	@MockBean
	private TagRepository tagRepo;

	@Mock
	Account accountOne;

	@Mock
	Category categoryOne;

	@Mock
	Comment commentOne;

	@Mock
	Review reviewOne;

	@Mock
	Tag tagOne;

	@Test
	public void shouldBeOkWhenAccessingRewiews() throws Exception {
		when(reviewRepo.findById(21L)).thenReturn(Optional.of(reviewOne));
		mockMvc.perform(get("/api/reviews/21")).andExpect(status().isOk());
	}

	@Test
	public void shouldBeOkWhenAccessingCategorys() throws Exception {
		when(categoryRepo.findById(21L)).thenReturn(Optional.of(categoryOne));
		mockMvc.perform(get("/api/categories/21")).andExpect(status().isOk());
	}

	@Test
	public void shouldBeOkWhenAccessingTags() throws Exception {
		when(tagRepo.findById(21L)).thenReturn(Optional.of(tagOne));
		mockMvc.perform(get("/api/tags/21")).andExpect(status().isOk());
	}

	@Test
	public void shouldAddATag() throws Exception {
		when(tagRepo.findById(21L)).thenReturn(Optional.of(tagOne));
		mockMvc.perform(get("/api/reviews/21/tags/add")).andExpect(status().isOk());
	}

}