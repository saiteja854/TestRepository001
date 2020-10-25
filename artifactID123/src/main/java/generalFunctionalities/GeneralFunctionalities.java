package generalFunctionalities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class GeneralFunctionalities {
	// TODO Auto-generated constructor stub
	WebDriver driver;
	Properties p;
	
	
	public void entertext(String key, String value) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//td[text()='"+key+"']/following-sibling::td/*")).sendKeys(value);
		
	}
	
	public Properties properties() throws IOException {
		FileReader reader= new FileReader("C:\\Users\\amalbari\\eclipse-workspace1\\artifactID123\\src\\main\\resources\\config.properties");
		p=new Properties();
		p.load(reader);
		return p;
	}
	
	
	public WebDriver getDriver() throws IOException {
		System.out.println("Inside get driver");
		if(properties().getProperty("browser").equals("chrome")) {
			System.out.println("test");
			String chromePath=properties().getProperty("chromepath");
			System.setProperty("webdriver.chrome.driver", chromePath);
			this.driver= new ChromeDriver();
			return driver;
		}
		else if(properties().getProperty("browser").equals("ie")) {
			System.out.println("testelseif");
			System.setProperty("webdriver.chrome.driver", p.getProperty("internetemplorerpath"));
			driver=new InternetExplorerDriver();
		}
		else 
		{
			System.out.println("testelse");
			System.setProperty("webdriver.chrome.driver", p.getProperty("firefoxpath"));
			driver=new FirefoxDriver();
		}
		System.out.println("test4");
		return driver;
	}
	
	
	public String[][] excelRead(String excelpath) throws InvalidFormatException, IOException{
		
		File file=new File(excelpath);
		  XSSFWorkbook wb=new XSSFWorkbook(file);
		  XSSFSheet sheet=wb.getSheetAt(0);
		  int row= sheet.getPhysicalNumberOfRows();//5
		  int col= sheet.getRow(0).getPhysicalNumberOfCells();//3
		  System.out.println("Row "+row);
		  System.out.println("Col "+col);
		  
		  String [][]a= new String [row-1][col];//
		  
		  for(int i=1;i<=row-1;i++)
		  {
			  
			  for (int j=0;j<col;j++) {
				 a[i-1][j]=sheet.getRow(i).getCell(j).toString();
				 System.out.println(i + " " +j +" "+ a[i-1][j]);
			  }
		  }
		return a;
	}
	

}
