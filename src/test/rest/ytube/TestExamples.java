package test.rest.ytube;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class TestExamples {

	@Test
	public void test_1() {
		
		Response response = get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.getStatusCode());          //200 response code
		System.out.println(response.getTime());                //1299 times in mili sec
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());            //200 OK (response with status code line)
		System.out.println(response.getHeader("content-type"));  //charset=utf-8
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);                   //expected [201] but found [200]
				
	}
	
	@Test
	public void test_2() {
		
		baseURI = "https://reqres.in/api";
		
		given().get("/users?page=2").then().statusCode(200).log().all();
		
		
		
	}
}
