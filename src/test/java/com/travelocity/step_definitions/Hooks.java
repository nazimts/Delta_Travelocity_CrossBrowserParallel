package com.travelocity.step_definitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import com.travelocity.utilities.ConfigReader;
import com.travelocity.utilities.Driver;

public class Hooks {
	
	@Before ()
	public void setUp() {
		
		Driver.getDriver().manage().timeouts().implicitlyWait(
				(Long.parseLong(ConfigReader.getConfiguration("implicitTimeout"))), TimeUnit.SECONDS);
		Driver.getDriver().manage().window().maximize();


	}
	
	
	@After()
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
					}
		Driver.closeDriver();
	}

}
