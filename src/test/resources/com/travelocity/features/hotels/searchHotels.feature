
Feature: Hotel search functionality

  Background: 
    Given I am on the TravelocityCom homepage
    When Click on hotels
	
  Scenario: Verify hotels page title
    Then The hotels page title should be Cheap Hotels: Book Hotel Deals With Our Hotel Finder | Travelocity


  Scenario: Verify destenation field functionality 
  And Click on Going to field
	And Enter "Florida" destination
	Then Destination field should contain "Florida"
	
	
  Scenario: Verify check in  field functionality 
  And Click on Check in field
	And Set "Jul" 7 2020 date to Check in field
	Then Check in field should contain "Jul " 7
	
	
  Scenario: Verify check out  field functionality 
  And Click on Check out field
	And Set "May" 11 2020 date to Check out field
	Then Check out field should contain "May " 11
	
	
  Scenario: Verify guest  field functionality 
  And Click on guest field
	And Decrease the adult in first room
	And Increase the child in first room
	And Select age of child in first room
	Then Click to add another room
	And Increase the adult in second room
	Then Click to add another room
	And Click to remove third room
	And Click Done button
	Then Verify total rooms and guests
	
	
	Scenario: Verify search functionality 
	And Click on Going to field
	And Enter "Florida" destination
	And Click on Check in field
	And Set "May" 10 2020 date to Check in field
	And Click on Check out field
	And Set "May" 11 2020 date to Check out field
	And Click on guest field
	And Decrease the adult in first room
	And Increase the child in first room
	And Select age of child in first room
	Then Click to add another room
	And Increase the adult in second room
	Then Click to add another room
	And Click to remove third room
	And Click Done button
	Then Click Search button
	Then The hotels page title should be Florida, United States of America Hotel Search Results
	