package org.wecancodeit.sonofreviewssite.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@JsonIgnore
	@ManyToOne
	private Category category;

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
