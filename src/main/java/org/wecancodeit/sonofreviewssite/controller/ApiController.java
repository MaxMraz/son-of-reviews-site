package org.wecancodeit.sonofreviewssite.controller;

import org.json.JSONException;
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

import net.minidev.json.JSONObject;

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
	
	@GetMapping("api/categories/{id}")
	public Category showCategory(@PathVariable(value = "id") Long id) {
		return categoryRepo.findById(id).get();
	}
	
	@GetMapping("api/tags/{id}")
	public Tag showTag(@PathVariable(value = "id") Long id) {
		return tagRepo.findById(id).get();
	}
	
}
