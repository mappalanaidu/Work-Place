package tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features={"@target\\ftests.txt"}, 
		plugin= {"pretty","html:target/ReTestRes","rerun:target\\ftests.txt"}, monochrome=true)
public class ReTestRunner 
{

}
