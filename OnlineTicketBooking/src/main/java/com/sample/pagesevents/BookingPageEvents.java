package com.sample.pagesevents;

import org.testng.Assert;

import com.sample.base.BaseTest;
import com.sample.pageobjects.BookingPageElements;
import com.sample.utils.ElementFetch;

public class BookingPageEvents {

	ElementFetch ele = new ElementFetch();
	public void verifyHomePageIsLoaded() {
		
		String actualTitle = BaseTest.driver.getTitle();
		Assert.assertEquals(actualTitle, BookingPageElements.expectedTitle);
	}
}
