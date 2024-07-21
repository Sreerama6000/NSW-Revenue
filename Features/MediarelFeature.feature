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
@tag
Feature: MediaRel
  I want to use this template for my feature file

  @tag1
  Scenario: Media Release Apply & Clear Filters
    Given user launch Chrome browser
    When user opens URL "https://www.nsw.gov.au/media-releases"
    When user selects Minister "Treasurer"
    And click ApplyAllFilters
    Then it should display correct results for "Treasurer"
    And click on ClearFilters
    Then it should display correct details
    And close browser

