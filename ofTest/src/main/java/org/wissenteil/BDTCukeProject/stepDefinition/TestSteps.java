package org.wissenteil.BDTCukeProject.stepDefinition;


import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestSteps {
	
	private SampleAppMainPage mainPage = new SampleAppMainPage();
	private SignupPage signupPage = new SignupPage("/signup");
	private LoginPage loginPage = new LoginPage("/login");
	
	@Given("^that I navigate to sample app$")
	public void navigateToMainPage() throws Throwable {
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
	
	@When("^I fill the username input with (.*) on signup page$")
	public void fillUsernameInputWith(String cukeParam) {
	   signupPage.usernameInput.sendKeys(cukeParam);
	}

	@When("^I fill the email input with (.*) on signup page$")
	public void fillEmailInputWith(String cukeParam) {
		   signupPage.emailInput.sendKeys(cukeParam);
		}

	@When("^I fill the password input with (.*) on signup page$")
	public void fillPasswordInputWith(String cukeParam) {
		   signupPage.passwordInput.sendKeys(cukeParam);
		}

	@When("^I fill the password confiration input with (.*) on signup page$")
	public void fillPasswordConfirmationWith(String cukeParam) {
		   signupPage.confirmationInput.sendKeys(cukeParam);
		}
	
	@When("^I click submit button$")
	public void clickSubmit() {
		signupPage.newAccountSubmit.click();
	}
	
	@Then("^I will be redirected to signup page$")
	public void waitForSignupPageToLoad() {
		signupPage.waitForPageToLoad(10);
		assertEquals(signupPage.getPageUrl(), signupPage.getCurrentUrl());
	}
	
	@Then("^I will see the Name input field on signup page$")
	public void isNameInputPresent() {
		signupPage.waitForElement(signupPage.usernameInput, 3);
		assertTrue(signupPage.usernameInput.isDisplayed());
	}
	
	@Then("^I will see the Email input field on signup page$")
	public void isEmailInputPresent() {
		assertTrue(signupPage.usernameInput.isDisplayed());
	}
	
	@Then("^I will see the Password input field on signup page$")
	public void isPasswordInputPresent() {
		assertTrue(signupPage.usernameInput.isDisplayed());
	}
	
	@Then("^I will see the Password confirmation input field on signup page$")
	public void isPasswordConfirmationInputPresent() {
		assertTrue(signupPage.usernameInput.isDisplayed());
	}
	
	@Then("^I will see the alert saying: (.*) on signup page$")
	public void isAlertTextPresent(String text) {
		assertEquals(text, signupPage.alertWarnings.get(0).getText());
	}
	
	@Then("^I will see Welcome to the Sample App! alert$")
	public void isWelcomeAlertPresent() {
		assertTrue(signupPage.welcomeAlertSuccess.isDisplayed());
	}
}
