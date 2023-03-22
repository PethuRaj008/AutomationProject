
@tag
Feature: Enter requested retails in chat box
  Give all the required data asked by testbot

	Background:
	Given I Landed on website
	And Welcome message in chat box is displayed

  @tag1
  Scenario Outline: Enter user details in chat box and get response
    Given Chat box is opened 
    When All the text in chat box is displayed
    And I enter user data like <email>, <firstname> and <location> 
    Then verify the reply <text>


    Examples: 
      | email  							| firstname | location  | text				|
      | pethu.s@zommin.com  | Pethu     | India     | Thank You!  |
    
