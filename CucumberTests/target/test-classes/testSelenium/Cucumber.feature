#Feature: all_butons_web_page
#
#  Scenario Outline: Click all butons web page
#    Given Open "http://www.starwars.com/" page
#    Then Click "<button_name>" in web page
#    Then Close the web page
#
#    Examples: 
#      | button_name  |
#      | NEWS + BLOG  |
#      | VIDEO        |
#      | EVENTS       |
#      | FILMS        |
#      | TV SHOWS     |
#      | GAMES + APPS |
#      | COMMUNITY    |
#      | DATABANK     |
#      | TICKETS      |
