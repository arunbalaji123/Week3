package ALLCRUD_Operations;
import org.testng.annotations.Test;
	import io.restassured.http.ContentType;
	import java.io.File;
	import java.util.HashMap;

	import static io.restassured.RestAssured.*;
	import static org.hamcrest.Matchers.*;
public class Book_CRUD {
	

		static String BaseUrl="https://fakerestapi.azurewebsites.net";

		@Test(priority = 1)
		public void create() {
		File ar= new File("C:\\Users\\acer\\eclipse-workspace\\Fakerest_api\\src\\test\\resources\\book.json");
			
			given().contentType(ContentType.JSON).body(ar).
			
			when().post(BaseUrl+"/api/v1/Books") 
			.then().log().all().assertThat().statusCode(200).statusLine(containsString("HTTP"))
			.time(lessThan(5000L)).body("title", equalTo("Indian Premier League"))
	        .body("description", equalTo("RCB gonna win")).body("excerpt", equalTo("Virat"));
            
	       
	}
		@Test(priority = 2)
		 public void getUser() {
			 given()
				
				
				.when()
				    .get(BaseUrl+"/api/v1/Books")
				    
				    
				    .then().log().all().assertThat().statusCode(200).statusLine(containsString("HTTP")).time(lessThan(5000L));
				
				
			 
		 }
		 @Test(priority = 3)
		 public void getuserByid() {
			 given()
			    .pathParam("id",192)
			    
			    .when()
			    .get(BaseUrl+"/api/v1/Books/{id}")
			    
			    
			    .then().log().all().assertThat().statusCode(200).statusLine(containsString("HTTP")).time(lessThan(5000L));
		 }
		 
		 @Test(priority = 4)
		 public void UpdateUser() {
				File ar= new File("C:\\Users\\acer\\eclipse-workspace\\Fakerest_api\\src\\test\\resources\\bookupdate.json");

			 given().pathParam("id", 0).contentType(ContentType.JSON)
			 .body(ar)
		     .when()
		         .put(BaseUrl + "/api/v1/Books/{id}")
		     .then()
		         .log().all()
		         .assertThat()
		         .statusCode(200)
		         .statusLine(containsString("HTTP"))
		         .time(lessThan(5000L))
		         .body("description", equalTo("CSK Gonna Loss"))
		         .body("excerpt", equalTo("Dhoni"));
		     
		 }
		 
		 @Test(priority = 5)
		 public void deleteUserById() {
			 given()
			 .pathParam("id",0)
				
				
				.when()
				    .delete(BaseUrl+"/api/v1/Books/{id}")
				    
				    
				    .then().log().all().assertThat().statusCode(200).statusLine(containsString("HTTP")).time(lessThan(5000L));
				
			 
		 } 
		}



