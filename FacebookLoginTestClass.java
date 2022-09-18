package TestClasses;


import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Utility.FacebookBrowserSetUp;
import Utility.Screenshot;
import testNGPOM.FacebookLoginPOM;

public class FacebookLoginTestClass extends FacebookBrowserSetUp
{
	WebDriver driver;
	ExtentReports extent;
	ExtentTest logger;
 @BeforeTest
 public void BrowserLaunch()
 {   
	
	 WebDriver driver=launchChromeBrowser();
	 this.driver=driver;
	/* ExtentHtmlReporter reporter=new ExtentHtmlReporter("./test-output/testproof.html");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		logger=extent.createTest("profile");*/
 }
 
 @Test
 public void verifyLogin() throws IOException, InterruptedException
 {
	 FacebookLoginPOM lp=new FacebookLoginPOM(driver);
	 lp.userID();
	 Thread.sleep(3000);
	 lp.password();
	 Thread.sleep(3000);
	 lp.verifylogin();
	 Thread.sleep(5000);
	 
	 Screenshot.captureScreenshot(driver);
 }
 @Test
 public void profile()
 {
	 System.out.println("verify profile");
	 Assert.fail();
 }
 @AfterTest
 public void screenshot(ITestResult result) throws IOException
 {
	 /*if(result.getStatus()==ITestResult.FAILURE)
	  {
	  String ss=Screenshot.captureScreenshot(driver);
	  logger.fail(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(ss).build());
	  }
	  extent.flush();*/
	  driver.close();
 }
}
