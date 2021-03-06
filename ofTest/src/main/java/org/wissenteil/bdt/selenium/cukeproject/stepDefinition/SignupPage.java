package org.wissenteil.bdt.selenium.cukeproject.stepDefinition;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

public class SignupPage extends SampleAppMainPage {

	public SignupPage(String partialUrl) {
		super(partialUrl);
	}

	// Locators

	@FindBy(how = How.ID, using = "user_name")
	WebElement newUsernameInput;

	@FindBy(id = "user_email")
	WebElement newEmailInput;

	@FindBy(id = "user_password")
	WebElement newPasswordInput;

	@FindBy(id = "user_password_confirmation")
	WebElement newConfirmationInput;

	@FindBy(xpath = "//input[@value = 'Create account']")
	WebElement newAccountSubmit;
	// TODO move to new PageClass
	@FindBy(xpath = "//div[contains(@class, 'alert-success') and text() = 'Welcome to the Sample App!']")
	WebElement welcomeAlertSuccess;

	@FindBys({ @FindBy(xpath = "//div[@id = 'error_explanation']/ul/li") })
	public List<WebElement> alertWarnings;

	// Methods

}
