package basics;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetReqDemo {
	/*
	 * Given I have this information, When I perform this action, Then this should
	 * be the output.
	 */
	@BeforeClass
	public void setUp() {
		RestAssured.baseURI = "https://api.github.com";
		//RestAssured.basePath = ;
	}
	@Test(enabled = false)
	public void statusCodeVerify() {
		given().when().get("/rate_limit").then().statusCode(200);
	}
	@Test
	public void getResponseBody() {
		Response response = given().when().get("/rate_limit");
		//System.out.println(response.body().asString());
		System.out.println(response.body().prettyPrint());
		
	}
}
