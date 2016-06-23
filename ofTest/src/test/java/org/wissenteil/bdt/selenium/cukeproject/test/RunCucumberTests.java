package org.wissenteil.bdt.selenium.cukeproject.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;



//@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/features/"}, 
glue = {"org.wissenteil.bdt.selenium.cukeproject.stepDefinition"},
plugin = { "pretty", "json:target/cucumber.json" })

public class RunCucumberTests extends AbstractTestNGCucumberTests {	
	
	
	@BeforeClass
	public void setup() {
		CucumberTestConfiguration.setDriver();		
	}
	
	@AfterClass
	public void tearDown() {
		CucumberTestConfiguration.destroyAllDrivers();
	}
}
