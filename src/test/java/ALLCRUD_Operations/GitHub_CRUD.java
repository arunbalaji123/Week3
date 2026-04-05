package ALLCRUD_Operations;
import org.testng.annotations.Test;
	import io.restassured.http.ContentType;

	import java.util.HashMap;
	import java.util.Map;

	import static io.restassured.RestAssured.*;
	import static org.hamcrest.Matchers.*;
public class GitHub_CRUD {
	
	static String BaseUrl="https://api.github.com";
		static String token="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";
		static String owner = "arunbalaji123";
		static String repoName = "RepoCreatedByArun";
		
		@Test(priority = 1)
		public void createRepo() {
			 HashMap<String, Object> m = new HashMap<>();
			 m.put("name", repoName);
			 m.put("description", "Right arm fast bowler repo");

		        given()
		            .baseUri(BaseUrl)
		            .contentType(ContentType.JSON)
		            .header("Authorization", "Bearer " + token)
		            
		            .body(m)
		        .when()
		            .post(BaseUrl+"/user/repos")
		        .then()
		            .statusCode(201)
		            .log().all();
		}
		
		@Test(priority = 2)
		public void getRepo() {

			given()
			.baseUri(BaseUrl)
			.header("Authorization", "Bearer " + token)

			.when()
			.get("/repos/" + owner + "/" + repoName)

			.then()
			.statusCode(200)
			.log().all();

			}

		
		@Test(priority = 3)
		public void updateRepo() {

			HashMap<String, Object> m = new HashMap<>();

			m.put("name", repoName);
			m.put("description", "Updated by RestAssured");

			given()
			.baseUri(BaseUrl)
			.header("Authorization", "Bearer " + token)
			.contentType(ContentType.JSON)
			.body(m)

			.when()
			.patch("/repos/" + owner + "/" + repoName)

			.then()
			.statusCode(200)
			.log().all();

			}

		
		@Test(dependsOnMethods="updateRepo")
		public void deleteRepo() {

		System.out.println("Deleting repo: "+owner+"/"+repoName);

		given()
		.baseUri(BaseUrl)
		.header("Authorization", "Bearer " + token)

		.when()
		.delete("/repos/" + owner + "/" + repoName)

		.then()
		.statusCode(204)
		.log().all();

		}

}
