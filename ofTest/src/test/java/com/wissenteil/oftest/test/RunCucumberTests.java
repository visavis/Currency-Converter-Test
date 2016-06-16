package com.wissenteil.oftest.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;



//@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/features/"}, 
glue = {"com.wissenteil.oftest.stepDefinition"},
plugin = { "pretty","json:target/stepdefinition.json" })




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
