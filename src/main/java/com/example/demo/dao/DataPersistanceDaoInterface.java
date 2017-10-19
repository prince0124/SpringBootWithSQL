package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.example.demo.entitydemo.EntityDemo;

public interface DataPersistanceDaoInterface {
	
	List<Object> getAll();
	EntityDemo getDataById(int id);
	void addEntity(EntityDemo demo);
	void updateEntity(EntityDemo demo);
	void deleteEntity(EntityDemo demo);
	boolean entityExists(String name, String course);
	void getJoins(EntityDemo demo);
	
	
}
