package test.rest.ytube;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;


public class Test_GetMethod {

	@Test
	public void test01()
	{
		Response response = get("https://reqres.in/api/users?page=2");
		
		System.out.println("Response code: "+ response.getStatusCode());
		System.out.println("Response body: "+ response.getBody());
		System.out.println("Response Time: "+ response.getTime());
		System.out.println("Response header: "+ response.getHeader("Content-Type"));
		
		//validate status code
		int ExpectedtatusCode = 200;
		int ActualStatusCode = response.getStatusCode();
		Assert.assertEquals(ExpectedtatusCode, ActualStatusCode);	
	}
	
	@Test
	public void test02()
	{
		//give,when,then
		baseURI= "https://reqres.in/api/users";
		given().queryParam("page","2").
		when().get().then().statusCode(200);			
		
		
	}
	
	
	
	
}
