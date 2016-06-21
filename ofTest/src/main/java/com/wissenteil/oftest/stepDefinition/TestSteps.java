package com.wissenteil.oftest.stepDefinition;


import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestSteps {
	
	private SampleAppMainPage mainPage = new SampleAppMainPage();
	private SignupPage signupPage = new SignupPage("/signup");
	
	String youGet;
	String youPay;
	
	@Given("^that I navigate to sample app$")
	public void navigateToMainPage() throws Throwable {
		mainPage.open();
	}
	
	@When("^I click Sign up now! button$")
	public void clickSignupButton() {
		mainPage.signupButton.click();
	}
	
	@When("^I fill the username input with (.*)$")
	public void fillUsernameInputWith(String cukeParam) {
	   signupPage.usernameInput.sendKeys(cukeParam);
	}

	@When("^I fill the email input with (.*)$")
	public void fillEmailInputWith(String cukeParam) {
		   signupPage.emailInput.sendKeys(cukeParam);
		}

	@When("^I fill the password input with (.*)$")
	public void fillPasswordInputWith(String cukeParam) {
		   signupPage.passwordInput.sendKeys(cukeParam);
		}

	@When("^I fill the password confiration input with (.*)$")
	public void fillPasswordConfirmationWith(String cukeParam) {
		   signupPage.confirmationInput.sendKeys(cukeParam);
		}
	
	@When("^I click submit button$")
	public void clickSubmit() {
		signupPage.newAccountSubmit.click();
	}
	
	@When("^I wait for signup page to load$")
	public void waitForSignupPage() {
		signupPage.waitForPageToLoad(10);
	}
	
	@Then("^I will be redirected to signup page$")
	public void isSignupPageLoaded() {
		signupPage.waitForPageToLoad(3);
		signupPage.open();
		assertEquals(signupPage.getPageUrl(), signupPage.getCurrentUrl());
	}
	
	@Then("^I will see the Name input field$")
	public void isNameInputPresent() {
		signupPage.waitForElement(signupPage.usernameInput, 3);
		assertTrue(signupPage.usernameInput.isDisplayed());
	}
	
	@Then("^I will see the Email input field$")
	public void isEmailInputPresent() {
		assertTrue(signupPage.usernameInput.isDisplayed());
	}
	
	@Then("^I will see the Password input field$")
	public void isPasswordInputPresent() {
		assertTrue(signupPage.usernameInput.isDisplayed());
	}
	
	@Then("^I will see the Password confirmation input field$")
	public void isPasswordConfirmationInputPresent() {
		assertTrue(signupPage.usernameInput.isDisplayed());
	}
	
	@Then("^I will see the alert saying: (.*)$")
	public void isAlertTextPresent(String text) {
		assertEquals(text, signupPage.alertWarnings.get(0).getText());
	}
	
	@Then("^I will see Welcome to the Sample App! alert$")
	public void isWelcomeAlertPresent() {
		assertTrue(signupPage.welcomeAlertSuccess.isDisplayed());
	}
}
