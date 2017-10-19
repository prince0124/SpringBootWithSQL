package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.EnumDemo;
import com.example.demo.dao.DataPersistanceDaoInterface;
import com.example.demo.dao.QueryDataPersistance;
import com.example.demo.entitydemo.EntityDemo;
import com.example.demo.service.EntityDemoSer;

@Controller
@RequestMapping(path="/api")
public class ControllerDemo {
	
	private static final Log logger=LogFactory.getLog(ControllerDemo.class);

	@Autowired
	private EntityDemoSer entityDemoSer;
	
	@Autowired
	private AbstractData abstractData;
	
	
	@Autowired
	private QueryDataPersistance dataPersistanceDao;
	
	@Value("${my.name}")
	public String name;
	
	@RequestMapping(path = {"dev3"},method=RequestMethod.GET)
	public @ResponseBody String devTest() {
		logger.info("Inside the test method");
		return "Dev Test";
	}

	@RequestMapping(path = {"/atest"},method=RequestMethod.GET)
	public @ResponseBody String AbstractTest() {
		logger.info("Inside the test method");
		int i=abstractData.add();
		return i+"  :AbstractMethod is Working";
	}
	
	@RequestMapping(path = {"/test","/test2"},method=RequestMethod.GET)
	public @ResponseBody String test() {
		logger.info("Inside the test method");
		return "Without Controller";
	}

	@RequestMapping(path = "/prop/{name1}",method=RequestMethod.GET)
	public @ResponseBody String propValue(@PathVariable String name1) {
		return name + " " + name1;
	}

	@RequestMapping(path = "/enum",method=RequestMethod.GET)
	public @ResponseBody String enumValue() {
		return  "ENUM Value: "+EnumDemo.ADD.cal(6,3);
	}
	
	@RequestMapping(value="/jsonValue", method=RequestMethod.GET )
	public @ResponseBody List<EntityDemo> getJson()
	{
		EntityDemo ed=new EntityDemo(1,"Prince", "Math");
		EntityDemo ed2=new EntityDemo(2,"Uppal", "Science");
		List<EntityDemo> list=new ArrayList<EntityDemo>();
		list.add(ed);
		list.add(ed2);
		return list;
	}
	//Method Header example
	@RequestMapping(value="/method4", headers="namep=prince",method=RequestMethod.GET)
	@ResponseBody
	public String method4(){
		return "method4";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.PUT)
	public @ResponseBody List<EntityDemo> add(@RequestBody EntityDemo demo)
	{
		/*EntityDemo demo=new EntityDemo();
		for (int i = 0; i < 10; i++) {
			demo.setName("Prince :"+i);
			demo.setCourse("Science :"+i);
			entityDemo.addEntity(demo);
		}*/
		entityDemoSer.addEntity(demo);
		List<EntityDemo> list=new ArrayList<>();
		list.add(demo);
		
		return list;
		
	}
	
	@RequestMapping(value="get/{id}",method=RequestMethod.GET)
	public ResponseEntity<EntityDemo> get(@PathVariable int id)
	{
		EntityDemo demo=entityDemoSer.getEntityById(id);
		return new ResponseEntity<EntityDemo>(demo,HttpStatus.OK);
	}
	
	@RequestMapping(value="getAll" ,method=RequestMethod.GET)
	public ResponseEntity<List<Object>> getAll()
	{
		
		List<Object> demo= entityDemoSer.getAll();
		return new ResponseEntity<List<Object>>(demo,HttpStatus.OK);
	}
	@RequestMapping(value="query/{id}" ,method=RequestMethod.GET)
	public @ResponseBody List<EntityDemo> getQuery(@PathVariable int id)
	{
		System.out.println("Inside Query Test");
		return dataPersistanceDao.getQuery(id);
	}
	@RequestMapping(value="course/{id}" ,method=RequestMethod.GET)
	public @ResponseBody List<EntityDemo> getQueryCourse(@PathVariable String id)
	{
		System.out.println("Inside Query Test");
		return dataPersistanceDao.getQueryCourse(id);
	}
	
	
	
	//fallback method
	@RequestMapping("*")
	@ResponseBody
	public String fallbackMethod(){
		return "fallback method";
	}
	
}
