package com.StepDefination;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="OrangeHRMApplication",
glue="com.StepDefination",
// will connect the Feature file(English language Statements with the
//  user defined methods to perform the corresponding Operations
monochrome=true // Remove the Junk data from the Console
)

public class TestRunner {
	
}
