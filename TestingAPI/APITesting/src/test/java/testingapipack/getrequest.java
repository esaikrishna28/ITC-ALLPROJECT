package testingapipack;



	import io.restassured.RestAssured;
	import io.restassured.response.Response;
	import org.testng.Assert;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;
	public class getrequest {
	    
	    @BeforeClass
	    public void setup() {
	        // Set base URL
	        RestAssured.baseURI = "https://reqres.in/api";
	    }
	    
	    @Test
	    public void testGetUsers() {
	        // Send GET request and get the response
	        Response response = RestAssured
	            .given()
	            .param("page", 2)  // Adding query parameter for pagination
	            .when()
	            .get("/users")
	            .then()
	            .extract().response();
	        // Print the response body
	        System.out.println("Response Body: " + response.getBody().asString());
	        // Verify status code
	        Assert.assertEquals(response.getStatusCode(), 200);
	        // Verify that the response contains a list of users
	        Assert.assertTrue(response.jsonPath().getList("data").size() > 0, "Users list is empty.");
	    }
	}	
	
	

