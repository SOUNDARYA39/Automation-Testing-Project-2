
Feature: Login feature
  
  Scenario: Login to the Vtiger Apllication with valid credentials
    Given I want to launch the browser
    And I want to load the application
    When The login page is displayed enter valid username and password
    And Click on login button
    Then Verify for home page displayed or not
  


