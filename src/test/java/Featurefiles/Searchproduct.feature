Feature: Search product

  #Scenario: Search Mac product
  #Given user navigate to the login page
  #When user entered valid username and password (username="raghurama@gmail.com", password="Testing1"
  #And click on the login button
  #Then user should see the Myaccountpage
  #And user enter the product name in the search
  #And Click on the search button
  #Then user should see the product in the result
  @testcaseid(2)
  Scenario: Verify the product details is displayed in the product details page
  And user enter the product name "iPhone" in the search
  And Click on the search button
  Then user should see the product "iPhone" in the result
  When user select the product "iPhone" to open
  Then user should see the below details of the product in the product details page
  | Productname  | iPhone                   |
  | Productbrand | Apple                    |
  | Productcode  | Product Code: product 11 |
  
  @testcaseid(3)
  Scenario: Verify search product through search criteria field
  And Click on the search button
  When user enter the below given product name in search criteria and click on search button
  | Productname | mac |
  Then user should see the product "MacBook Pro" in the result
  
  @testcaseid(4)
  Scenario: Verify placeholder text in the product search field and in the search criteria field
    Then check the product search field placeholder is displayed on the app when no text is entered
    And Click on the search button
    Then check the search criteria field placeholder text is displayed on the app when no text is entered
