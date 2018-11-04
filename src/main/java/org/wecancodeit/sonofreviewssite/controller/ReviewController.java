package org.wecancodeit.sonofreviewssite.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.sonofreviewssite.model.Account;
import org.wecancodeit.sonofreviewssite.model.Comment;
import org.wecancodeit.sonofreviewssite.model.Review;
import org.wecancodeit.sonofreviewssite.repository.AccountRepository;
import org.wecancodeit.sonofreviewssite.repository.CategoryRepository;
import org.wecancodeit.sonofreviewssite.repository.CommentRepository;
import org.wecancodeit.sonofreviewssite.repository.ReviewRepository;
import org.wecancodeit.sonofreviewssite.repository.TagRepository;

@Controller
public class ReviewController {

	@Resource
	CategoryRepository categoryRepo;

	@Resource
	ReviewRepository reviewRepo;

	@Resource
	CommentRepository commentRepo;

	@Resource
	AccountRepository accountRepo;

	@Resource
	TagRepository tagRepo;

	@RequestMapping("categories")
	public String listCourses(Model model) {
		model.addAttribute("categories", categoryRepo.findAll());
		return "categories";
	}

	@RequestMapping("categories/{id}")
	public String listPerson(@PathVariable(value = "id") Long id, Model model) {
		model.addAttribute("category", categoryRepo.findById(id).get());
		model.addAttribute("categories", categoryRepo.findAll());
		return "category";
	}

	@RequestMapping("/reviews")
	public String getContacts(Model model) {
		model.addAttribute("reviews", reviewRepo.findAll());
		model.addAttribute("categories", categoryRepo.findAll());
		return "reviews";
	}

	@RequestMapping("/reviews/{id}")
	public String getContact(@PathVariable(value = "id") Long id, Model model) {
		model.addAttribute("review", reviewRepo.findById(id).get());
		model.addAttribute("categories", categoryRepo.findAll());
		return "review";
	}

	@RequestMapping("/tags/{id}")
	public String getTagPage(@PathVariable(value = "id") Long id, Model model) {
		model.addAttribute("tag", tagRepo.findById(id).get());
		return "tag";
	}

	@RequestMapping("/tags")
	public String showAllTags(Model model) {
		model.addAttribute("tags", tagRepo.findAll());
		return "tags";
	}

	@PostMapping("/reviews/{id}/comments/add")
	public String addNewComment(@PathVariable(value = "id") Long id, String accountName, String fullComment) {
		System.out.println("MAXMAXMAX");
		Review review = reviewRepo.findById(id).get();
		Account account = new Account(accountName);
		Comment comment = new Comment(account, fullComment, review);
		review.addComment(comment);
		review = reviewRepo.save(review);
//		comment = commentRepo.save(comment);
		return "redirect:/reviews/{id}";
	}

}
