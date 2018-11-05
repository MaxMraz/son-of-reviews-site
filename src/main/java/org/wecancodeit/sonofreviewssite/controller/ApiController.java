package org.wecancodeit.sonofreviewssite.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.sonofreviewssite.model.Category;
import org.wecancodeit.sonofreviewssite.model.Comment;
import org.wecancodeit.sonofreviewssite.model.Review;
import org.wecancodeit.sonofreviewssite.model.Tag;
import org.wecancodeit.sonofreviewssite.repository.AccountRepository;
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

	@Autowired
	AccountRepository accountRepo;

	@GetMapping("/api/reviews/{id}")
	public Review showReview(@PathVariable(value = "id") Long id) {
		return reviewRepo.findById(id).get();
	}

	@GetMapping("/api/reviews/{id}/tags")
	public Collection<Tag> showReviewTags(@PathVariable(value = "id") Long id) {
		return reviewRepo.findById(id).get().getTags();
	}

	@GetMapping("/api/categories/{id}")
	public Category showCategory(@PathVariable(value = "id") Long id) {
		return categoryRepo.findById(id).get();
	}

	@GetMapping("/api/reviews/{id}/comments")
	public Collection<Comment> showReviewComments(@PathVariable(value = "id") Long id) {
		return reviewRepo.findById(id).get().getComments();
	}

	@GetMapping("/api/tags/{id}")
	public Tag showTag(@PathVariable(value = "id") Long id) {
		return tagRepo.findById(id).get();
	}

	@PostMapping("/api/reviews/{id}/tags/add")
	public void addNewTag(@PathVariable(value = "id") Long id, @RequestBody String body) {
		Review review = reviewRepo.findById(id).get();
		boolean tagAlreadyApplied = false;
		for (Tag tag : review.getTags()) {
			if (tag.getName().equalsIgnoreCase(body)) {
				tagAlreadyApplied = true;
			}
		}
		if (tagAlreadyApplied == false) {
			applyTag(body, id);
		}

	}

	public void applyTag(String tagName, Long reviewId) {
		Review review = reviewRepo.findById(reviewId).get();
		// this is a new tag
		if (tagRepo.findByName(tagName) == null) {
			Tag tag = new Tag(tagName);
			review.addTag(tag);
			tag.addReview(review);
			tag = tagRepo.save(tag);
			review = reviewRepo.save(review);
		} else { // this tag already exists
			Tag tag = tagRepo.findByName(tagName);
			review.addTag(tag);
			tag.addReview(review);
			tag = tagRepo.save(tag);
			review = reviewRepo.save(review);
		}

	}

	@PostMapping("/api/reviews/{id}/tags/remove")
	public void removeTag(@PathVariable(value = "id") Long id, @RequestBody String body) {
		Tag tag = tagRepo.findByName(body);
		Review review = reviewRepo.findById(id).get();
		review.removeTag(tag);
		tag.removeReview(review);
		tag = tagRepo.save(tag);
		review = reviewRepo.save(review);
	}

	//////////////////////// comments

	@GetMapping("/api/comments/{id}")
	public Tag showComment(@PathVariable(value = "id") Long id) {
		return tagRepo.findById(id).get();
	}

}
