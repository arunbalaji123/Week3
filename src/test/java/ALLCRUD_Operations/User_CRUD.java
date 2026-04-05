package ALLCRUD_Operations;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import java.io.File;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class User_CRUD {

	static String BaseUrl="https://fakerestapi.azurewebsites.net";

	@Test(priority = 1)
	public void create() {
		HashMap<String, Object> map= new HashMap<String, Object>();
		map.put("id", 0);
		map.put("userName", "ArunBalaji");
		map.put("password", "arun@123");
		
		
		given().contentType(ContentType.JSON).body(map).
		
		when().post(BaseUrl+"/api/v1/Users") .then().log().all()
        .assertThat()
        .statusCode(200)
        .statusLine(containsString("HTTP"))
        .time(lessThan(5000L));
}
	@Test(priority = 2)
	 public void getUser() {
		 given()
			
			
			.when()
			    .get(BaseUrl+"/api/v1/Users")
			    
			    
			    .then().log().all().assertThat().statusCode(200).statusLine(containsString("HTTP")).time(lessThan(5000L));
			
			
		 
	 }
	 @Test(priority = 3)
	 public void getuserByid() {
		 given()
		    .pathParam("id",3)
		    
		    .when()
		    .get(BaseUrl+"/api/v1/Users/{id}")
		    
		    
		    .then().log().all().assertThat().statusCode(200).statusLine(containsString("HTTP")).time(lessThan(5000L));
	 }
	 
	 @Test(priority = 4)
	 public void UpdateUser() {
		 String body = "{\n" +
	             "  \"id\": " + 3 + ",\n" +
	             "  \"userName\": \"" + "ARUN BALAJI" + "\",\n" +
	             "  \"password\": \"" +"ARUN@1234" + "\"\n" +
	             "}";
		 given().pathParam("id", 3).contentType(ContentType.JSON)
		 .body(body)
	     .when()
	         .put(BaseUrl + "/api/v1/Users/{id}")
	     .then()
	         .log().all()
	         .assertThat()
	         .statusCode(200)
	         .statusLine(containsString("HTTP"))
	         .time(lessThan(5000L))
	         .body("userName", equalTo("ARUN BALAJI"))
	         .body("password", equalTo("ARUN@1234"));
	     
	 }
	 
	 @Test(priority = 5)
	 public void deleteUserById() {
		 given()
		 .pathParam("id",0)
			
			
			.when()
			    .delete(BaseUrl+"/api/v1/Users/{id}")
			    
			    
			    .then().log().all().assertThat().statusCode(200).statusLine(containsString("HTTP")).time(lessThan(5000L));
			
		 
	 } 
	}

