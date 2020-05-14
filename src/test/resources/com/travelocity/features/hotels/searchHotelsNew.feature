@SecondSprint
Feature: Hotel search functionality

  Background: 
    Given I am on the TravelocityCom homepage


	
  Scenario: Verify destenation field functionality 
  And Click on Going to field
	And Enter "Florida" destination
	And Click on Check in field
	And Set "2020" "5" "16" date to Check in field
	And Click on Check out field
	And Set "2020" "5" "26" date to Check out field
	And Select quantity of the rooms
	And Select quantity of the adults
	And Select quantity of the children
	And Select children age
	Then Click Search button
	Then The hotels result page title should contains "Florida"
	Then Destination field in result page should contain "Florida"
	Then Check in field should contain "Jun " 16
	Then Check out field should contain "Jun " 26
	Then Verify total rooms and guests 
	
	Scenario: Verify search functionality with add flight
	And Click on Going to field
	And Enter "Florida" destination
	And Click on Check in field
	And Set "2020" "5" "16" date to Check in field
	And Click on Check out field
	And Set "2020" "5" "26" date to Check out field
	And Select quantity of the rooms
	And Select quantity of the adults
	And Select quantity of the children
	And Select children age
	And Add Flying From destination
	Then Click Search button
	Then The hotels result page title should contains "Florida"
	Then The origin field should contains New York
	Then The destination field should contains Florida
	Then The departing field should present correct date
	Then The returning field should present correct date
	Then The quantity rooms, adults and children should be correct  
	
	