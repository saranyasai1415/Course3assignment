package com.sample.pagesevents;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sample.base.BaseTest;
import com.sample.pageobjects.HomePageElements;
import com.sample.utils.ElementFetch;

public class HomePageEvents {

	ElementFetch ele = new ElementFetch();
	public void searchBus() {
		ele.getWebElement("ID", HomePageElements.from).sendKeys("Madiwala,Bangalore");
		ele.getWebElement("ID", HomePageElements.to).sendKeys("Tambaram,Chennai");
		ele.getWebElement("ID", HomePageElements.date).click();
		WebElement calendarPopup = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='rb-calendar_onward_cal']")));
		WebElement dateElement = calendarPopup.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[7]/td[4]"));
		dateElement.click();
			ele.getWebElement("XPATH",HomePageElements.search).click();
	}
}
