
Feature: MediaRel
  I want to use this template for my feature file
   

 Scenario Outline: Media Release Apply & Clear Filters 
    Given user launch Chrome browser
    When user opens URL "https://www.nsw.gov.au/media-releases"
    When user selects Minister "<FilterSelection>"
    And user click ApplyAllFilters
    Then it should display correct results for "<FilterSelected>"
    When user click on ClearFilters
    Then it should display correct details
    And close Browser 
   
    
  
  Examples:
  |FilterSelection||FilterSelected|
  |The Premier||Premier|
  |Treasurer||Treasurer|
  |Deputy Premier||Deputy|
  |Minister for Aboriginal Affairs and Treaty||Aboriginal|
  |Minister for Agriculture||Agriculture|
