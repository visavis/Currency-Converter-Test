package org.wissenteil.bdt.selenium.cukeproject.stepDefinition;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.wissenteil.bdt.selenium.cukeproject.test.CucumberTestConfiguration;

public class SampleAppMainPage {
	protected WebDriver driver;
	protected StringBuilder pageUrl;

	public SampleAppMainPage(String partialUrl) {
		this.driver = CucumberTestConfiguration.getDriver();
		this.pageUrl = new StringBuilder(CucumberTestConfiguration.getBaseUrl())
				.append(partialUrl);
	}

	public SampleAppMainPage() {
		this("");
	}

	public void open() {
		driver.get(pageUrl.toString());
		// Initialize Elements
		PageFactory.initElements(driver, this);
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public String getPageUrl() {
		return pageUrl.toString();
	}

	/**
	 * Disable driver input fields validations for HTML5 forms
	 * Workaround thanks to @http://novalidate.com/
	 */

	public void noValidate() {
		((JavascriptExecutor) driver)
				.executeScript("for(var f=document.forms,i=f.length;i--;)f[i].setAttribute('novalidate',i)");
	}

	public void waitForPageToLoad(long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.urlToBe(getPageUrl()));
	}

	public void waitForElement(WebElement element, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public boolean isLoaded() {
		return getCurrentUrl().equals(pageUrl.toString());
	}

	// Locators

	// Header

	@FindBy(xpath = "//a[@href = '/login']")
	WebElement loginLink;

	// Body

	@FindBy(id = "quote_currency_input")
	WebElement quoteCurrencySelect;

	@FindBy(linkText = "Sign up now!")
	WebElement signupButton;

	// Footer

}
