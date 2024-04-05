Feature: Add products to the wishlist

  #Scenario: Add products from the related product section
    #Given user navigate to the login page
    #When user entered valid username and password (username="raghurama@gmail.com", password="Testing1"
    #And click on the login button
    #Then user should see the Myaccountpage
    #And user enter the product name "iPhone" in the search
    #And Click on the search button
    #Then user should see the product "iPhone" in the result
    #When user select the product "iPhone" to open
    #And Verify the product "Apple Cinema 30" is displayed in the Related Products section
    #And Click on Add to wishlist icon of the product
    #Then validate wishlist link is displayed in the success message
    #And click on the wishlist link in the success msg

  Scenario Outline: Add products from the related product section
    Given user navigate to the login page
    When user entered valid username and password (username="raghurama@gmail.com", password="Testing1"
    And click on the login button
    Then user should see the Myaccountpage
    And user enter the product name "<Product>" in the search
    And Click on the search button
    Then user should see the product "<Product>" in the result
    When user select the product "<Product>" to open
    And Verify the product "Apple Cinema 30" is displayed in the Related Products section
    And Click on Add to wishlist icon of the product
    Then validate wishlist link is displayed in the success message
    And click on the wishlist link in the success msg

    Examples: 
      | Product     |
      | iPhone      |
      | MacBook Pro |
      | MacBook Air |
