import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC007_Request_Authentication {
	
	@Test
	
	void authentication() {
		
		RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
		
		//Basic authentication
		
		PreemptiveBasicAuthScheme authscheme = new PreemptiveBasicAuthScheme();
		authscheme.setUserName("ToolsQA");
		authscheme.setPassword("TestPassword");
		
		RestAssured.authentication = authscheme;
		
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET, "/");
		
		String responseBody = response.getBody().asString();
		System.out.println("The response body"+ responseBody );
		
		Assert.assertEquals(responseBody.contains("OPERATION_SUCCESS"), true);
		
		Assert.assertEquals(response.getStatusCode(),200);;
	}

}
