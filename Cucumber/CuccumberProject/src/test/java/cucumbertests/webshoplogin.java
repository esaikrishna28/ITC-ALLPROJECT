package cucumbertests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class webshoplogin {

	WebDriver driver =new ChromeDriver();
	
	@Given("open demo webshop")
	public void launchurl() {
		driver.get("https://demowebshop.tricentis.com/login");
	}
	
	
	@When("enter username {string} and password {string}")
	public void enterdatils(String username,String password) {
		WebElement usernamefield =driver.findElement(By.id("Email"));
		WebElement passwordfiled =driver.findElement(By.id("Password"));
		usernamefield.sendKeys(username);
		passwordfiled.sendKeys(password);
		
	}
	@And("click on login")
	public void enterlogin() {
		
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}
	@Then("should see account page")
	public void checklogin() {
		
		String  curreturl= driver.getCurrentUrl();
		System.out.println("login successfucc");
		System.out.println(curreturl);
		
	}
	
	
	
	
}
