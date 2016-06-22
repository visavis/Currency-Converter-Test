package org.wissenteil.BDTCukeProject.stepDefinition;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends SampleAppMainPage {
	
	public LoginPage(String partialUrl) {
		super(partialUrl);
	}
	
	@FindBy(id = "session_email")
	WebElement sessionEmailInput;
	
	@FindBy(id = "session_password")
	WebElement sessionUsernameInput;	
	
	@FindBy(xpath = "//input[@type = 'submit']")
	WebElement loginButton;

}
