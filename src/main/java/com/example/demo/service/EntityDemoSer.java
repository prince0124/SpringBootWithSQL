package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DataPersistanceDao;
import com.example.demo.entitydemo.EntityDemo;

@Service
public class EntityDemoSer {
	//String QUERY_TEST="Select * from prince where article_id>2;";

	@Autowired
	private DataPersistanceDao daoInterface;
	
	public EntityDemo getEntityById(int id)
	{
		EntityDemo ent=daoInterface.getDataById(id);
		return ent;
	}
	
	public void addEntity(EntityDemo demo)
	{
		daoInterface.addEntity(demo);
	}
	
	public List<Object> getAll()
	{
		return daoInterface.getAll();
	}
	 
	/*public List<EntityDemo> queryTest()
	{
		return daoInterface.queryTest();
	}*/
}
