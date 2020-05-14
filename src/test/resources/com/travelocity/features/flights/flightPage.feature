Feature: Verify Flights main page

  Background: 
    Given I am on the flights page
	
  Scenario: Verify flights page
    When I click on Hotels button
    And I click on Flights button
    Then I should land on flights page

  Scenario: Verify dropdown suggestions by keyword
    When I type a keyword into Flying from field
    Then I should see suggested options in the dropdown

  Scenario: Verify Clear button
    When I type a keyword into Flying from field
    And I click on Clear button
    Then Flying from field should get cleared

  Scenario: Verify error messages
    When I click on Search button
    Then Error messages should be displayed
    
 @SecondSprint   
  Scenario: Verify number of children
 		When I select 2 children
 		Then 2 options to enter children age shoud be displayed
 		
 @SecondSprint		
  Scenario: Verify Roundtrip trip type
 	  When I select "Roundtrip" as a trip type
 	  And I enter random flight details
 	  And I click on Search button
 	  Then Flight tickets of corresponding trip type should be displayed

  @SecondSprint
 	Scenario: Verify One way trip type
 	  When I select "One way" as a trip type
 	  And I enter random flight details
 	  And I click on Search button
 	  Then Flight tickets of corresponding trip type should be displayed
 	  
 	@SecondSprint 
 	Scenario: Verify multy-city trip type
 	  When I select "Multy-city" as a trip type
 	  And I enter random flight details
 	  And I click on Search button
 	  Then Flight tickets of corresponding trip type should be displayed
 	  
  @test
 	Scenario: Verify the flight ticket with excel
 		When I select "One way" as a trip type
    And I enter the flight details
    And I click on Search button
    Then The details of the cheapest flight ticket should be correct
 	  
	@SecondSprint
 	Scenario Outline: Verify airports in the flight ticket
   	When I select "One way" as a trip type
 	  When I enter "<departing city>" as a departing city
 	  And I enter "<arrival city>" as an arrival city
 	  And I enter "<departing date>" as a departing date
 	  And I click on Search button 
 	  Then Flight tickets should contain "<DA1>", "<DA2>", "<DA3>" as departure airports  
 	  		   	
 	 		Examples:
   		|departing city |arrival city |departing date |DA1 |DA2 |DA3 |
   		|Moscow 				|Istanbul		  |09/09/2020			|VKO |SVO |DME |
 	  	|New York				|Shanghai			|09/09/2020			|JFK |EWR |LGA |
 	  
 	  
    
  	
 		
    
 
