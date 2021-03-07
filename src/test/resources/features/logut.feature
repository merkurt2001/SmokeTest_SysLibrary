Feature: User should be able to log out

  @SYS-318
  Scenario: Logout as a librarian

    Given the user is on the login page
    When the user enters the librarian information
    And the user using the logout button
    Then the user should be able to logout

  @SYS-318
  Scenario:  Logout as a student

    Given the user is on the login page
    When the user enters the student information
    And the user using the logout button
    Then the user should be able to logout