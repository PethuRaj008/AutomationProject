
@tag
Feature: Chat bot intraction with user
  User able to provide details requested by Chat bot

	Background:
	Given Browser is launched and website is opened

  @tag1
  Scenario Outline: User is able to provide all the details
    Given Chat bot is available
    When All the text in chat bot frame is displayed
    And I enter user data like <email>, <firstname> and <location> 
    Then verify the reply <text>


    Examples: 
      | email  							| firstname | location  | text																																	|
      | pethu.s@zommin.com  | Pethu     | India     | Thank you for sharing the details! We will get back to you shortly.	  |
    
