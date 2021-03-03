
Feature:

	Background:
		#@SYS-326
		Given the user is on the login page
		When the user enters the student information
		Then the user should be able to login
		

	#1-Student can borrow books in books page.
	#2-Book cannot be borrowed twice at the same time.
	#3-Student should have a history of borrowed books when navigate to borrowing books page.
	#4-Student can return books when navigate to borrowing books page.
	#5-Student can select related category to see all books in that category by using book categories dropdown.
	#6-Student can use show records dropdown for getting number of entries depends the dropdown options.
	#7-Student can find book by using search box with book's Name and Author.
	@SYS-325 @SYS-324
	Scenario: Student can borrow books in books page
		When the user enters valid book name into search box
		And the user clicks borrow book button
		Then the user should see the borrowed message	

	#1-Student can borrow books in books page.
	#2-Book cannot be borrowed twice at the same time.
	#3-Student should have a history of borrowed books when navigate to borrowing books page.
	#4-Student can return books when navigate to borrowing books page.
	#5-Student can select related category to see all books in that category by using book categories dropdown.
	#6-Student can use show records dropdown for getting number of entries depends the dropdown options.
	#7-Student can find book by using search box with book's Name and Author.
	#
	@SYS-327 @SYS-324
	Scenario: Book cannot be borrowed twice at the same time
		When the user enters valid book name into search box
		And the user clicks borrow book button
		And the user clicks borrowing books button
		Then the user should see only one not return message	

	#1-Student can borrow books in books page.
	#2-Book cannot be borrowed twice at the same time.
	#3-Student should have a history of borrowed books when navigate to borrowing books page.
	#4-Student can return books when navigate to borrowing books page.
	#5-Student can select related category to see all books in that category by using book categories dropdown.
	#6-Student can use show records dropdown for getting number of entries depends the dropdown options.
	#7-Student can find book by using search box with book's Name and Author.
	#
	@SYS-328 @SYS-324
	Scenario: Student should have a history of borrowed books when navigate to borrowing books page
		And the user clicks borrowing books button
		Then the user should see the history of borrowed books	

	#1-Student can borrow books in books page.
	#2-Book cannot be borrowed twice at the same time.
	#3-Student should have a history of borrowed books when navigate to borrowing books page.
	#4-Student can return books when navigate to borrowing books page.
	#5-Student can select related category to see all books in that category by using book categories dropdown.
	#6-Student can use show records dropdown for getting number of entries depends the dropdown options.
	#7-Student can find book by using search box with book's Name and Author.
	@SYS-329 @SYS-324
	Scenario: Student can return books when navigate to borrowing books page
		And the user clicks borrowing books button
		Then the user should click return book button
		And the user should see the returned message	

	#1-Student can borrow books in books page.
	#2-Book cannot be borrowed twice at the same time.
	#3-Student should have a history of borrowed books when navigate to borrowing books page.
	#4-Student can return books when navigate to borrowing books page.
	#5-Student can select related category to see all books in that category by using book categories dropdown.
	#6-Student can use show records dropdown for getting number of entries depends the dropdown options.
	#7-Student can find book by using search box with book's Name and Author.
	@SYS-330 @SYS-324
	Scenario: Student can select related category to see all books in that category by using book categories dropdown
		 And the user should see following book options at the books page
		      | ALL                     |
		      | Action and Adventure    |
		      | Anthology               |
		      | Classic                 |
		      | Comic and Graphic Novel |
		      | Crime and Detective     |
		      | Drama                   |
		      | Fable                   |
		      | Fairy Tale              |
		      | Fan-Fiction             |
		      | Fantasy                 |
		      | Historical Fiction      |
		      | Horror                  |
		      | Science Fiction         |
		      | Biography/Autobiography |
		      | Humor                   |
		      | Romance                 |
		      | Short Story             |
		      | Essay                   |
		      | Memoir                  |
		      | Poetry                  |
		Then the user should be able select category	

	#1-Student can borrow books in books page.
	#2-Book cannot be borrowed twice at the same time.
	#3-Student should have a history of borrowed books when navigate to borrowing books page.
	#4-Student can return books when navigate to borrowing books page.
	#5-Student can select related category to see all books in that category by using book categories dropdown.
	#6-Student can use show records dropdown for getting number of entries depends the dropdown options.
	#7-Student can find book by using search box with book's Name and Author.
	@SYS-331 @SYS-324
	Scenario: Student can use show records dropdown for getting number of entries depends the dropdown options
		
		
		And the user should see following records options at the books page
		      | 5   |
		      | 10  |
		      | 15  |
		      | 50  |
		      | 100 |
		      | 200 |
		      | 500 |
		Then the user should be able to use show records dropdown	

	#1-Student can borrow books in books page.
	#2-Book cannot be borrowed twice at the same time.
	#3-Student should have a history of borrowed books when navigate to borrowing books page.
	#4-Student can return books when navigate to borrowing books page.
	#5-Student can select related category to see all books in that category by using book categories dropdown.
	#6-Student can use show records dropdown for getting number of entries depends the dropdown options.
	#7-Student can find book by using search box with book's Name and Author.
	@SYS-332 @SYS-324
	Scenario: Student can find book by using search box with book's Name and Author
		And the user enters valid author name into search box
		Then the user should see the searched author name
		When the user enters valid book name into search box
		Then the user should see the searched book name