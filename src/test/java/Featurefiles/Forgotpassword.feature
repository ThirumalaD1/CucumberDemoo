Feature: Reset password 
Scenario: Validate User is able to reset the password
Given user navigate to the login page
And click Forgotten Password link from Login page
Then verify user navigated to the Forgot password page
And enter the email address of an existing account for which you have forgot the password 
And Click on Continue button
And Check the registered email address for which the password got reset
And Click on the link for resseting the password from the received email body
And Enter new password as "Testing2" into the password and Confirm fields
And Click on Continue button
And Enter the email address into the E-Mail address field and the new resetted password into the Password field 
And Click on Login button
Then user should see the Myaccountpage