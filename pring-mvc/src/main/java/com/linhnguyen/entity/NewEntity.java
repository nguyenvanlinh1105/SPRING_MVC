package com.linhnguyen.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
@Entity
@Table(name="new")
public class NewEntity {
//	from class -> db == same dotnet :))
	@Id
	@Ge(strategy = GenerationType.IDENTITY)
	private Long Id;
	@Column
	private String title;
	@Column
	private String thumnail;
	@Column
	private String shortDescription;
	@Column
	private String content;
	
	
}
