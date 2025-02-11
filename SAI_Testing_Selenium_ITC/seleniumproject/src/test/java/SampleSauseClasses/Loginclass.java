package SampleSauseClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginclass {
	
    WebDriver dri=null;
	String usernameid,passwordid,loginid;
	
	public  Loginclass(WebDriver driver){
		this.usernameid="user-name";
		this.passwordid="password";
		this.loginid="login-button";
		System.out.println("instiation done ");
		this.dri=driver;
		System.out.println(usernameid);
		
	}
	
	public void sendusername(String username) {
		System.out.println("sending user name ");
		this.dri.findElement(By.id(usernameid)).sendKeys(username);
		
	}
	
	public void sendpassword(String pass) {
		this.dri.findElement(By.id(passwordid)).sendKeys(pass);
		
		
	}
	
	public void loginclick() {
		this.dri.findElement(By.id(loginid)).click();
	}
	
}

