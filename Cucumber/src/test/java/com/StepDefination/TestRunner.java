package com.StepDefination;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
features="OrangeHRM.feature",
glue="com.StepDefination",
monochrome=true,
tags= "@tag1"



)

public class TestRunner {

}
