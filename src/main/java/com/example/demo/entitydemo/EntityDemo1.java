package com.example.demo.entitydemo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="articles")
public class EntityDemo1 {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int article_id;
	@Column
	private String title;
	@Column
	private String category;
	
	public int getArticle_id() {
		return article_id;
	}
	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public EntityDemo1() {}
	public EntityDemo1(int id,String title,String category)
	{
		this.article_id=id;
		this.title=title;
		this.category=category;
	}

}