package com.wissenteil.oftest.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CucumberDriverConfiguration {
	private static WebDriver driver;
	
	public static void setDriver() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	public static void destroyAllDrivers() {
		driver.close();
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
}
