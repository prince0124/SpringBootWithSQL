package com.example.demo.entitydemo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prince")
public class EntityDemo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int article_id;
	@Column
	private String name;
	@Column
	private String course;
	
	public EntityDemo() {}
	public EntityDemo(int article_id,String name,String course)
	{
		this.article_id=article_id;
		this.name=name;
		this.course=course;
		
	}

	public int getId() {
		return article_id;
	}

	public void setId(int id) {
		this.article_id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

}
