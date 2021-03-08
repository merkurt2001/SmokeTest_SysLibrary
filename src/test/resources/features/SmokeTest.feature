@smoke
Feature:

  Background:

    Given the user is on the login page


  Scenario: Verify that librarian can login with valid credentials
    When the user enters the librarian information
    Then the user should be able to login


  Scenario: Verify that student can login with valid credentials
    When the user enters the student information
    Then the user should be able to login


  Scenario: Student can borrow books in books page
    When the user enters the student information
    When the user enters valid book name into search box
    And the user clicks borrow book button
    Then the user should see the borrowed message


  Scenario: Book cannot be borrowed twice at the same time
    When the user enters the student information
    When the user enters valid book name into search box
    And the user clicks borrow book button
    And the user clicks borrowing books button
    Then the user should see only one not return message


  Scenario: Student can return books when navigate to borrowing books page
    When the user enters the student information
    And the user clicks borrowing books button
    Then the user should click return book button
    And the user should see the returned message


  Scenario: Student can find book by using search box with book's Name and Author
    When the user enters the student information
    And the user enters valid author name into search box
    Then the user should see the searched author name
    When the user enters valid book name into search box
    Then the user should see the searched book name


  Scenario: Librarian can add user with valid inputs
    When the user enters the librarian information
    And Librarian is on the add user page
    When Librarian will enter valid information for a new user
    And Librarian will click on Save Changes button
    Then "The user has been created." message should be displayed


  Scenario: Verify that librarian can edit books
    When the user enters the librarian information
    When the user enters the edit books button
    And the user enters book information with valid credentials
    Then the user should be able to save the changes



  Scenario: Verify that librarian can add books
    Given the user is on the librarian books page
    When the librarian click the add book button
    And the user enters book information with valid credentials
    Then the user should be able to add the book


  Scenario: Verify that librarian can edit books
    Given the user is on the librarian books page
    When the user enters the edit books button
    And the user enters book information with valid credentials
    Then the user should be able to save the changes


  Scenario: Verify that librarian can log out
    When the user enters the librarian information
    And the user using the logout button
    Then the user should be able to logout


  Scenario: Verify that student can log out
    When the user enters the student information
    And the user using the logout button
    Then the user should be able to logout
