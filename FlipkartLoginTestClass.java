package TestClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import DataFetchFromExcel.FlipkartLoginDataFetch;
import Utility.Screenshot;
import Utility.FlipkartBrowserSetup;
import testNGPOM.FlipkartCartCheck;
import testNGPOM.FlipkartLoginPOM;
import testNGPOM.FlipkartLogout;

public class FlipkartLoginTestClass extends FlipkartBrowserSetup
{
	WebDriver driver;
	ExtentReports extent;
	ExtentTest logger;
  @BeforeClass
  public void BrowserLaunch()
  {
	WebDriver driver=BrowserSetup();  
	this.driver=driver;
	
	ExtentHtmlReporter reporter=new ExtentHtmlReporter("./test-output/TestProof.html");
	extent=new ExtentReports();
	extent.attachReporter(reporter);
	logger=extent.createTest("checkCart");
	//logger=extent.createTest("checkProfile");
  }
  @BeforeMethod
  public void Login() throws EncryptedDocumentException, InvalidFormatException, IOException
  {
	  FlipkartLoginPOM flp=new FlipkartLoginPOM(driver); 
	  flp.insertUserId(FlipkartLoginDataFetch.logindatafetchid(1, 0));
	  flp.insertPassword(FlipkartLoginDataFetch.logindatafetchpassword(1, 1));
	  flp.clickOnLogin();
  }
  @Test
  public void checkCart() throws InterruptedException, IOException
  {   Thread.sleep(5000);
	  FlipkartCartCheck fcc=new FlipkartCartCheck(driver);
	  fcc.cartCheck();
	  Thread.sleep(5000);
	 
	  Screenshot.captureScreenshot(driver);
	  driver.navigate().back();
	  
  }
  @Test
  public void checkProfile() throws InterruptedException, IOException
  {
	  System.out.println("profile checked");
	  Assert.fail();
	  Thread.sleep(9900);
	  
	  Screenshot.captureScreenshot(driver);
  }

  @AfterMethod
  public void LogOut(ITestResult result) throws InterruptedException, IOException
  {
	 
	  /*if(result.getStatus()==ITestResult.FAILURE)
	  {
	  String ss=Screenshot.captureScreenshot(driver);
	  logger.fail(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(ss).build());
	  }
	  extent.flush();*/
	  
	  Thread.sleep(5000);
	  FlipkartLogout fl=new FlipkartLogout(driver);
	  fl.clickOnSagar();
	  Thread.sleep(5000);
	  fl.clickOnLogout();
	  
  }
  @AfterClass   
  public void flipkartClose() throws InterruptedException
  {
	  Thread.sleep(2000);
	  driver.close();
  }
}
