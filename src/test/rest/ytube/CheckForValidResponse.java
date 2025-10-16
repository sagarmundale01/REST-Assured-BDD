package test.rest.ytube;

import org.testng.annotations.Test;

import com.github.dockerjava.transport.DockerHttpClient.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;

public class CheckForValidResponse {

	//https://reqres.in/api/users/2
	
	@Test	
	public void GetSingleUser()
	{
		RestAssured.baseURI= "https://reqres.in/api/users/2";
		RequestSpecification requesSpec = RestAssured.given();
		
		//call get method
		io.restassured.response.Response response = requesSpec.get();
		
		int statusCode = response.getStatusCode();
		
		
		
	}
	
}
