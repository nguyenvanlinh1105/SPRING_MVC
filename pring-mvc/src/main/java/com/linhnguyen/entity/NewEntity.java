package com.linhnguyen.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="new")
public class NewEntity extends BaseEntity {
//	from class -> db == same dotnet :))
	// primary key & not null
	
	@Column(name="title")
	private String title;
	
	@Column(name="thumnail")
	private String thumnail;
	
	@Column(name="shortdescription", columnDefinition="text")
	private String shortDescription;
	
	@Column(name="content", columnDefinition="text")
	private String content;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumnail() {
		return thumnail;
	}

	public void setThumnail(String thumnail) {
		this.thumnail = thumnail;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	

	
	
	
	
	
}
