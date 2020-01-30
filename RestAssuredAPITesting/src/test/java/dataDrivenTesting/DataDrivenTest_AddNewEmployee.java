package dataDrivenTesting;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDrivenTest_AddNewEmployee {
	@Test(dataProvider="empdata")
	
	void postNewEmployees(String ename, String esal, String eage) {
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		//Here we created data which we can send along with the post request
		JSONObject requestparams = new JSONObject();
		requestparams.put("name", ename);
		requestparams.put("salary", esal);
		requestparams.put("age", eage);
		
		//add a header stating the request body is a json
		
		httpRequest.header("Content-Type","application/json");
		
		//Add the json to the body of the request
		httpRequest.body(requestparams.toJSONString());
		
		//Post request
		Response response=httpRequest.request(Method.POST, "/create");
		
		//capture response body to perform validation
		String responseBody=response.getBody().asString();
		System.out.println("Response body"+ responseBody);
		
		//Assert.assertEquals(responseBody.contains("Raj1") , true);
		
		int statusCode = response.getStatusCode();
		System.out.println("Status code"+ statusCode);
		Assert.assertEquals(statusCode ,200);
				
	}

     @DataProvider(name="empdata")	
	String [][] getEmpData() throws Exception{
    	 
    	 String path = System.getProperty("user.dir")+"/src/test/java/dataDrivenTesting/Book1.xlsx";
		
	//	String empData[][] = {{"Raj2","2000","22"},{"Raj3","3000","33"},{"Raj3","4000","44"}};
    	 
    	 int rowNum = XLUtilities.getRowCount(path, "Sheet1");
    	 int colCount= XLUtilities.getCellCount(path, "Sheet1", 1);
    	 
    	 String empData[][]= new String[rowNum][colCount];
    	 
    	 for(int i=0 ; i<= rowNum ; i++) {
    		 for(int j=0 ; j <=  colCount; j++) {
    			 empData[i - 1][j] = XLUtilities.getCellData(path, "Sheet1", i, j);
    			 
    		 }
    	 }
    	 
	
		return(empData);
	}
}
