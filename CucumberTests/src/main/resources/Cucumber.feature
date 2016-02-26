
Feature: Open home page in Fb

  Scenario: Open home page in Fb
    Given Open "https://www.facebook.com/" page
    When Login into the account
    Then Click find freands button
    Then Logut from the account
    

