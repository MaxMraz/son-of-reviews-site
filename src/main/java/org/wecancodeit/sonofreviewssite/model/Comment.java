package org.wecancodeit.sonofreviewssite.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Comment {
	@GeneratedValue @Id private Long id;
	@ManyToOne
	private Account account;
	@Lob
	private String content;
	@ManyToOne
	private Review review;
	
	Comment() {}

	public Comment(Account account, String content, Review review) {
		this.account = account;
		this.content = content;
		this.review = review;
	}

	public Long getId() {
		return id;
	}

	public Account getAccount() {
		return account;
	}

	public String getContent() {
		return content;
	}

	public Review getReview() {
		return review;
	}
	
	
	
}
