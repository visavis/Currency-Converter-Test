package org.wissenteil.bdt.selenium.cukeproject.stepDefinition;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author Andrzej Czechowski Step Definitions are grouped by Page, they refer to.
 */
public class TestSteps {

	private SampleAppMainPage mainPage = new SampleAppMainPage();
	private SignupPage signupPage = new SignupPage("/signup");
	private LoginPage loginPage = new LoginPage("/login");

	// * MainPage steps *

	@Given("^that I navigate to sample app$")
	public void navigateToMainPage() {
		mainPage.open();
	}

	@When("^I click Sign up now! button$")
	public void clickSignupButton() {
		mainPage.signupButton.click();
		signupPage.open();
	}

	@When("^I click login link$")
	public void clickLoginLink() {
		mainPage.loginLink.click();
		loginPage.open();
	}

// * SignupPage steps *
	@When("^I fill the username input with (.*) on signup page$")
	public void fillUsernameInputOnSignupPageWith(String cukeParam) {
		signupPage.newUsernameInput.sendKeys(cukeParam);
	}

	@When("^I fill the email input with (.*) on signup page$")
	public void fillEmailInputOnSignupPageWith(String cukeParam) {
		signupPage.newEmailInput.sendKeys(cukeParam);
	}

	@When("^I fill the password input with (.*) on signup page$")
	public void fillPasswordInputOnSignupPageWith(String cukeParam) {
		signupPage.newPasswordInput.sendKeys(cukeParam);
	}

	@When("^I fill the password confiration input with (.*) on signup page$")
	public void fillPasswordConfirmationOnSignupPageWith(String cukeParam) {
		signupPage.newConfirmationInput.sendKeys(cukeParam);
	}

	@When("^I click submit button$")
	public void clickSubmit() {
		signupPage.newAccountSubmit.click();
	}

	@Then("^I will be redirected to signup page$")
	public void redirectedToSignupPage() {
		signupPage.waitForLoad(10);
		signupPage.noValidate();
		assertEquals(signupPage.getPageUrl(), signupPage.getCurrentUrl());
	}

	@Then("^I will see the Name input field on signup page$")
	public void isNameInputPresent() {
		signupPage.waitForElement(signupPage.newUsernameInput, 3);
		assertTrue(signupPage.newUsernameInput.isDisplayed());
	}

	@Then("^I will see the Email input field on signup page$")
	public void isEmailInputPresent() {
		assertTrue(signupPage.newUsernameInput.isDisplayed());
	}

	@Then("^I will see the Password input field on signup page$")
	public void isPasswordInputPresent() {
		assertTrue(signupPage.newUsernameInput.isDisplayed());
	}

	@Then("^I will see the Password confirmation input field on signup page$")
	public void isPasswordConfirmationInputPresent() {
		assertTrue(signupPage.newUsernameInput.isDisplayed());
	}

	@Then("^I will see the alert saying: (.*), on signup page$")
	public void isAlertTextPresent(String text) {
		assertEquals(text, signupPage.alertWarnings.get(0).getText());
	}

	// TODO move to User page when dealt with transactional tests
	@Then("^I will see Welcome to the Sample App! alert$")
	public void isWelcomeAlertPresent() {
		assertTrue(signupPage.welcomeAlertSuccess.isDisplayed());
	}

//	 * LoginPage steps *
	@Then("^I will be redirected to login page$")
	public void redirectedToLoginPage() {
		loginPage.waitForLoad(10);
		loginPage.noValidate();
		assertEquals(loginPage.getPageUrl(), loginPage.getCurrentUrl());
	}

	@When("^I fill the Email input field with (.*) on login page$")
	public void fillEmailInputFieldOnLoginPageWith(String cukeParam) {
		loginPage.sessionEmailInput.sendKeys(cukeParam);
	}

	@When("^I fill the Password input field with (.*) on login page$")
public void fillPasswordInputFieldOnLoginPageWith(String cukeParam) {
		loginPage.sessionPasswordInput.sendKeys(cukeParam);
	}

	@When("^I click sign in button$")
	public void clickSignInButton() {
		loginPage.loginButton.click();
	}
}
