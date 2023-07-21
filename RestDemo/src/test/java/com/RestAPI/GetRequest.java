package com.RestAPI;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GetRequest {

	@Test
	public void listUsers() {
		
		//base URL of that api
		baseURI="https://reqres.in/api/";
		
		//ssl authetication handled by httpsvalidation as prerequisite under given
		given()
		    .relaxedHTTPSValidation()
		//the request method with the endpoint mentioned under when
		.when()
		    .get("users?page=2")
		//validation done under then
		.then()
		    .statusCode(200) //for ststus code
		    .body("page",equalTo(2)) //for the response body having page no 2 using rstasured assertion
		    .body("data[3].first_name", equalTo("Byron"))//to check third name as byron
		    .body("data.first_name", hasItems("Byron","Lindsay"))//to check multiple names
		//log method to log all the details from the response body
		.log().all();
		
	}
}
