@wip
Feature: Only Authorized Users should be able to login

  Background:
    Given the user is on the login page

  Scenario: Login as a librarian

    When the user enters the librarian information
    Then the user should be able to login

  Scenario:  Login as a student

    When the user enters the student information
    Then the user should be able to login


  Scenario Outline: UnAuthorized users should not be able to login to the application
    When the user enters the invalid user "<email>""<password>"
    And the user enters the invalid passwords "<email>""<password>"
    Then the UnAuthorized user should not be able to login
    Examples:
      | email                | password |
      | librarian181@library | WwRsaD3  |
      | librarian181@librar  | WwRsaD3J |