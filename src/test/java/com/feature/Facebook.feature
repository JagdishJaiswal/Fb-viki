Feature: SOCIAL WEBSITE

Scenario: Login page
Given user Launch The Url
When get The Text From HomePage
And user Enter The Username
And enter The Password
And click The Login button
Then validate With Screenshot and Back To Home Page

Scenario: SignUp Page
When user Click The Create Account Button
And enter The Firstname and Lastname
And enter The Mobile Number and Type Password
And select The Date Of Birth and Gender
Then click Submit and TakeScreenShot

