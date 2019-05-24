package basics;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.RegisterModel;

public class PostReqWithPOJO {
	@BeforeClass
	public void setUp() {
		RestAssured.baseURI ="http://restapi.demoqa.com/customer";
		//RequestSpecification request = RestAssured.given();
	}
	@Test
	public void postRequest() {
		RegisterModel register = new RegisterModel();
		register.setEmail("js@test.com");
		register.setFirstName("Joe");
		register.setLastName("Smith");
		register.setPassword("password");
		register.setUserName("Js");
		RequestSpecification spec = given().body(register);
		Response response = spec.when().post("/register");
		System.out.println(response.getBody().asString());
		
		response.then().statusCode(200).and().contentType(ContentType.JSON); //.and().body("status", equalTo("OK"));
		System.out.println(response.body().asString());
	}
}
