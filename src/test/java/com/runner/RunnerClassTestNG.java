package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="C:\\Users\\HAPPY\\eclipse-workspace\\sampleProject\\src\\test\\java\\com\\feature",
		glue = { "com.stepdefinition","myHooks" }, 
		dryRun = false, 
		monochrome = true, 
		publish = true, tags = "@validusername")

public class RunnerClassTestNG extends AbstractTestNGCucumberTests {

}
