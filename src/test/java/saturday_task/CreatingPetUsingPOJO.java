package saturday_task;

import org.testng.annotations.Test;
import pojo.User;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

	public class CreatingPetUsingPOJO {

			static String username="arun123";

			@Test(priority = 1)
			public void createUser() {

				User user = new User(101,username,"Arun","Balaji","arun@gmail.com","arun123","9876543210",1);
					given().baseUri("https://petstore.swagger.io/v2").contentType(ContentType.JSON).body(user)

						.when().post("/user").then().statusCode(200).log().all();

			}


			@Test(priority = 2)
			public void getUser() {

				given()
						.baseUri("https://petstore.swagger.io/v2").pathParam("username",username).when().get("/user/{username}")
						.then()
						.log().all()
						.statusCode(200);

			}


			@Test(priority = 3)
			public void updateUser() {

				User user = new User(101,username,"Arun","Balaji","arunupdated@gmail.com","arun1234","9876543210",1);

				given()
				.baseUri("https://petstore.swagger.io/v2").contentType(ContentType.JSON).pathParam("username",username)
						.body(user)

				.when()
				.put("/user/{username}")

				.then()
					.log().all()
								.statusCode(200);

			}


				@Test(priority = 4)
				public void deleteUser() {

					given()
						.baseUri("https://petstore.swagger.io/v2")
						.pathParam("username",username)

						.when().delete("/user/{username}")

						.then().log().all().statusCode(200);

}

}