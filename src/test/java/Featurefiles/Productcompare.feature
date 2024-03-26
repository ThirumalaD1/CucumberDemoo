Feature: Product compare

Scenario: Verify the product details is displayed in the product details page
  And user enter the product name "MacBook Pro" in the search
  And Click on the search button
  Then user should see the product "MacBook Pro" in the result
  When user select the product "MacBook Pro" to open
  And Hover on the product compare and check product tooltip msg should display
  And click on the product compare option
  Then validate the confirmation message is displayed
  And click on the comparision link
