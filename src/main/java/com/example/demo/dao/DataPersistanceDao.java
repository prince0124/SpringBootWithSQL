package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entitydemo.EntityDemo;
import com.example.demo.entitydemo.EntityDemo1;

@Transactional
@Repository
public class DataPersistanceDao implements DataPersistanceDaoInterface {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getAll() {
			String hql = "FROM articles as ent ORDER BY ent.article_id";
			//String sql="SELECT *  From articles LEFT JOIN prince ON articles.article_id = prince.article_id";
			//System.out.println((List<Object>) entityManager.createQuery(sql).getResultList());
			return (List<Object>) entityManager.createQuery(hql).getResultList();
		
	}

	@Override
	public EntityDemo getDataById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(EntityDemo.class, id);
	}

	@Override
	public void addEntity(EntityDemo demo) {
		// TODO Auto-generated method stub
		entityManager.persist(demo);
		
	}

	@Override
	public void updateEntity(EntityDemo demo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEntity(EntityDemo demo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean entityExists(String name, String course) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void getJoins(EntityDemo demo) {
		// TODO Auto-generated method stub
		
	}


	

}
