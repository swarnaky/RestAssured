import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_PrintAllHeaders {
	
	@Test
	
	void printAllHeaders() {
		
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET, "/Hyderabad");
		
		String responseBody = response.getBody().asString();
		
		System.out.println("Response Body :"+ responseBody);
		
		//pring all headers 
		
		Headers allHeaders = response.headers(); //capture all the headers from response
		
		System.out.println("The Headers are :");
		for(Header header:allHeaders) {
			
			System.out.println(header.getName() + " -->" + header.getValue());
		}
		
		
	}

}
