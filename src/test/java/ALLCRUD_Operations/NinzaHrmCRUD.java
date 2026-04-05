package ALLCRUD_Operations;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class NinzaHrmCRUD {


	


    static String projectId; static String createdBy;  static String projectName;

    @Test(priority = 1)
    public void Create() {

        File ar = new File("src/test/resources/CreateProject_data.json");

     Response res = given()
                .contentType(ContentType.JSON)
                .body(ar)

        .when()
                .post("http://49.249.28.218:8091/addProject");
     projectId = res.jsonPath().getString("projectId");
   createdBy = res.jsonPath().getString("createdBy");
      projectName = res.jsonPath().getString("projectName");
     

  

     Assert.assertEquals(res.getStatusCode(), 201);
     Assert.assertTrue(res.getTime() < 3000);
     Assert.assertNotNull(projectId);
     Assert.assertTrue(res.getTime() < 5000);
     res.then().log().all();
    }

    @Test(priority = 2)
    public void Getting() {

      
    	 Response res =     given()
                .pathParam("projectId", projectId)

        .when()
                .get("http://49.249.28.218:8091/project/{projectId}");
    	 
    	 Assert.assertEquals(res.getStatusCode(), 200);
    	 Assert.assertEquals(createdBy, "Arun Balaji 13");
    	 Assert.assertEquals(projectName, "Capgemini Api");
    
    	 Assert.assertTrue(res.getTime() < 5000);res.then().log().all();

             
    }	

    @Test(priority = 3)
    public void Updating() {

    	 Response res =   given()
                .contentType(ContentType.JSON)
                .pathParam("projectId", projectId)

                .body("{\n" +
                        "  \"createdBy\": \"Arun\",\n" +
                        "  \"projectName\": \"Mission Updated\",\n" +
                        "  \"status\": \"Created\",\n" +
                        "  \"teamSize\": 0\n" +
                        "}")

        .when()
                .put("http://49.249.28.218:8091/project/{projectId}");

         Assert.assertTrue(res.getTime() < 3000);
    	
    
         Assert.assertTrue(res.getTime() < 5000);res.then().log().all();
    }

    @Test(priority = 4)
    public void deleting() {

      Response res=  given()
                .pathParam("projectId", projectId)

        .when()
                .delete("http://49.249.28.218:8091/project/{projectId}");

Assert.assertEquals(res.getStatusCode(), 204);
Assert.assertTrue(res.getTime() < 5000);

res.then().log().all();
                
               
    }
}
	



