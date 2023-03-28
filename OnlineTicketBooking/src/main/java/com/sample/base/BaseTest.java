package com.sample.base;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.sample.utils.*;

public class BaseTest {
	public static WebDriver driver;
	public ExtentSparkReporter sparkReporter;
	public ExtentTest logger;
	public ExtentReports report;

	@BeforeTest
	public void beforeTestMethod() {

		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+File.separator+"reports"+File.separator+"ExtentReportResults.html");
		report = new ExtentReports();
		report.attachReporter(sparkReporter);
		//test = report.startTest("ExtentDemo");
	}
	@BeforeMethod
	@Parameters("browser")

	public void beforeMethod(String browser,Method testMethod) {

		logger = report.createTest(testMethod.getName());
		setupDriver(browser);
		driver.manage().window().maximize();
		driver.get(Constants.url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
	}

	@AfterMethod

	public void afterMethod(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL,MarkupHelper.createLabel(result.getName() +"Test Case Failed ",ExtentColor.RED));
			logger.log(Status.FAIL,MarkupHelper.createLabel(result.getThrowable() +"Test Case Failed ",ExtentColor.RED));
		}
		else if(result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP,MarkupHelper.createLabel(result.getName() +"Test Case Skipped ",ExtentColor.ORANGE));
		}
		else if(result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS,MarkupHelper.createLabel(result.getName() +"Test Case pass ",ExtentColor.GREEN));
		}
		driver.quit();
	}

	@AfterTest
	public void afterTest() {

		report.flush();
	}

	public void setupDriver(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();}
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();}
	}

}


