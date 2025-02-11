#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Login fuctionality of demo web shop 
  
  Scenario Outline: user can login2
    Given open demo webshop2
    When 2enter username "<username>" and password "<password>"
    And click on login2
    Then should see account page2

    Examples: 
      | username  | password| 
      | validuser2@example.come | 12345 |
      | anotheruser@example.com | pass123 |
