package ZoomInfo.ChatBotTesting;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src\\test\\java\\ZoomInfo\\ChatBotTesting",glue="ZoomInfo.ChatBotTesting",
monochrome=true,plugin= {"html:target/results.html"})
public class TestRunner extends AbstractTestNGCucumberTests{

	
}