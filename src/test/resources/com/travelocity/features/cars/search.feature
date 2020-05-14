
Feature: Cars search functionality

  Background: 
  
    Given I am on the TravelocityCom homepage
    When Click on cars

  Scenario: Verify cars page title
  Then The cars page title should be Wander Wisely with Cheap Hotels, Flights, Vacations & Travel Deals | Travelocity


  Scenario: Verify picking up field functionality 
  And Click on Picking up
	And Enter "Los" as a pick up location
	Then Picking up field should contain "Los Angeles"
	

  Scenario: Verify check in  field functionality 
  And Click on Drop off
	And Enter "San" as a drop off location
	Then Dropping off field should contain "San Francisco"
	
	 Scenario:
    When User click on "Istanbul" as pick up location
    When  User click on "Izmir" as drop off location 
    And User pick "05/20/2020" as pick up date
    And User click "11:00AM" as pick up time
    And User pick "05/26/2020" as drop off date
    And User pick "01:00PM" as drop off time
    Then User click on Search button
    Then User verify page title
    
	
	
	

