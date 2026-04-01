
@smoke @login
Feature: User login
  As a user, I want to login so that I can access my account

  Background:
    Given I am on the Login page

  Scenario: Successful login with valid credentials
    When I login with username "tomsmith" and password "SuperSecretPassword!"
    Then I should see the dashboard

  Scenario: Login fails with invalid password
    When I login with username "tomsmith" and password "Wrong!"
    Then I should see an error message containing "invalid"
