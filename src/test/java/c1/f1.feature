@login
Feature: validate the login functionality

@validlogin @smoke @regression @uat
Scenario: login with valid inputdata
Given user is on login page
When user enters valid username and valid password and click login
Then user should login successfully

Scenario Outline: login with invalid inputdata
Given user is on login page
When user enters Username and password which are invalid and click login
Then should display an error message on the page
Examples:
|username|password|
|bimal@gmail.com|dklfsf|
|singh@gmail.com|jjgtuy|
