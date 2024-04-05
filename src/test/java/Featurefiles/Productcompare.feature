Feature: Product compare

  #@testcaseid(1)
  #Scenario: Verify the product details is displayed in the comparison product details page
    #And user enter the product name "MacBook Pro" in the search
    #And Click on the search button
    #Then user should see the product "MacBook Pro" in the result
    #When user select the product "MacBook Pro" to open
    #And Hover on the product compare and check product tooltip msg should display
    #And click on the product compare option
    #Then validate the confirmation message is displayed
    #And click on the comparision link

  Scenario: Verify the product compare page with no devices selected
    When user Hover on the Desktop option
    And select the All desktop option
    Then verify user navigated to the desktop page
    And click on the product compare link
    Then verify user redirecting to the Product comparision page
    And click on the continue button
    Then verify user redirected to the Homepage
