package com.wissenteil.oftest.stepDefinition;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends SampleAppMainPage {
	
	public LoginPage(String partialUrl) {
		super(partialUrl);
	}
	
	
	@FindBy(xpath = "//input[@type = 'submit']")
	WebElement loginButton;

}
