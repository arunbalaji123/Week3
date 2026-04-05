package authentication_techniques;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import java.io.File;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class basic_auth {
	static String BaseUrl = "https://httpbin.org";
	@Test
	public void basic_auth() {
		given()
		.pathParam("user", "admin")
		.pathParam("password", "arun@123")
		.auth().basic("admin", "arun@123")
		.log().all()
		
		
		.when().get(BaseUrl+"/basic-auth/{user}/{password}")
		.then().statusCode(200).log().all();
		
	}
	@Test
	public void bearer_token() {
		 String token = "mytoken123";

	        given()
	            .header("Authorization", "Bearer " + token)

	        .when()
	            .get(BaseUrl + "/bearer")

	        .then()
	            .log().all()
	            .assertThat()
	            .statusCode(200)
	            .statusLine(containsString("HTTP"))
	            .time(lessThan(5000L));
	}
	
	 @Test(priority =3)
	    public void usingOAuth2Token() {

	        String token = "mytoken1234";

	        given()
	            .auth()
	            .oauth2(token)

	        .when()
	            .get(BaseUrl + "/bearer")

	        .then()
	            .log().all()
	            .assertThat()
	            .statusCode(200)
	            .statusLine(containsString("HTTP"))
	            .time(lessThan(5000L));
	    }
	

}
