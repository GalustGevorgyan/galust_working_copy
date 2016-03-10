@search
Feature: search name

  Scenario Outline: search name
    Given Open "http://www.starwars.com/" web page
    Then Search "<text>" from a web page with "nav-search-input" id name
    Then Get har and check CTO events with "http://www.starwars.com/" page

    Examples: 
      | text             |
      | Star wars heroes |
      | movie            |
      | gvidon           |
      | gurgen           |
