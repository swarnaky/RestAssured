package com.employeeapi.testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class TC004_Delete_Empolyee_Record extends TestBase{

	@BeforeClass
	void deleteEmployeeRecord() throws InterruptedException {
		logger.info("-----------starting TC004_Delete_employee-----------");;
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		
	    httpRequest = RestAssured.given();
	    
	    response = httpRequest.request(Method.GET , "/employees");
	    
	  //  logger.info("response is "+ response);
	    
	    //first get the jsonpath object instance from the response interface
	    JsonPath jsonpathEvaluator = response.jsonPath();
	    
	    //Capture id
	    String empID = jsonpathEvaluator.get("[3].id");
	    logger.info("Emp id is --->"+empID);
	    response = httpRequest.request(Method.DELETE, "/delete/"+empID);
	    Thread.sleep(3);
	}
	
	@Test
	void verrifyResponseBody() {
		logger.info("------------verify response body----------");
		String responsebody = response.getBody().asString();
		logger.info("Response body is--->"+ responsebody);
		
	}
}

