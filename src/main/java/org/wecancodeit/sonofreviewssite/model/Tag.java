package org.wecancodeit.sonofreviewssite.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {
	@GeneratedValue @Id private Long id;
	private String name;
	@ManyToMany
	Collection<Review> reviews;
	
	Tag() {}

	public Tag(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Collection<Review> getReviews() {
		return reviews;
	}
	
	
	
	
}
