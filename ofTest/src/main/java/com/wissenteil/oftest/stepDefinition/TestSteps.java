package com.wissenteil.oftest.stepDefinition;



import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.WebDriver;

import com.wissenteil.oftest.test.CucumberDriverConfiguration;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestSteps {
	
	private static WebDriver driver = CucumberDriverConfiguration.getDriver();
	private ConverterPage converterPage = new ConverterPage(driver);
	
	String youGet;
	String youPay;
	
	@Given("^that I navigate to Oanda converter page$")
	public void navigateToConverterPage() throws Throwable {
		converterPage.open();
	}

	@When("^I change the date to Friaday before last weekend$")
	public void setDateToFridayBeforeLastWeekend() throws Throwable {
		converterPage.goToFridayBeforeLastWeekend();
	}

	@When("^I change the date by one day forward$")
	public void changeDateOneDayForward() throws Throwable {
		converterPage.calendarDateForward.click();
	}
	
	@When("^I store the exchange rates$")
	public void storeTheExchangeRates() throws Throwable {
		youGet = converterPage.getFormattedAmountString(converterPage.sellCurrencyGet);
		youPay = converterPage.getFormattedAmountString(converterPage.buyCurrencyCost);
	}
	
	@When("^I store some dummy exchange rates$")
	public void storeDummyExchangeRates() throws Throwable {
		youGet = "100";
		youPay = "100";
	}

	@Then("^the exchange rate will be same as on Friday$")
	public void theExchangeRateWillbeSameAsOnFriday() throws Throwable {
		assertEquals(converterPage.getFormattedAmountString(converterPage.sellCurrencyGet), youGet);
		assertEquals(converterPage.getFormattedAmountString(converterPage.buyCurrencyCost), youPay);
	}
}
