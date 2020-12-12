Feature: verify that an email sent from one Gmail account can be received by another Gmail account

  @E2E
  Scenario: Verify email sent from one gmail account received by other gmail account.
    Given I am on Gmail login page
    And I login with registered gmail account
      | senderEmailID             | senderPassword |
      | BottomlineTest1@gmail.com | London@1       |
    When I click on compose
    And I enter email details
      | toEmailID                 | emailSubject | messageBody               |
      | Bottomlinetest2@gmail.com | Test email   | Test Message : HelloWorld |
    And I press on send
    And wait for the email to be sent successfully and logout
    When I Login to another gmail account
      | receiverEmailID           | receivedPassoword |
      | BottomLineTest2@gmail.com | London@1          |
    Then verify new email from "BottomlineTest1@gmail.com" appears in Inbox.
