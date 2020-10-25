package generalFunctionalities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Login1 extends GeneralFunctionalities{
	
	/*
	 * @FindBy(className = "heading3") WebElement mesgtext;
	 * 
	 * @FindBy(name="btnLogin") WebElement submit;
	 * 
	 * public Login1() { PageFactory.initElements(driver, this); }
	 */
	String msg;
	public String Login (WebDriver driver, String userName, String password) throws IOException, InterruptedException {
		driver.get(properties().getProperty("URL"));
		
		entertext("UserID", userName);
		entertext("Password", password);
		//submit.click();
		
		driver.findElement(By.name("btnLogin")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			msg=driver.findElement(By.className("heading3")).getText();
		}
		catch (Exception e) {
			// TODO: handle exception
			msg="hello";
		e.printStackTrace();
			driver.switchTo().alert().accept();
		}
		
		
		
		return msg;
	}

}
