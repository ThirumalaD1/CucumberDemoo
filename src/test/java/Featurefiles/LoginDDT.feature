Feature: Login with DDT

  Scenario Outline: Sucessfull and unsucessful login
    Given user navigate to the login page
    Then user redirecting to the Myaccount by passing email and password with excel row"<row_index>"

    Examples: 
      | row_index |
      |         1 |
      |         2 |
      |         3 |
      |         4 |
      |         5 |
