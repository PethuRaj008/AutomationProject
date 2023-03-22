
@tag
Feature: Chat bot intraction with user
  User able to provide details requested by Chat bot

	Background:
	Given Browser is launched and website is opened

  @tag1
  Scenario Outline: User is able to provide all the details
    Given Chat bot is available with text <chat>
    When All the text in chat bot frame is displayed
    And I entered user data like <email>, <firstname>
    Then select location and verify the reply <text>
    And quit the browser


    Examples: 
      | email  							| firstname |chat											     | text																																	|
      | pethu.s@zoomin.com  | Pethu     |Welcome to ZoomInfo Chat!     | Thank you for sharing the details! We will get back to you shortly.	  |
    

    @tag2
  Scenario Outline: Explore chat bot with all possible flow
    Given Chat bot is available with text <chat>
    When All the text in chat bot frame is displayed
    And error message <error> is displayed for email <firstname1>
    And I entered user data like <email1>, <firstname1>
    Then select location and verify the reply <text>
    And restart conversation
    And minimize the chat bot
    And maximize the chat bot
    And open new tab and switch back to chat bot
    And verify content in home screen
    And open files window
    And open the first conversation from the history
    And quit the browser

    Examples: 
      | email1  							   |error																|firstname1 |chat											    | text																																	|
      | pethu.r@tick.com         |Please enter a valid email address. |Raj        |Welcome to ZoomInfo Chat!    | Thank you for sharing the details! We will get back to you shortly.	  |
    
    
    
    