package cucumbertests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class webshoploginall {

WebDriver driver =new ChromeDriver();
	
	
	@Before
	public void  beforemethod() {
	System.out.println("before  method is running");
	
	}
	
	@After
	public void aftermethod() {
	System.out.println("after method has been exceuted ");
	
	}
//	@BeforeAll
//	public void berforeall() {
//		System.out.println("berfore all is exceuted ");
//		
//	}
//	@AfterAll
//	public void afterall() {
//		System.out.println("after all is exceuted ");
//	}

	@BeforeStep
	public void berforestep() {
		System.out.println("berfore step is exceuted ");
		
	}
	@AfterStep
	public void afterstep() {
		System.out.println("after step is exceuted ");
	}
	
	
	
	
	@Given("open demo webshop2")
	public void launchurl2() {
		driver.get("https://demowebshop.tricentis.com/login");
	}
	
	
	
	
	@When("2enter username {string} and password {string}")
	public void enterdatils2(String username,String password) {
		WebElement usernamefield =driver.findElement(By.id("Email"));
		WebElement passwordfiled =driver.findElement(By.id("Password"));
		usernamefield.sendKeys(username);
		passwordfiled.sendKeys(password);
		
	}
	@And("click on login2")
	public void enterlogin2() {
		
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}
	@Then("should see account page2")
	public void checklogin2() {
		
		String  curreturl= driver.getCurrentUrl();
		System.out.println("login successfucc");
		System.out.println(curreturl);
		
	}
	
	
	
}
