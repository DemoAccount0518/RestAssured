package basics;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostReqDemo {
	@BeforeClass
	public void setUp() {
		RestAssured.baseURI ="http://restapi.demoqa.com/customer";
		//RequestSpecification request = RestAssured.given();
	}
	@Test
	public void postRequest() {
		Response response = given().body("{\r\n" + 
				"  \"FirstName\": \"Krishna\",\r\n" + 
				"  \"LastName\": \"Chandar\",\r\n" + 
				"  \"UserName\": \"KCR\",\r\n" + 
				"  \"Password\": \"pass\",\r\n" + 
				"  \"Email\": \"kcr@test.com\"\r\n" + 
				"}")
		.when().post("/register");
		//.then().statusCode(200);
		System.out.println(response.statusCode());
		System.out.println(response.asString());
	}
}
