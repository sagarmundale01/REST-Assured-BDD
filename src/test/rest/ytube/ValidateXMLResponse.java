package test.rest.ytube;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateXMLResponse {

	@Test
	public void addPet() {
		
		String xmlRequestBody = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<Pet>\r\n"
				+ "	<id>0</id>\r\n"
				+ "	<Category>\r\n"
				+ "		<id>0</id>\r\n"
				+ "		<name>string</name>\r\n"
				+ "	</Category>\r\n"
				+ "	<name>doggie</name>\r\n"
				+ "	<photoUrls>\r\n"
				+ "		<photoUrl>string</photoUrl>\r\n"
				+ "	</photoUrls>\r\n"
				+ "	<tags>\r\n"
				+ "		<Tag>\r\n"
				+ "			<id>0</id>\r\n"
				+ "			<name>string</name>\r\n"
				+ "		</Tag>\r\n"
				+ "	</tags>\r\n"
				+ "	<status>available</status>\r\n"
				+ "</Pet>";
		
		
		String jsonData = "{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 0,\r\n"
				+ "    \"name\": \"string\"\r\n"
				+ "  },\r\n"
				+ "  \"name\": \"doggie\",\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 0,\r\n"
				+ "      \"name\": \"string\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"available\"\r\n"
				+ "}";
		
		//createe request specification
		RequestSpecification requestSpec = RestAssured.given();
		
		//specify URL
		//URL: https://petstore.swagger.io/v2/pet
		requestSpec.baseUri("https://petstore.swagger.io");
		requestSpec.basePath("/v2/pet");
		
		//for xml 
		requestSpec.header("accept", "application/xml");
		requestSpec.header("Content-Type", "application/xml");
		requestSpec.body(xmlRequestBody);
		
		//for json
//		requestSpec.header("accept", "application/json");
//		requestSpec.header("Content-Type", "application/json");
//		requestSpec.body(jsonData);
		
		//perform potst request
		Response response = requestSpec.post();
		response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(), 200, "Check for status code");
		
//		response.then().body("Pet.name", Matchers.equalTo("doggi"));
		
	}
	
	
	
	//xml
	/* 
	 * <Pet>
  <id>9223372036854775807</id>
  <name>doggie</name>
  <photoUrls>
    <photoUrl>string</photoUrl>
  </photoUrls>
  <status>available</status>
  <tags/>
</Pet>
	 */
	
	
	
}
