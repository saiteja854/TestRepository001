package extentReport;

import java.awt.event.ItemListener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport1 implements ITestListener{

	ExtentTest logger;
	ExtentReports report;//Class variable
	public void onFinish(ITestContext result) {		
		
		report.flush();
        			
        		
    }		

  		
    public void onStart(ITestContext result) {	
    	report=new ExtentReports("C:\\Users\\amalbari\\Desktop\\Extent2.html", true);
    	report.addSystemInfo("hostname", "sam");
    }		

    
  	
    public synchronized void onTestFailure(ITestResult result) {
    	String Username= (String) result.getTestContext().getAttribute("username");
        logger=report.startTest(result.getName());
        logger.assignAuthor("Class: "+result.getTestClass().getName());
        logger.log(LogStatus.FAIL, result.getName()+" is Failed");//Logstatus.pass---
        logger.log(LogStatus.FAIL, Username+" is user name");
        logger.log(LogStatus.FAIL, result.getThrowable());
        report.endTest(logger);
    }		

   	
    public synchronized void onTestSkipped(ITestResult result) {
    	
        logger=report.startTest(result.getName());
        logger.assignAuthor("Class: "+result.getTestClass().getName());
        logger.log(LogStatus.SKIP, result.getName()+" is Skipped");//Logstatus.pass---
        report.endTest(logger);
    }		


   		
    public synchronized void onTestSuccess(ITestResult result) {					
    	String Username= (String) result.getTestContext().getAttribute("username");
    	logger=report.startTest(result.getName());
        logger.assignAuthor("Class: "+result.getTestClass().getName());
        logger.log(LogStatus.PASS, result.getName()+" is Passed");//Logstatus.pass---
        logger.log(LogStatus.PASS, Username+" is user name");
        report.endTest(logger);
        		
    }		

    public void onTestStart(ITestResult result) {
    	
    }
	
}
