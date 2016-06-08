package com.wissenteil.oftest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExchangeRateOverTheWeekendTest {
	private WebDriver driver;
	private ConverterPage converterPage;
	

	@Test
	public void pricesShouldNotChangeOverTheWeekend() {
		
		
		converterPage = new ConverterPage(driver);
		converterPage.open();		
		
		converterPage.goToFridayBeforeLastWeekend();
		
		String youGet = converterPage.getFormattedAmountString(converterPage.sellCurrencyGet);
		String youPay = converterPage.getFormattedAmountString(converterPage.buyCurrencyCost);
		
		converterPage.calendarDateForward.click();		
		
		Assert.assertEquals(converterPage.getFormattedAmountString(converterPage.sellCurrencyGet), youGet);
		Assert.assertEquals(converterPage.getFormattedAmountString(converterPage.buyCurrencyCost), youPay);
		
		converterPage.calendarDateForward.click();		
		
		Assert.assertEquals(converterPage.getFormattedAmountString(converterPage.sellCurrencyGet), youGet);
		Assert.assertEquals(converterPage.getFormattedAmountString(converterPage.buyCurrencyCost), youPay);
		
	}

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
