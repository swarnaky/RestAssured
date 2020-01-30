import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_REQUEST {

	@Test
	void getWeatherDetails() {
		//specify base uri
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		//request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response object
		Response response = httpRequest.request(Method.GET,"/Hyderabad");
		
		//print response to the console window
		String responseBody = response.getBody().asString();
		System.out.println("The response body is "+responseBody );
		
		//print status code and validation
		int StatusCode = response.getStatusCode();
		System.out.println("Status code is:"+StatusCode);
		Assert.assertEquals(StatusCode, 200);
		
		//validate status line
		String StatusLine = response.getStatusLine();
		System.out.println("Status line is: "+StatusLine );
		Assert.assertEquals(StatusLine,"HTTP/1.1 200 OK");
		
		String headers = response.getContentType();
		System.out.println("headers are :"+headers);
		System.out.println("Response time:"+ response.getTime());
	}
}
