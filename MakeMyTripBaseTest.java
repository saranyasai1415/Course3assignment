package com.sample.TicketBooking;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class MakeMyTripBaseTest {

	WebDriver driver;

	@BeforeMethod

	public void setUp() {
		// Set up the driver
		System.setProperty("webdriver.gecko.driver", "C:\\firefoxdriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void tearDown() {
		// close the WebDriver instance
		driver.quit();
	}

	public void navigateTo(String url) {
		// navigate to the given URL
		driver.get(url);
	}
}
