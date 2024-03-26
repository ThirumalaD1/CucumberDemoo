Feature: Add to cartpage

Scenario: Add the product to cart page
Given user navigate to the login page
    When user entered valid username and password (username="raghurama@gmail.com", password="Testing1"
    And click on the login button
    Then user should see the Myaccountpage
    And user enter the product name "MacBook Pro" in the search
    And Click on the search button
    Then user should see the product "MacBook Pro" in the result
    When user select the product "MacBook Pro" to open
    When user set the quantity 
    And add the product to the cart
    Then validate the confirmation message is displayed
    