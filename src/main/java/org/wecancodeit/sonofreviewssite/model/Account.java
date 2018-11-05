package org.wecancodeit.sonofreviewssite.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Account {
	@GeneratedValue @Id private Long id;
	private String username;
	@OneToMany(mappedBy="account")
	private Collection<Comment> comments;
	
	Account() {}

	public Account(String username) {
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public Collection<Comment> getComments() {
		return comments;
	}
	
	
	
	
}
