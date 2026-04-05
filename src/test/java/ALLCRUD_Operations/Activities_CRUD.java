package ALLCRUD_Operations;
import org.testng.annotations.Test;
		import io.restassured.http.ContentType;
		import java.io.File;
		import java.util.HashMap;

		import static io.restassured.RestAssured.*;
		import static org.hamcrest.Matchers.*;
public class Activities_CRUD {
	
	
	
		

			static String BaseUrl="https://fakerestapi.azurewebsites.net";

			@Test(priority = 1)
			public void create() {
			File ar= new File("C:\\Users\\acer\\eclipse-workspace\\Fakerest_api\\src\\test\\resources\\Activities.json");
				
				given().contentType(ContentType.JSON).body(ar).
				
				when().post(BaseUrl+"/api/v1/Activities") 
				.then().log().all().assertThat().statusCode(200).statusLine(containsString("HTTP"))
				.time(lessThan(5000L)).body("title", equalTo("IPL"))
		        .body("completed", equalTo(true)).body("id", equalTo(0));
	            
		       
		}
			@Test(priority = 2)
			 public void getUser() {
				 given()
					
					
					.when()
					    .get(BaseUrl+"/api/v1/Activities")
					    
					    
					    .then().log().all().assertThat().statusCode(200).statusLine(containsString("HTTP")).time(lessThan(5000L));
					
					
				 
			 }
			 @Test(priority = 3)
			 public void getuserByid() {
				 given()
				    .pathParam("id",8)
				    
				    .when()
				    .get(BaseUrl+"/api/v1/Activities/{id}")
				    
				    
				    .then().log().all().assertThat().statusCode(200).statusLine(containsString("HTTP")).time(lessThan(5000L));
			 }
			 
			 @Test(priority = 4)
			 public void UpdateUser() {
					File ar= new File("C:\\Users\\acer\\eclipse-workspace\\Fakerest_api\\src\\test\\resources\\Activities_update.json");

				 given().pathParam("id", 8).contentType(ContentType.JSON)
				 .body(ar)
			     .when()
			         .put(BaseUrl + "/api/v1/Activities/{id}")
			     .then()
			         .log().all()
			         .assertThat()
			         .statusCode(200)
			         .statusLine(containsString("HTTP"))
			         .time(lessThan(5000L))
			         .body("title", equalTo("ipl needs RCB"))
				        .body("completed", equalTo(true)).body("id", equalTo(0));
			     
			 }
			 
			 @Test(priority = 5)
			 public void deleteUserById() {
				 given()
				 .pathParam("id",8)
					
					
					.when()
					    .delete(BaseUrl+"/api/v1/Activities/{id}")
					    
					    
					    .then().log().all().assertThat().statusCode(200).statusLine(containsString("HTTP")).time(lessThan(5000L));
					
				 
			 } 
			}




