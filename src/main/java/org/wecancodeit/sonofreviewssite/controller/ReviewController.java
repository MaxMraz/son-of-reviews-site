package org.wecancodeit.sonofreviewssite.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.sonofreviewssite.model.Account;
import org.wecancodeit.sonofreviewssite.model.Comment;
import org.wecancodeit.sonofreviewssite.repository.AccountRepository;
import org.wecancodeit.sonofreviewssite.repository.CategoryRepository;
import org.wecancodeit.sonofreviewssite.repository.CommentRepository;
import org.wecancodeit.sonofreviewssite.repository.ReviewRepository;


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
	
	
	
	@PostMapping("/reviews/{id}")
	public String reveiwComment(@PathVariable(value = "id") Long id, String accountName, String fullComment) {
		//TODO check if user already exists.
		Account account = new Account(accountName);
		account = accountRepo.save(account);
		Comment comment = new Comment(account, fullComment, reviewRepo.findById(id).get());
		comment = commentRepo.save(comment);
		return "redirect:/reviews/{id}";
		
	}
}
