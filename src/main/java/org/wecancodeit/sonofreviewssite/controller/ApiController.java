package org.wecancodeit.sonofreviewssite.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.sonofreviewssite.model.Category;
import org.wecancodeit.sonofreviewssite.model.Review;
import org.wecancodeit.sonofreviewssite.model.Tag;
import org.wecancodeit.sonofreviewssite.repository.CategoryRepository;
import org.wecancodeit.sonofreviewssite.repository.ReviewRepository;
import org.wecancodeit.sonofreviewssite.repository.TagRepository;

@RestController
public class ApiController {

	@Autowired
	TagRepository tagRepo;
	
	@Autowired
	ReviewRepository reviewRepo;
	
	@Autowired
	CategoryRepository categoryRepo;
	
	@GetMapping("/api/reviews/{id}")
	public Review showReview(@PathVariable(value = "id") Long id) {
		return reviewRepo.findById(id).get();
	}
	
	@GetMapping("/api/reviews/{id}/tags")
	public Collection<Tag> showReviewTags(@PathVariable(value = "id") Long id) {
		return reviewRepo.findById(id).get().getTags();
	}
	
	@GetMapping("api/categories/{id}")
	public Category showCategory(@PathVariable(value = "id") Long id) {
		return categoryRepo.findById(id).get();
	}
	
	@GetMapping("api/tags/{id}")
	public Tag showTag(@PathVariable(value = "id") Long id) {
		return tagRepo.findById(id).get();
	}
	
	@PostMapping("api/reviews/{id}/tags/add")
	public void addNewTag(@PathVariable(value = "id") Long id, @RequestBody String body) {
		Tag tag = new Tag(body);
		Review review = reviewRepo.findById(id).get();
		review.addTag(tag);
		tag.addReview(review);
		tag = tagRepo.save(tag);
		review = reviewRepo.save(review);
		
	}
	
}
