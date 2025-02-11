package TestNgpackage;

import org.testng.annotations.DataProvider;

public class TestData {

	@DataProvider(name = "urlProvider")
	   public Object[][] provideUrls() {
	       return new Object[][] {
	           { "https://demowebshop.tricentis.com/" },  // URL 1
	           { "https://gmail.com/" },                // URL 2 (You can add more URLs here)
	           // Add more URLs as needed
	       };
	   }
	}

