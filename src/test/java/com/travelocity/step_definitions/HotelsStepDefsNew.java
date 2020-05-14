package com.travelocity.step_definitions;

import static org.junit.Assert.assertTrue;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import com.travelocity.pages.HotelsPageNew;
import com.travelocity.pages.HotelResultPageNew;
import com.travelocity.utilities.BrowserUtilities;
import com.travelocity.utilities.ConfigReader;
import com.travelocity.utilities.Driver;
import com.travelocity.utilities.LoggerUtils;

public class HotelsStepDefsNew {

	Logger logger = LoggerUtils.getLogger(FlightSearchStepDefs.class);

	@Given("I am on the TravelocityCom homepage")
	public void i_am_on_the_TravelocityCom_homepage() {
		Driver.getDriver().get(ConfigReader.getConfiguration("url"));
		logger.info("Navigating to a TravelocityCom home page");
		
		
	}
	
	@And("Click on Going to field")
	public void click_on_Going_to_field() {
		HotelsPageNew hotelspage = new HotelsPageNew();
		logger.info("Clicking on Going to field");
		hotelspage.hotelsMenu.click();
		hotelspage.goingToField.click();
		
	}

	@And("Enter {string} destination")
	public void enter_destination(String destination) {
		HotelsPageNew hotelspage = new HotelsPageNew();
		logger.info("Entering " + destination + " on Going to field");
		hotelspage.goingToField.sendKeys(destination);
		logger.info("Choose from given choices");
		BrowserUtilities.selectFromListByDataValue(hotelspage.destinationtList, destination);
		
	}


	
	@And("Click on Check in field")
	public void click_on_Check_in_field() {
		HotelsPageNew hotelspage = new HotelsPageNew();
		logger.info("Clicking on Check in field");
		hotelspage.checkInField.click();
		
	}

	@And("Set {string} {string} {string} date to Check in field")
	public void set_date_to_Check_in_field(String string, String string1, String string2) {
		HotelsPageNew hotelspage = new HotelsPageNew();
		logger.info("Setting date on Check in field --> June 16,2020");
		JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
		js.executeScript("arguments[0].click()", hotelspage.setDateNew(string, string1, string2));
		
	}
	
	@And("Click on Check out field")
	public void click_on_Check_out_field() {
		HotelsPageNew hotelspage = new HotelsPageNew();
		logger.info("Clicking on Check out field");
		hotelspage.checkOutField.click();
		
	}

	@And("Set {string} {string} {string} date to Check out field")
	public void set_date_to_Check_out_field(String string, String string1, String string2) {
		HotelsPageNew hotelspage = new HotelsPageNew();
		logger.info("Setting date on Check out field --> June 26,2020");
		JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
		js.executeScript("arguments[0].click()", hotelspage.setDateNew(string, string1, string2));
				
	}
	
	@Then("Select quantity of the rooms")
	public void select_quantaty_of_the_rooms() {
		HotelsPageNew hotelspage = new HotelsPageNew();
		logger.info("Selecting quantity of the rooms as 1 room");
		BrowserUtilities.selectByVisibleText(hotelspage.selectRoom, "1");
	}

	@Then("Select quantity of the adults")
	public void select_quantaty_of_the_adults() {
		HotelsPageNew hotelspage = new HotelsPageNew();
		logger.info("Selecting quantity of the adults as 3 adults");
		BrowserUtilities.selectByVisibleText(hotelspage.selectAdults, "3");
	}

	@Then("Select quantity of the children")
	public void select_quantaty_of_the_children() {
		HotelsPageNew hotelspage = new HotelsPageNew();
		logger.info("Selecting quantity of the children as 1 child");
		BrowserUtilities.selectByVisibleText(hotelspage.selectChild, "1");
	}

	@Then("Select children age")
	public void select_children_age() {
		HotelsPageNew hotelspage = new HotelsPageNew();
		logger.info("Selecting child age as 5 year old");
		BrowserUtilities.selectByVisibleText(hotelspage.selectChildAge, "5");
	}
	
	@Then("Click Search button")
	public void click_Search_button() {
		HotelsPageNew hotelspage = new HotelsPageNew();
		logger.info("Clicking on search button");
		JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
		js.executeScript("arguments[0].click()", hotelspage.searchButton);
		BrowserUtilities.waitFor(8);
//		HotelsResultPage hotelsResultpage = new HotelsResultPage();
//		System.out.println(hotelsResultpage.originField.getAttribute("value"));
//		System.out.println(hotelsResultpage.destitation.getAttribute("value"));
//		System.out.println(hotelsResultpage.startDate.getAttribute("value"));
//		System.out.println(hotelsResultpage.endDate.getAttribute("value"));
//		System.out.println(hotelsResultpage.roomInfo.getText());
//		System.out.println(hotelsResultpage.adultInfo.getText());
//		System.out.println(hotelsResultpage.childInfo.getText());
////		New York, NY, United States (JFK-John F. Kennedy Intl.)
////		Florida, United States of America
////		5/16/2020
////		5/26/2020
////		1 room,
////		3 adults,
////		1 child,
	}

	@Then("The hotels result page title should contains {string}")
	public void the_hotels_result_page_title_should_contains(String title) {
		logger.info("Getting the Hotels Result page title");
		logger.info("Verifying the title");
		try {
			BrowserUtilities.waitFor(10);
			System.out.println(Driver.getDriver().getTitle());
			assertTrue(Driver.getDriver().getTitle().contains(title));;
			logger.info("Title Verification passed");

		} catch (AssertionError e) {

			logger.error("Title Verification failed");
			logger.error(e.toString());
			throw e; // re-throw my error so that my test fails
		}
	}
	
	@Then("Destination field in result page should contain {string}")
	public void destination_field_in_result_page_should_contain(String destination) {
		HotelResultPageNew hotelsResultpage = new HotelResultPageNew();
		logger.info("Verifying the field should contains " + destination);
		try {
			assertTrue(hotelsResultpage.goingToField.getText().contains(destination));
			logger.info("Verification passed");

		} catch (AssertionError e) {

			logger.error("Verification failed");
			logger.error(e.toString());
			throw e; // re-throw my error so that my test fails
		}
	}
	
	@Then("Check in field should contain {string} {int}")
	public void check_in_field_should_contain(String string, Integer int1) {
		HotelResultPageNew hotelsResultpage = new HotelResultPageNew();
		String expected = string+int1;
	    String actual = hotelsResultpage.checkInField.getText();
	    logger.info("Verifying the Check in field should contains " + string+int1);
		try {
			assertTrue(actual.contains(expected));
			logger.info("Verification passed");

		} catch (AssertionError e) {

			logger.error("Verification failed");
			logger.error(e.toString());
			throw e; // re-throw my error so that my test fails
		}
	    
	}
	
	@Then("Check out field should contain {string} {int}")
	public void check_out_field_should_contain(String string, Integer int1) {
		HotelResultPageNew hotelsResultpage = new HotelResultPageNew();
		String expected = string+int1;
		String actual = hotelsResultpage.checkOutField.getText();
		logger.info("Verifying the Check out field should contains " + string+int1);
		try {
			assertTrue(actual.contains(expected));
			logger.info("Verification passed");

		} catch (AssertionError e) {

			logger.error("Verification failed");
			logger.error(e.toString());
			throw e; // re-throw my error so that my test fails
		}
	}
	
	@Then("Verify total rooms and guests")
	public void verify_total_rooms_and_guests() {
		HotelResultPageNew hotelsResultpage = new HotelResultPageNew();
		String expected = "1 room, 4 guests";
		String actual = hotelsResultpage.guestField.getText();
		logger.info("Verifying the Check out field should contains 1 room, 4 guests (3 adults and 1 child)");
		try {
			assertTrue(actual.contains(expected));
			logger.info("Verification passed");

		} catch (AssertionError e) {

			logger.error("Verification failed");
			logger.error(e.toString());
			throw e; // re-throw my error so that my test fails
		}
	}
	
	@And("Add Flying From destination")
	public void add_Flying_From_destination() {
		HotelsPageNew hotelspage = new HotelsPageNew();
		logger.info("Check Add a flight checkbox");
		hotelspage.addFlight.click();
		logger.info("Enter flying from destination by choosing from given choises");
		hotelspage.flyingFromField.sendKeys("jf");
		BrowserUtilities.selectFromListByDataValue(hotelspage.airportList, "New York, NY (JFK-John F. Kennedy Intl.)");
		
	}
	
	@Then("The origin field should contains New York")
	public void the_origin_field_should_contains_New_York() {
		HotelResultPageNew hotelsResultpage = new HotelResultPageNew();
		logger.info("Verifying the origin field should contains New York");
		try {
			assertTrue(hotelsResultpage.originField.getAttribute("value").contains("New York"));
			logger.info("Verification passed");

		} catch (AssertionError e) {

			logger.error("Verification failed");
			logger.error(e.toString());
			throw e; // re-throw my error so that my test fails
		}
	}
	
	@Then("The destination field should contains Florida")
	public void the_destination_field_should_contains_Florida() {
		HotelResultPageNew hotelsResultpage = new HotelResultPageNew();
		logger.info("Verifying the destination field should contains Florida");
		try {
			assertTrue(hotelsResultpage.destitation.getAttribute("value").contains("Florida"));
			logger.info("Verification passed");

		} catch (AssertionError e) {

			logger.error("Verification failed");
			logger.error(e.toString());
			throw e; // re-throw my error so that my test fails
		}
	}

	@Then("The departing field should present correct date")
	public void the_departing_field_should_present_correct_date() {
		HotelResultPageNew hotelsResultpage = new HotelResultPageNew();
		logger.info("Verifying the departing field has 6/16/2020");
		try {
			assertTrue(hotelsResultpage.startDate.getAttribute("value").contains("6/16/2020"));
			logger.info("Verification passed");

		} catch (AssertionError e) {

			logger.error("Verification failed");
			logger.error(e.toString());
			throw e; // re-throw my error so that my test fails
		}
	}

	@Then("The returning field should present correct date")
	public void the_returning_field_should_present_correct_date() {
		HotelResultPageNew hotelsResultpage = new HotelResultPageNew();
		logger.info("Verifying the returning field has 6/26/2020");
		try {
			assertTrue(hotelsResultpage.endDate.getAttribute("value").contains("6/26/2020"));
			logger.info("Verification passed");

		} catch (AssertionError e) {

			logger.error("Verification failed");
			logger.error(e.toString());
			throw e; // re-throw my error so that my test fails
		}
	}

	@Then("The quantity rooms, adults and children should be correct")
	public void the_quantity_rooms_adults_and_children_should_be_correct() {
		HotelResultPageNew hotelsResultpage = new HotelResultPageNew();
		logger.info("Verifying the info about 1 room, 3 adults and 1 child are present");
		try {
			logger.info("Verification the room quantity is 1");
			assertTrue(hotelsResultpage.roomsInfo.getText().contains("1"));
			logger.info("Verification passed");


		} catch (AssertionError e) {

			logger.error("Verification failed");
			logger.error(e.toString());
			throw e; // re-throw my error so that my test fails
		}
		
		hotelsResultpage.changeSearchLink.click();
		BrowserUtilities.waitFor(3);
		logger.info("Verification the adult quantity is 3");
		assertTrue(hotelsResultpage.adultInfo.getText().contains("3 adults,"));
		logger.info("Verification passed");
		logger.info("Verification the child quantity is 1");
		assertTrue(hotelsResultpage.childInfo.getText().contains("1 child,"));
		logger.info("Verification passed");
		
	}
	
	
	
	
	
	
	
	
	
	
//	@And("Set guest field")
//	public void set_guest_field() {
//		HotelsPage hotelspage = new HotelsPage();
//		logger.info("Clicking minus button to decrease the adult in first room");
//		hotelspage.room1AdultminusButton.click();
//		logger.info("Clicking plus button to increase the child in first room");
//		hotelspage.room1ChildplusButton.click();
//		logger.info("Selecting age of child in first room");
//		BrowserUtilities.selectByValue(hotelspage.room1ChildSelect, "4");
//		logger.info("Clicking Done button");
//		hotelspage.guestDoneButton.click();
//	}

//	@And("Click on guest field")
//	public void click_on_guest_field() {
//		HotelsPage hotelspage = new HotelsPage();
//		logger.info("Clicking on guest field");
//		hotelspage.guestField.click();
//		
//	}

//	@And("Decrease the adult in first room")
//	public void decrease_the_adult_in_first_room() {
//		HotelsPage hotelspage = new HotelsPage();
//		logger.info("Clicking minus button to decrease the adult in first room");
//		hotelspage.room1AdultminusButton.click();
//		
//	}
//
//	@And("Increase the child in first room")
//	public void increase_the_child_in_first_room() {
//		HotelsPage hotelspage = new HotelsPage();
//		logger.info("Clicking plus button to increase the child in first room");
//		hotelspage.room1ChildplusButton.click();
//		
//	}
//
//	@And("Select age of child in first room")
//	public void select_age_of_child_in_first_room() {
//		HotelsPage hotelspage = new HotelsPage();
//		logger.info("Selecting age of child in first room");
//		BrowserUtilities.selectByValue(hotelspage.room1ChildSelect, "4");
//		
//	}
//
//	@Then("Click to add another room")
//	public void click_to_add_another_room() {
//		HotelsPage hotelspage = new HotelsPage();
//		logger.info("Clicking to add another room");
//		JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
//		js.executeScript("arguments[0].click()", hotelspage.addRoomButton);
//		
//	}
//
//	@And("Increase the adult in second room")
//	public void increase_the_adult_in_second_room() {
//		HotelsPage hotelspage = new HotelsPage();
//		logger.info("Clicking plus button to increase the adult in second room");
//		hotelspage.room2AdultplusButton.click();
//		
//		logger.info("Scroll down");
//		JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
//		js.executeScript("arguments[0].scrollIntoView();", hotelspage.addRoomButton);
//		
//	}
//
//	@And("Click to remove third room")
//	public void click_to_remove_third_room() {
//		HotelsPage hotelspage = new HotelsPage();
//		logger.info("Clicking to to remove third room");
//		hotelspage.remove3rdRoomButton.click();
//		
//	}
//
//	@And("Click Done button")
//	public void click_Done_button() {
//		HotelsPage hotelspage = new HotelsPage();
//		logger.info("Clicking Done button");
//		JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
//		js.executeScript("arguments[0].click()", hotelspage.guestDoneButton);
//				
//	}
//
	
	
//	@Given("Click on hotels")
//	public void click_on_hotels() {
//		HotelsPage hotelspage = new HotelsPage();
//		logger.info("Clicking on Hotels");
//		hotelspage.hotelsMenu.click();
//		
//				
//	}
//
//	@Then("The hotels page title should be Cheap Hotels: Book Hotel Deals With Our Hotel Finder | Travelocity")
//	public void the_hotels_page_title_should_be_Cheap_Hotels_Book_Hotel_Deals_With_Our_Hotel_Finder_Travelocity() {
//		logger.info("Getting the Hotels page title");
//		String actual = Driver.getDriver().getTitle();
//		String expected = "Cheap Hotels: Book Hotel Deals With Our Hotel Finder | Travelocity";
//		logger.info("Verifying the title");
//
//		try {
//			assertEquals(expected, actual);
//			logger.info("Title Verification passed");
//
//		} catch (AssertionError e) {
//
//			logger.error("Title Verification failed");
//			logger.error(e.toString());
//			throw e; // re-throw my error so that my test fails
//		}
//	}
	
//	@Then("Destination field should contain {string}")
//	public void destination_field_should_contain(String destination) {
//		HotelsPage hotelspage = new HotelsPage();
//		logger.info("Verifying the field should contains " + destination);
//		try {
//			System.out.println(hotelspage.goingToField.getText());
//			assertTrue(hotelspage.goingToField.getText().contains(destination));
//			logger.info("Verification passed");
//
//		} catch (AssertionError e) {
//
//			logger.error("Verification failed");
//			logger.error(e.toString());
//			throw e; // re-throw my error so that my test fails
//		}
//	}	
	
	
	
	
	
}
	
	
	


