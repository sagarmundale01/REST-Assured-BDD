package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefinition extends Utils{ 

	ResponseSpecification resspec;
	RequestSpecification res;
	Response response;
	TestDataBuild data = new TestDataBuild();
	
	@Given("Add Place Payload with {string} {string} {string}")
     public void add_place_payload_with(String name, String language, String address) throws IOException 	
     {
	    // Write code here that turns the phrase above into concrete actions
	   
		res = given().spec(requestSpecification()).body(data.addPlacePayLoad(name, language, address));		
			
		
	}
	
     @When("user calls {string} with {string} http request")
     public void user_calls_with_http_request(String resource, String method) 
     {
         APIResources resourceAPI = APIResources.valueOf(resource);
         System.out.println(resourceAPI.getResource());

         resspec = new ResponseSpecBuilder()
                     .expectStatusCode(200)
                     .expectContentType(ContentType.JSON)
                     .build();

         if(method.equalsIgnoreCase("POST")) {
             response = res.when()
                           .post(resourceAPI.getResource())
                           .then()
                           .spec(resspec)
                           .extract()
                           .response();
         } 
         else if(method.equalsIgnoreCase("GET")) {
             response = res.when()
                           .get(resourceAPI.getResource())
                           .then()
                           .spec(resspec)
                           .extract()
                           .response();
         }
     }



	
	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer expectedStatusCode)
	{
		// assertEquals(expected, actual) — use expected first
		assertEquals(expectedStatusCode.intValue(), response.getStatusCode());
		
	}
	
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String Expectedvalue)
	{
	    String resp = response.asString();
	    System.out.println("Response body: " + resp); // helpful for debugging
	    JsonPath js = new JsonPath(resp);
	    String actual = js.getString(keyValue);
	    // compare expected first, then actual
	    assertEquals(Expectedvalue, actual);
	    
	    
	}

	
}