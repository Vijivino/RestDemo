package com.RestAPI;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class DeleteRequest {

	@Test
	public void deleteUser() {
		
		given()
		 .relaxedHTTPSValidation()
       .when()
		 .delete("https://reqres.in/api/users/2")
	   .then()
		  .statusCode(204)
		  .log().all();
	}
}
