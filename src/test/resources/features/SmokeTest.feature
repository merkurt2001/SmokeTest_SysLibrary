@SYS-405
Feature: 

	Background:
		#@SYS-392
		Given the user is on the login page
		

	
	@SYS-393 @SYS-391
	Scenario: Verify that librarian can login with valid credentials
		When the user enters the librarian information
		    Then the user should be able to login	

	
	@SYS-394 @SYS-391
	Scenario: Verify that student can login with valid credentials
		 When the user enters the student information
		    Then the user should be able to login	

	
	@SYS-395 @SYS-391
	Scenario: Student can borrow books in books page
		 When the user enters the student information
		    When the user enters valid book name into search box
		    And the user clicks borrow book button
		    Then the user should see the borrowed message	

	
	@SYS-396 @SYS-391
	Scenario: Book cannot be borrowed twice at the same time
		When the user enters the student information
		    When the user enters valid book name into search box
		    And the user clicks borrow book button
		    And the user clicks borrowing books button
		    Then the user should see only one not return message	

	
	@SYS-397 @SYS-391
	Scenario: Student can return books when navigate to borrowing books page
		 When the user enters the student information
		    And the user clicks borrowing books button
		    Then the user should click return book button
		    And the user should see the returned message	

	
	@SYS-398 @SYS-391
	Scenario: Student can find book by using search box with book's Name and Author
		When the user enters the student information
		    And the user enters valid author name into search box
		    Then the user should see the searched author name
		    When the user enters valid book name into search box
		    Then the user should see the searched book name	

	
	@SYS-399 @SYS-391
	Scenario: Librarian can add user with valid inputs
		 When the user enters the librarian information
		    And Librarian is on the add user page
		    When Librarian will enter valid information for a new user
		    And Librarian will click on Save Changes button
		    Then "The user has been created." message should be displayed	

	
	@SYS-400 @SYS-391
	Scenario: Verify that librarian can edit books
		When the user enters the librarian information
		    When the user enters the edit books button
		    And the user enters book information with valid credentials
		    Then the user should be able to save the changes	

	
	@SYS-401 @SYS-391
	Scenario: Verify that librarian can add books
		Given the user is on the librarian books page
		    When the librarian click the add book button
		    And the user enters book information with valid credentials
		    Then the user should be able to add the book	



	
	@SYS-403 @SYS-391
	Scenario: Verify that librarian can log out
		 When the user enters the librarian information
		    And the user using the logout button
		    Then the user should be able to logout	

	
	@SYS-404 @SYS-391
	Scenario: Verify that student can log out
		 When the user enters the student information
		    And the user using the logout button
		    Then the user should be able to logout