@tag
Feature: OrangeHRM Application Testing

  @tag1
  Scenario: Login to OrangeHRM
    Given Launch ChromeBrowser
    And Enter OrangeHRM URL 
    When Enter username,password and click on Login
    
