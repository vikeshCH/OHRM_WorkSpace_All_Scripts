package com.TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="OrangeHRM",
 glue="com.StepDefination", // will connect the feature file with the
                           //  the Cucumber class in which the User-defined
                           //    methods are created and implemented with
                           //      the steps to be performed
 monochrome=true // Removes the junk data from the eclipse console - related to test Results
 // dryRun=true // will compare the Feature file with Cucumber Class and
                //   for the newly defined Scenario step - it will create
                //      User defined methods without executing the Scenarios
 

)

public class TestRunner {

}
