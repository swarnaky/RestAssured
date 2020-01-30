package com.employeeapi.testCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;
import com.employeeapi.utilities.RestUtilities;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class TC003_Post_Employee_Record extends TestBase {
	
	String empname = RestUtilities.empName();
	String empsalary = RestUtilities.empSal();
	String empage = RestUtilities.empAge();
	
	@BeforeClass
	public void postEmployeeRecord() throws Exception {
		logger.info("-------------Starting TC003_Post_Employee_Record-------------");
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		httpRequest = RestAssured.given();
		//JSONObject is a class that represents a simple JSON .we can add key value pairs using the put method 
		//{"name":"test123","salary":"123","age":"34"}
		JSONObject requestParams = new JSONObject();
		
		  requestParams.put("name", "test1234");
		  requestParams.put("salary", "2000");
		  requestParams.put("age", "24");
		 
		/*
		 * requestParams.put("FirstName", "swapna14"); requestParams.put("LastName",
		 * "thota"); requestParams.put("UserName", "Tests14");
		 * requestParams.put("Password", "Test123"); requestParams.put("Email",
		 * "swapna14@test.com");
		 */
		//Add a header stating the request body is a json
		httpRequest.header("Content-Type", "application/json");
		
		//add the json to the body of the request
		httpRequest.body(requestParams.toJSONString());
		
		response = httpRequest.request(Method.POST, "/register");
		
		Thread.sleep(4);
		
			
	}
	
	@Test
	public void validateResponseBody() {
		logger.info("----------------Printing Response body---------------");
		String responseBody = response.getBody().asString();
		logger.info("Response body is -->" + responseBody);
		//Assert.assertEquals(responseBody.contains(empname), true);
		//Assert.assertEquals(responseBody.contains("2000"),true);
		//Assert.assertEquals(responseBody.concat("25"),true);
		}
	
	@Test
	public void verifyStatusCode() {
		logger.info("--------------verify status code-----------");
		int Statuscode = response.getStatusCode();
		logger.info("Status code is "+ Statuscode);
		Assert.assertEquals(Statuscode, 200);
	}

}
