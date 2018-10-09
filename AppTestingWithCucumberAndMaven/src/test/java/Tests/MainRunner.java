package Tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features=
{"C:\\Users\\Naidu\\TestingWorkSpace\\AppTestingWithCucumberAndMaven\\src\\test\\resources\\Resources\\feature1.feature",
 "C:\\Users\\Naidu\\TestingWorkSpace\\AppTestingWithCucumberAndMaven\\src\\test\\resources\\Resources\\feature2.feature"},
 plugin= {"pretty","html:target"}, monochrome=true)

public class MainRunner 
{

}
