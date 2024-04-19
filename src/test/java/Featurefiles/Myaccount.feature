Feature: Myaccount

  Scenario: Verify the Address book entries page
    Given user navigate to the login page
    When user entered valid username and password (username="raghurama@gmail.com", password="Testing1"
    And click on the login button
    Then user should see the Myaccountpage
    And click on My account dropdown option
    And click on the Myaccount option
    And click on the Modify your address book entries link
    Then verify user taken to the Addressbook entries page
