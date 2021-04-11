Feature: Feature to test compose functionality

Scenario: validate compose functionality

Given User is on gmail login page
And user enters username and clicks on next button
And user enters password and clicks on next button
And user able to see gmail homepage
When User clicks on compose button
Then User able to New message pop-up
And enter all relevent data in the fields
And clicks on send button