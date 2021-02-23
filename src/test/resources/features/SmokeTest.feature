
Feature: Smoke Test

  Background:
    Given the user is on the login page

  Scenario: Verify that librarian can login with valid credentials

    When the user login as a librarian
    Then the user should be able to login

  Scenario:  Verify that student can login with valid credentials

    When the user login as a student
    Then the user should be able to login


  Scenario:  Verify that student can borrow and return books

    Given the user login as a student
    When the user enters valid book name into search box
    Then the user should see the searched book name
    And the user clicks borrow book button
    Then the user should see the borrowed message
    And the user clicks borrowing books button
    Then the user should click return book button
    And the user should see the returned message


  Scenario:  Verify that book cannot be borrowed twice

    Given the user login as a student
    When the user enters valid book name into search box
    And the user clicks borrow book button
    Then the user should see the borrowed message
    When the user enters valid book name into search box
    And the user clicks borrow book button
    Then the user should not see the borrowed message
    And the user clicks borrowing books button
    Then the user should click return book button
    And the user should see the returned message

  Scenario:  Verify that find book using search box

    Given the user login as a student
    When the user enters valid book name into search box
    Then the user should see the searched book name


  Scenario:  Verify that librarian can add user

    Given the user login as a librarian
    When the user clicks the users button
    Then the user clicks the add user button
    And the user enters user information with valid credentials
    Then the user should be able to save the user


  Scenario:  Verify that librarian can edit user

    Given the user login as a librarian
    When the user clicks the users button
    Then the user clicks the edit user button
    And the user enters user information with valid credentials
    Then the user should be able to updated

  Scenario: Verify that librarian can add books

    Given the user login as a librarian
    Then the user clicks the books button
    When the user clicks the add book button
    And the user enters book information with valid credentials
    Then the user should be able to add the book


  Scenario: Verify that librarian can edit books

    Given the user login as a librarian
    Then the user clicks the books button
    When the user clicks the edit book button
    And the user enters book information with valid credentials
    Then the user should be able to update the book

  Scenario: Verify that librarian can log out

    When the user login as a librarian
    Then the user should be log out

  Scenario:  Verify that student can log out

    When the user login as a student
    Then the user should be log out
