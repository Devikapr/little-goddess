Feature: Application Login

Scenario Outline: Positive test validating login

Given Initialize the browser with chrome
And Navigate to "http://www.qaclickacademy.com/" website
And click on LogIn link to land on Login page
When user enters <username> and <password> and logs in
Then verify that user is successfully logged in
And close browsers
Examples:
|username				|password|
|devika@gmail.com		|devu1234|
|appu@gmail.com			|appu1234|
