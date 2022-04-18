package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\HAPPY\\eclipse-workspace\\sampleProject\\src\\test\\java\\com\\feature",
glue= {"com.stepdefinition","myHooks"},dryRun=false,monochrome=true,publish=true)

public class RunnerClass{
	
	

}
