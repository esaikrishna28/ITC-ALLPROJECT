package Annotations;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.*;

public class Class1 {

	@BeforeSuite
	public void beforesuite() {
		System.out.println("before suite has been exceuted ");
	}
	
	@AfterSuite
	public void aftersuite() {
		System.out.println("after  suite has been exceuted ");
	}
	
	
	@BeforeTest
	public void berforetest() {
		System.out.println("before test has been exceuted ");
	}
	@AfterTest
	public void aftertest() {
		System.out.println("after  test has been exceuted ");
	}
	
	@BeforeMethod
	public void beforemethods() {
		System.out.println("before method has been exceuted ");
	}
	
	@AfterMethod
	public void aftermethod() {
		System.out.println("aftermethod has been exceuted ");
	}
	
	@Test
	public void test1() {
		System.out.println("test1 has been exceuted ");
	}
	
	@Test
	public void test2() {
		System.out.println("test2 has been exceuted ");
	}
	
	
	
}
