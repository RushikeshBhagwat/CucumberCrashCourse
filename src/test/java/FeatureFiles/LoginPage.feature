Feature: Login functionality for opencart E-commerce application

As a user of the opencart website 
I want to be able to login with my account 
So that I can access my account related features and manage my orders

Background: 
 Given I am on the opencart login page
 
Scenario: Successful login with valid credentials
 Given I have entered valid username and password
 When I click on the login button
 Then Login should be successful
 
Scenario Outline: Unsuccessful login with invalid or empty credentials
 Given I have entered a invalid "<username>" and "<password>"
 When I click on the login button 
 Then I should see error message indicating "<error_msg>"
 
 Examples:
 | username              | password                | error_msg                                             |
 | 12^gmail78.com        | invalidpassword         | Warning: No match for E-Mail Address and/or Password. |
 | ui23@gmail.com        | validass                | Warning: No match for E-Mail Address and/or Password. |
 
 Scenario: Navigating to forgotten password page 
  When I click on forgot password link
  Then I should be navigated to password reset page