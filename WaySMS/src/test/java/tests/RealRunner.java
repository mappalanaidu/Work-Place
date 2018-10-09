package tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features={"C:\\Users\\Naidu\\TestingWorkSpace\\WaySMS\\src\\test\\resources\\PropertiesResource\\feature1.feature",
		"C:\\Users\\Naidu\\TestingWorkSpace\\WaySMS\\src\\test\\resources\\PropertiesResource\\feature2.feature"},
		plugin= {"pretty","html:target"},monochrome=true)
public class RealRunner
{
}
