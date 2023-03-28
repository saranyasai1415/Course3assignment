package qa.tests;

import org.testng.annotations.Test;

import com.sample.base.BaseTest;
import com.sample.pagesevents.BookingPageEvents;
import com.sample.pagesevents.HomePageEvents;
import com.sample.utils.ElementFetch;

public class TestCase1 extends BaseTest {
  
	ElementFetch ele = new ElementFetch();
	HomePageEvents homePage = new HomePageEvents();
	BookingPageEvents bookingPage = new BookingPageEvents();
	@Test
  public void sampleMethodForSearching() {
		
		homePage.searchBus();
		bookingPage.verifyHomePageIsLoaded();
  }
}
