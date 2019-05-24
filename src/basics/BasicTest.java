package basics;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
public class BasicTest {
@BeforeClass
public void setUp() {
	RestAssured.baseURI = "https://sandbox-api.coinmarketcap.com" ;
	RestAssured.basePath = "/v1/cryptocurrency ";
}
@Test(enabled=false)
public void statusCodeVerification() {
	given()
	.header("X-CMC_PRO_API_KEY","2ed7f659-2a80-4cc3-89c0-246cfd54c369")
	//.header("X-CMC_PRO_API_KEY","2ed7f659-2a80-4cc3-89c0-246cfd54c369")
	.param("start",1)
	.param("limit",10)
	.param("convert","USD")
	
	
	
	.when().basePath("/listings/latest")
	.then().statusCode(200);
}
@Test
public void getResponseBody() {
	Response response =  given()
	.header("X-CMC_PRO_API_KEY","2ed7f659-2a80-4cc3-89c0-246cfd54c369")		
	.param("start",1)
	.param("limit",10)
	.param("convert","USD")
	.when().get("/listings/latest");
	System.out.println(response.body().prettyPrint());
}
}
