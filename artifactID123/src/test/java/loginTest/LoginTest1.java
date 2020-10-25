package loginTest;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import generalFunctionalities.Login1;

public class LoginTest1 extends Login1{
	String userName;
	String password;
	WebDriver driver;
	ArrayList<String> input_data;
	public LoginTest1(String userName, String password) {
		this.userName=userName;
		this.password=password;
		input_data=new ArrayList<String>();
		input_data.add(this.userName);
		input_data.add(this.password);
	}
	
	@BeforeClass
	public void webdriverInitialize() throws IOException {
		this.driver=getDriver();
		System.out.println("after beforeclass");
	}
	
	
	@Test(priority=0)
	public void login() throws IOException, InterruptedException {
		try {
			String message=Login(this.driver, userName, password);
			Assert.assertEquals(message, "Welcome To Manager's Page of Guru99 Bank");
		}
		catch (Exception e) {
			// TODO: handle exception
			Assert.fail("Incorrect username and password"+ this.userName);
		}
		
		
	}
	
	@Test(dependsOnMethods = "login")
	public void maximize() {
		driver.manage().window().maximize();
	}
	
	
	@Test(dependsOnMethods = "maximize")
	public void NewCustomer() throws InterruptedException {
		driver.findElement(By.linkText("New Customer")).click();
		entertext("Customer Name", this.userName);
		entertext("Date of Birth", "03/03/1993");
		entertext("Address", "Sahajivan");
		entertext("City", "Dhule");
		entertext("State", "Dhule");
		entertext("PIN", "424001");
		entertext("Mobile Number", "8275100797");
		entertext("E-mail", "abc@gmail.com");
		entertext("Password", this.password);
		driver.findElement(By.name("sub")).click();
		
	}

	@AfterClass
	public void afterclass() {
		//driver.close();
	}
	
}
