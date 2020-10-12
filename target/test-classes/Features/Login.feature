Feature: Login into Application

Scenario Outline: Positiv Test Validation Login
Given Initiliaze browser with chrome
And Navigate to "http://www.qaclickacademy.com/" site
And Click on Login botton
When User enters <username> and <password> and logs in
Then Verify that user is successfully logged in

Examples:
|username						|password			|
|username@toto.com	|123456				|
|toto@toto.io				|654321				|
