package test.rest.ytube;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class QueryRequestSpecification {

	@Test
	public void createUser() {
		
		//create json data
		JSONObject jsonData = new JSONObject();
		
		jsonData.put("name", "Alex");
		jsonData.put("job", "QA");
		
		//create Request specification
		RequestSpecification requestSpec = RestAssured.given();
		
		//specify uri
		requestSpec.baseUri("https://reqres.in/");
		requestSpec.basePath("/api/users")
		.contentType(ContentType.JSON)
		.body(jsonData.toString()).header("header1","header1value");
		
		//query details from request specification
		QueryableRequestSpecification queryRequest = SpecificationQuerier.query(requestSpec);
		
		
		//get base URI
		String retriveBaseURI = queryRequest.getBaseUri();
		System.out.println("Base URI: " + retriveBaseURI);
		
		
		//get base Path
		String retriveBasePath = queryRequest.getBasePath();
		System.out.println("Base Path: " + retriveBasePath);
		
		//get body 
        String retriveRequestBody = queryRequest.getBody();
		System.out.println("Body:  " + retriveRequestBody);
				
	   //get request Headrers
		Headers allHeaders = queryRequest.getHeaders();
		System.out.println("\n----------------------REQUEST HEADER----------------------\n");
		
		for(Header h:allHeaders)
		{
		   System.out.println("Header Name: " + h.getName() + "Header Value: " + h.getValue());
			
		}
		
		
		
		
		
	}
		
}
