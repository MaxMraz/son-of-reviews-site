package org.wecancodeit.sonofreviewssite.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Review {
	@Id
	@GeneratedValue
	private Long id;
	private String reviewName;
	@Lob
	private String reviewDescription;
	private String recomendation;
	private String reviewRating;
	private String reviewImage;

	@ManyToOne
	private Category category;
	
	@ManyToMany
	private Collection<Tag> tags;

	public Review() {
	}

	public Review(String reviewName, String reviewDescription, String recomendation, String reviewRating,
			String reviewImage, Category category) {
		this.reviewName = reviewName;
		this.reviewDescription = reviewDescription;
		this.recomendation = recomendation;
		this.reviewRating = reviewRating;
		this.reviewImage = reviewImage;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public String getReviewName() {
		return reviewName;
	}

	public String getReviewDescription() {
		return reviewDescription;
	}

	public String getRecomendation() {
		return recomendation;
	}

	public String getReviewRating() {
		return reviewRating;
	}

	public String getReviewImage() {
		return reviewImage;
	}

	public Category getCategory() {
		return category;
	}

	


}
