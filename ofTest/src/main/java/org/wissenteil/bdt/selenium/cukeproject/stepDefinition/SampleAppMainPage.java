package org.wissenteil.bdt.selenium.cukeproject.stepDefinition;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.wissenteil.bdt.selenium.cukeproject.test.CucumberTestConfiguration;

/**
 * @author Andrzej Czechowski
 * The MainPage class in this test setup serves three purposes:
 * Store page objects that are common to all pages (header, footer etc.),
 * Implement methods that are not specific to any Page, like waitForLoad(),
 * Share references to WebDriver, Base Page URL and JS Executor with child classes
 */
public class SampleAppMainPage {
	protected WebDriver driver;
	protected StringBuilder pageUrl;
	protected JavascriptExecutor js;

	public SampleAppMainPage(String partialUrl) {
		this.driver = CucumberTestConfiguration.getDriver();
		this.js = CucumberTestConfiguration.getJs();
		this.pageUrl = new StringBuilder(CucumberTestConfiguration.getBaseUrl())
				.append(partialUrl);
	}

	public SampleAppMainPage() {
		this("");
	}

	public void open() {
		driver.get(pageUrl.toString());
		PageFactory.initElements(driver, this);
	}
	
	public void init() {
		PageFactory.initElements(driver, this);
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public String getPageUrl() {
		return pageUrl.toString();
	}

	/**
	 * Disable driver input fields validations for HTML5 forms Workaround thanks
	 * to {@link http://novalidate.com/} 
	 */

	public void noValidate() {
		js.executeScript("for(var f=document.forms,i=f.length;i--;)f[i].setAttribute('novalidate',i)");
	}

	public void waitForLoad(long timeOutInSeconds) {
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


	// Header

	@FindBy(xpath = "//a[@href = '/login']")
	WebElement loginLink;

	// Body


	@FindBy(linkText = "Sign up now!")
	WebElement signupButton;

	// Footer

}
