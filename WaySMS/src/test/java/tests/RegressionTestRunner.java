package tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features=  {"F:\\Naidu\\MavenProjects\\src\\test\\resources\\PropertiesResource\\feature1.feature",
		"F:\\Naidu\\MavenProjects\\src\\test\\resources\\PropertiesResource\\feature2.feature"}, 
		plugin= {"pretty","html:target/RegressionTestRes","rerun:target\\ftests.txt"},tags= {"~@smoketest"}, monochrome=true)
public class RegressionTestRunner 
{

}
