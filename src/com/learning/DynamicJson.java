package com.learning;
import static io.restassured.RestAssured.given;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicJson {

	@Test(dataProvider = "BooksData")
	public void addBook(String isbn,String aisle)
	{
		RestAssured.baseURI="http://216.10.245.166";
		String response= given().header("Content-Type","application/json").body(Payload.AddBook()).
		when().post("Library/AddBooks.php").
		then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js= ReUsableMethods.rawToJson(response);
		String id= js.get("ID");
		System.out.println(id);
		
	}
	
	@DataProvider (name = "BooksData")
	public Object[][] getData() {
		
		return new Object[][] {{"ojwes","9834"},{"ghhsd","3445"},{"osdhf","5343"}};
		
	}
	
}
