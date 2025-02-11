package cucumbertests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class login {

	WebDriver driver =new ChromeDriver();
	@Given("navigate")
	public void launchurl() {
		driver.get("https://www.saucedemo.com/v1/");
	}
	
	@When("enter valid")
	public void enterdatils() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
	}
	@And("click login button")
	public void enterlogin() {
		
		driver.findElement(By.id("login-button")).click();
	}
	@Then("should login successfully")
	public void checklogin() {
		
		String  curreturl= driver.getCurrentUrl();
		System.out.println("login successfucc");
		System.out.println(curreturl);
		
	}
	
	
	
}
