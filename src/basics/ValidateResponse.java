package basics;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class ValidateResponse {
	@Test
	public void statusCodeVerify() {
		given()
		.when()
		.get("https://api.github.com/rate_limit")
		.then().statusCode(200)
		.and().body("resources.core.limit", equalTo(60))
		.contentType(ContentType.JSON);
	}
}
