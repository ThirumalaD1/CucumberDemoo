Feature: Title of your feature

  @regression
  Scenario: Successful login
  Given user navigate to the login page
  When user entered valid username and password (username="raghurama@gmail.com", password="Testing1"
  And click on the login button
  Then user should see the Myaccountpage
  
  
  @regression
  Scenario Outline: UnSuccessful login
    Given user navigate to the login page
    When user entered valid username as "<email>" and password as "<passwd>" 
    And click on the login button
    Then user should see the Myaccountpage

    Examples: 
      | email               | passwd   |
      | raghurama@gmail.com | Testing1 |
      | raghuram@gmail.com  | Testing1 |
