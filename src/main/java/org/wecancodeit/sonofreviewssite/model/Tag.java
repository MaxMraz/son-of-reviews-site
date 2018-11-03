package org.wecancodeit.sonofreviewssite.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tag {
	@GeneratedValue
	@Id
	private Long id;
	private String name;
	
	@JsonIgnore
	@ManyToMany
	private Set<Review> reviews = new HashSet<Review>();
	
	public Tag() {}

	public Tag(String name) {
		this.name = name;
	}
	
	public Tag(String tagName, Review review) {
		this.name = tagName;
		addReview(review);
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public Set<Review> getReviews() {
		return reviews;
	}

	public void addReview(Review review) {
		reviews.add(review);
	}
	
	public void removeReview(Review review) {
		reviews.remove(review);
	}


	
}
