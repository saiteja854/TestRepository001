package loginFactory;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import generalFunctionalities.GeneralFunctionalities;
import loginTest.LoginTest1;

public class LoginFactory2  extends GeneralFunctionalities{
	
		
		@Factory(dataProvider = "dt")
		public Object[] factory(String userName, String password) {
			return new Object [] {new LoginTest1(userName, password)};
		}
		
			
		@DataProvider(name="dt")
		public String[][] dataprovider() throws InvalidFormatException, IOException{
			String chromePath="C:\\Users\\amalbari\\Documents\\chromedriver\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromePath);
			WebDriver driver=new ChromeDriver();
			String a[][]=excelRead("C:\\Users\\amalbari\\Desktop\\Username.xlsx");
			return a;
		}
		

}
