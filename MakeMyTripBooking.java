package com.sample.TicketBooking;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MakeMyTripBooking extends MakeMyTripBaseTest {

	@Parameters({ "env" })
	@Test
	public void testBooking(String env) {
		// Navigate to the booking page
		String url = env.equals("dev") ? "https://www.confirmtkt.com" : "https://www.staging.confirmtkt.com";
		driver.get(url);

		// Fill in the form
		driver.findElement(By.id("searchtrains")).click();

		String expectedTitle = "Confirm Ticket - Train Ticket booking Online | Train seat availability";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);

	}

}
