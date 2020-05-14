package com.travelocity.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.travelocity.utilities.BrowserUtilities;

import com.travelocity.utilities.Driver;
import com.travelocity.utilities.LoggerUtils;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import com.travelocity.pages.CarPage;

public class CarsSearchStepDef {
	Logger logger = LoggerUtils.getLogger(CarsSearchStepDef .class);
	

@When("Click on cars")
public void click_on_cars() {
	CarPage carpage = new CarPage();
	   carpage.carsClickBitton.click();
}

@Then("The cars page title should be Wander Wisely with Cheap Hotels, Flights, Vacations & Travel Deals | Travelocity")
public void the_cars_page_title_should_be_Wander_Wisely_with_Cheap_Hotels_Flights_Vacations_Travel_Deals_Travelocity() {
	CarPage carpage = new CarPage();
	 logger.info("Verify title");
	 carpage.carsClickBitton.click();
	 String actual = Driver.getDriver().getTitle();
	 String expected = "Wander Wisely with Cheap Hotels, Flights, Vacations & Travel Deals | Travelocity";

		try {
			assertEquals(expected, actual);
			logger.info("Title Verification passed");

		} catch (AssertionError e) {

			logger.error("Title Verification failed");
			logger.error(e.toString());
			throw e; // re-throw my error so that my test fails
		}
}

@When("Click on Picking up")
public void click_on_Picking_up() {
	CarPage carpage = new CarPage();
	 logger.info("Clicking on Car Pick up Location");
	 carpage.carPickingUp.click();
}

@When("Enter {string} as a pick up location")
public void enter_as_a_pick_up_location(String string) {
	 CarPage carpage = new CarPage();
	 logger.info("Entering Los as pick up location");
	 carpage.carPickingUp.sendKeys("Los");
	 BrowserUtilities.waitFor(2);
	 carpage.carPickingUp.sendKeys(""  + Keys.ARROW_DOWN + Keys.ENTER);
}

@Then("Picking up field should contain {string}")
public void picking_up_field_should_contain(String string) {
	CarPage carpage = new CarPage();
	 logger.info("Verifiying pick up location contaons Los Angeles");
	 carpage.carPickingUp.getText().contains("Los Angeles");
}

@When("Click on Drop off")
public void click_on_Drop_off() {
	CarPage carpage = new CarPage();
	 logger.info("Clicking on drop off field");
	 carpage.carDropingOff.click();
}

@When("Enter {string} as a drop off location")
public void enter_as_a_drop_off_location(String string) {
	CarPage carpage = new CarPage();
	logger.info("Entering San as drop off location");
	carpage.carDropingOff.sendKeys(string);
	BrowserUtilities.waitFor(3);
	carpage.carDropingOff.sendKeys("" + Keys.ARROW_DOWN + Keys.ENTER);
	
}

@Then("Dropping off field should contain {string}")
public void dropping_off_field_should_contain(String string) {
	 CarPage carpage = new CarPage();
	 carpage.carDropingOff.click();
	 logger.info("Verifiyingdrop off location contaons San Francisco");
	 carpage.carDropingOff.getText().contains("San Francisco");
}


@When("User click on {string} as pick up location")
public void user_click_on_as_pick_up_location(String string) {
	CarPage carpage = new CarPage();
	carpage.carPickingUp.sendKeys(string);
}

@When("User click on {string} as drop off location")
public void user_click_on_as_drop_off_location(String string) {
	CarPage carpage = new CarPage();
	carpage.carDropingOff.sendKeys(string);
}

@When("User pick {string} as pick up date")
public void user_pick_as_pick_up_date(String string) {
	CarPage carpage = new CarPage();
	carpage.carPickUpDate.sendKeys(string);
}

@When("User click {string} as pick up time")
public void user_click_as_pick_up_time(String string) {
	CarPage carpage = new CarPage();
	carpage.carSelectPickUpTime.sendKeys(string);
}

@When("User pick {string} as drop off date")
public void user_pick_as_drop_off_date(String string) {
	CarPage carpage = new CarPage();
	carpage.carDropOffDate.sendKeys(string);
}

@When("User pick {string} as drop off time")
public void user_pick_as_drop_off_time(String string) {
	CarPage carpage = new CarPage();
	carpage.carSelectDropOffTime.sendKeys(string);
}

@Then("User click on Search button")
public void user_click_on_Search_button() {
	CarPage carpage = new CarPage();
	carpage.carsSearhButton.click();
}

@Then("User verify page title")
public void user_verify_page_title() {
	CarPage carpage = new CarPage();
	carpage.carsSearhButton.click();
    Assert.assertTrue(Driver.getDriver().getTitle().contains("Rental"));
	
}


}