package com.example.demo.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entitydemo.EntityDemo;

public interface QueryDataPersistance extends CrudRepository<EntityDemo, String> {
	
	String GET_COURSE="SELECT p FROM EntityDemo p WHERE p.course=?1";
	
	@Query(value="SELECT p FROM EntityDemo p WHERE p.article_id=?1")
	public List<EntityDemo> getQuery(Integer id);

	@Query(GET_COURSE)
	public List<EntityDemo> getQueryCourse(String id);
}
