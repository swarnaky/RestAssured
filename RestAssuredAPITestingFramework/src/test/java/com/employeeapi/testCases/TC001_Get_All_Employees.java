package com.employeeapi.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;

public class TC001_Get_All_Employees extends TestBase {
	
	@BeforeClass
	void getAllEmployees() throws Exception {
	
		logger.info("------Started TC001_Get_All_Employees------------");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, "/employees");
		
		Thread.sleep(3);
	}
	
	@Test
	void CheckResponseBody() {
		logger.info("---------Checking response body--------");
		String responseBody = response.getBody().asString();
		logger.info("Response body :"+responseBody);
		Assert.assertTrue(responseBody!=null);
	}
	
	@Test
	void DisplayAllHeaders() {
		logger.info("------------Display all headers-----------");
		Headers allheaders = response.getHeaders();
		logger.info("Headers are :" + allheaders);
		
	}
	
	@Test
	void CheckStatusCode() {
		logger.info("-----------check Status code----------");
		int statuscode = response.getStatusCode();
		logger.info("status code is -->" + statuscode);
		Assert.assertEquals(statuscode, 200);
		}
	
	@Test
	void CheckResponseTime() {
		logger.info("-------check Response time---------");
		long responsetime = response.getTime();
		logger.info("Response time --->"+ responsetime);
		if(responsetime>10000) {
			logger.info("Response time more than 2000");
		}
		Assert.assertTrue(responsetime<10000);
	}
	
	@Test
	void CheckStatusLine() {
		logger.info("---------check status line---------");
		String statusline = response.getStatusLine();
		logger.info("Status line -->"+statusline);
		Assert.assertEquals(statusline,"HTTP/1.1 200 OK");
		
	}
	
	@Test
	void CheckContentLength() {
		logger.info("------------check content length-------");;
		String contentlength = response.header("Content-Length");
		logger.info("Content length is --->"+contentlength);
		if(Integer.parseInt(contentlength)<200) {
			logger.warn("content length is less than 200");
			
		}
		Assert.assertTrue(Integer.parseInt(contentlength)>100);
	}
	
	@AfterClass
	void tearDown() {
		logger.info("--------Finished TC001_Get_All_Employess---------");
	}

}

