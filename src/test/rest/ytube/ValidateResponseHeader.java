package test.rest.ytube;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.RequestSpecification;

public class ValidateResponseHeader {
	
	@Test
	public void GetSingleUser()
	{
		//Get Request Specification
		RequestSpecification requestSpec = RestAssured.given();
		
		//Specify base uri
		requestSpec.baseUri("https://reqres.in");
		requestSpec.basePath("/api/users/2");
		
		//create get request
		io.restassured.response.Response response = requestSpec.get();
		
		//validate response header
        String ContentType = response.header("Content-Type");
		System.out.println(ContentType);
		
		String Connection = response.header("Connection");
		System.out.println(Connection);
		
		//Read all the response header attributes/keys and print thier values
		Headers headersList = response.getHeaders();
		
		//iterate over headersList to get all header attributes/keys
		for(Header header:headersList)
		{
			System.out.println(header.getName() + ":"+ header.getValue());
		}
		
		//validate header Content-type, expected value: application/json; charset=utf-8
		Assert.assertEquals(ContentType, "application/json; charset=utf-8","Header content type mismatch");
		
		
	}
	
	
	
}
