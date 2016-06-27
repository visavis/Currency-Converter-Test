package org.wissenteil.bdt.selenium.cukeproject.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CucumberTestConfiguration {
	private static WebDriver driver;
	private static JavascriptExecutor js;
	private static final String BASE_URL = "https://wiesenttal.herokuapp.com";
	
	public static void setDriver() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;
	}
	
	public static void destroyAllDrivers() {
		driver.close();
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static JavascriptExecutor getJs() {
		return js;
	}
	
	public static String getBaseUrl() {
		return BASE_URL;
	}
}
