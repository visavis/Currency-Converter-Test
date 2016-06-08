package com.wissenteil.oftest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wissenteil.oftest.helpers.CalendarHelper;

public class ConverterPage {
	private WebDriver driver;

	private final static String PAGE_URL = "http://www.oanda.com/currency/converter/";

	private Pattern computedCurrencyPattern = Pattern
			.compile("(\\d*\\,*\\d+\\.\\d+)");
	private Pattern dayOfMonthPattern = Pattern.compile("(\\d+)");

	public ConverterPage(WebDriver driver) {
		this.driver = driver;

	}

	public void open() {
		driver.get(PAGE_URL);
		// Initialize Elements
		PageFactory.initElements(driver, this);
	}

	// Locators

	@FindBy(id = "quote_currency_input")
	WebElement quoteCurrencySelect;

	@FindBy(id = "base_currency_input")
	WebElement baseCurrencySelect;

	@FindBy(id = "quote_amount_input")
	WebElement payInputField;

	@FindBy(id = "end_date_input")
	WebElement calendarDateInput;

	@FindBy(id = "date_rewind")
	WebElement calendarDateRewind;
	
	@FindBy(id = "date_forward")
	WebElement calendarDateForward;

	@FindBy(id = "buyMyCurrencyCost")
	WebElement buyCurrencyCost;

	@FindBy(id = "sellMyCurrencyGet")
	WebElement sellCurrencyGet;

	// methods // return first numeric value found within given string
	public int getDay(String date) {
		Matcher m = dayOfMonthPattern.matcher(date);
		String day = "";
		if (m.find()) {
			day = m.group();
		}
		return Integer.parseInt(day);
	}

	public void goToFridayBeforeLastWeekend() {
		int lastSunday = CalendarHelper.getLastSunday();
		int lastFriday = lastSunday - 2;
		while (getDay(calendarDateInput.getAttribute("value")) > lastFriday) {
			calendarDateRewind.click();
		}
	}

	public String getFormattedAmountString(WebElement element) {
		Matcher m = computedCurrencyPattern.matcher(element.getText());
		String amount = "";
		while (m.find()) {
			amount = amount.concat(m.group());
			amount = amount.replaceAll(",", "");
		}
		return amount;
	}
	
	public void waitForConverterToCompute(WebElement element, String expectedRate) {
		int i = 1;
		while (!getFormattedAmountString(element).equals(expectedRate) && i <= 100) {
			try {
				Thread.sleep(100);
				System.out.println("Waiting " + i + "x 100 ms");
				System.out.println(getFormattedAmountString(element));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
	}

	public void waitUntil(boolean condition) {
		int i = 1;
		while (!condition && i <= 25) {
			try {
				Thread.sleep(100);
				System.out.println("Waiting " + i + "x 20 ms");
				System.out.println(condition);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
	}
}
