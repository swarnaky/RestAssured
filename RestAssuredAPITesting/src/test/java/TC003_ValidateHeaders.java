import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_ValidateHeaders {
	
	@Test
	
	void validateHeaders() {
		
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET,"/Hyderabad");
		
		String responseBody=response.getBody().asString();
		System.out.println("Body is "+ responseBody);
		
		//validating headers
		String contentEncoding = response.header("content-encoding");
		System.out.println("Content encoding is" +contentEncoding );
		Assert.assertEquals(contentEncoding, "gzip");
		
		String contentType = response.header("connection");
		System.out.println("The content type is :"+contentType);
		Assert.assertEquals(contentType, "Keep-Alive");
		
	
	}

}
