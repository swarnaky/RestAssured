import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_REQUESt {
	
	@Test
	
	void registrationSuccess() {
		
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		//Request payload sending along with post request
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("FirstName", "swapna13");
		requestParams.put("LastName", "thota");
		requestParams.put("UserName", "Tests2");
		requestParams.put("Password", "Test123");
		requestParams.put("Email", "swapna13@test.com");
		
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toJSONString()); // attach above data to the request
		
		//Response Object
		Response response = httpRequest.request(Method.POST,"/register");
		
		//print response in console
		
		String responseBody=response.getBody().asString();
		System.out.println("Response body is :"+ responseBody);
		
		//Status code validation
		
		int statusCode = response.getStatusCode();
		System.out.println("Response code is :"+ statusCode);
		Assert.assertEquals(statusCode, 201);
		
		//success code validation
		String Successcode = response.jsonPath().get("SuccessCode");
		System.out.println("Successcode is :" +Successcode );
		Assert.assertEquals(Successcode, "OPERATION_SUCCESS");
		
		
		
	}

}
