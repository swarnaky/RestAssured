package com.employeeapi.testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC002_Get_Single_Employee_Record extends TestBase{
	
	@BeforeClass
	public void getSingleEmployeeRecord() throws Exception {
		
		logger.info("------- Starting TC002_Get_Single_Employee_Record");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, "/employee/"+empID);
		 
		Thread.sleep(10);
		
	}

	@Test
	public void getResponseBody() {
		logger.info("---------- print response body -------------");
		String responseBody = response.getBody().asString();
		logger.info("Response body ---> "+ responseBody);
	}
}
