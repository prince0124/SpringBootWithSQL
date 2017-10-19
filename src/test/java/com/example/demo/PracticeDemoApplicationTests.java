package com.example.demo;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("default")
public class PracticeDemoApplicationTests {

	private static final Log logger = LogFactory.getLog(PracticeDemoApplicationTests.class);

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Before
	public void checkTest() {
		System.out.println("Test is running");
	}

	@Test
	public void hello() {
		String value = null;
		try {
			value=testRestTemplate.getForObject("/api/test", String.class);
			logger.info("===========Helloooo==============");
			logger.info(value);
			//responseEntity = testRestTemplate.getForEntity("http://localhost:8080/test", String.class);
		} catch (Exception e) {
			logger.error("Exception"+e.getMessage());
		}

		logger.info("check  " + value);

		assertEquals(value, "Without Controller");
	}

	@SuppressWarnings("unchecked")
	@Test
	public void jsonValue()
	{
		HttpStatus responseEntity=null;
		List<String> list = null;
		try
		{
			logger.info("================Json Value=======================");
			responseEntity=testRestTemplate.getForEntity("/api/jsonValue", String.class).getStatusCode();
			logger.info("================"+responseEntity+"=======================");
			list=testRestTemplate.getForObject("/api/jsonValue", List.class);
			logger.info("Completed =======================");
		}
		catch(Exception e)
		{
			logger.info(responseEntity+"   "+e);
		}
		logger.info(list);
	}
	
	@SuppressWarnings("unchecked")
	@Test //ResponseEntity
	public void responseEnt()
	{
		ResponseEntity<String> responseEntity=null;
		List<String> list = null;
		try
		{
			logger.info("================Json Value=======================");
			responseEntity=testRestTemplate.getForEntity("/api/jsonValue", String.class);
			logger.info("================"+responseEntity.getBody()+"=======================");
			logger.info("================"+responseEntity.getStatusCodeValue()+"=======================");
			logger.info("Completed =======================");
		}
		catch(Exception e)
		{
			logger.info(responseEntity+"   "+e);
		}
		logger.info(list);
	}
	@Test
	public void contextLoads() {
	}

}
