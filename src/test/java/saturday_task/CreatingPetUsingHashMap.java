package saturday_task;
import java.util.HashMap;
import java.util.ArrayList;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreatingPetUsingHashMap {
	static String username="arun123";
@Test(priority = 1)
public void createUser() {

		HashMap<String,Object> body = new HashMap<>();

    body.put("id", 101);
      body.put("username", username);
     body.put("firstName", "Arun");
    body.put("lastName", "Balaji");
      body.put("email", "arun@gmail.com");
     body.put("password", "arun123");
     body.put("phone", "9876543210");
    body.put("userStatus", 1);

       given()
       .baseUri("https://petstore.swagger.io/v2")
       .contentType(ContentType.JSON)	
.	body(body)

.when()
.post("/user")

.then()
.log().all()
.statusCode(200);

    }
@Test(priority = 2)
public void getUser() {

given()
.baseUri("https://petstore.swagger.io/v2")
.pathParam("username",username)

.when()
.get("/user/{username}")

.then()
.log().all()
.statusCode(200);

}


@Test(priority = 3 )
public void updateUser() {

HashMap<String,Object> body = new HashMap<>();

body.put("id",101);
body.put("username","arun123");
body.put("firstName","Arun");
body.put("lastName","Balaji");
body.put("email","arunupdated@gmail.com");
body.put("password","arun1234");
body.put("phone","9876543210");
body.put("userStatus",1);

given()
.baseUri("https://petstore.swagger.io/v2")
.contentType(ContentType.JSON)
.pathParam("username",username)
.body(body)

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

.when()
.delete("/user/{username}")

.then()
.log().all()
.statusCode(200);

}
}