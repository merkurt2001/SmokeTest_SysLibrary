@SYS-340
Feature:

	Background:
		#@SYS-342
		Given the user is on the librarian books page
		

	#As a librarian, I should be able to edit books
	#
	#Acceptance Criteria:
	#
	#Edit book should have the following parameters: name,
	#author, description, category, ISBN, year.
	@SYS-343
	Scenario: Verify Edit Book Parameters
		When the user enters the edit book button
		And the user should see following fields options
		|Book Name      |
		|ISBN           |
		|Year           |
		|Author         |
		|Book Category  |
		|Description    |	

	#User Story :
	#
	#As a librarian, I should be able to edit books
	#
	#Acceptance Criteria:
	#
	#ISBN must be 10 or 13 digits in length and consists of digits (0-9) and dashes.
	@SYS-344
	Scenario: Verify that ISBN is consist of 10 or 13 digits
		When the user enters the edit book button
		And the user enters to ISBN "01A"
		Then the user should not be able save the changes	

	#User Story :
	#
	#As a librarian, I should be able to edit books
	#
	#Acceptance Criteria:
	#
	#Year parameter should have only digits (0-9)
	@SYS-345
	Scenario: Verify that Year is consist of only digits
		When the user enters the edit book button
		And the user enters to Years "abc"
		Then the user should not be able save the changes	

	#User Story :
	#
	#As a librarian, I should be able to edit books
	#
	#Acceptance Criteria:
	#
	#Following categories should be present:
	# - Action and Adventure
	# - Anthology
	# - Classic
	# - Comic and Graphic Novel
	# - Crime and Detective
	# - Drama
	# - Fable
	# - Fairy Tale
	# - Fan-Fiction
	# - Fantasy
	# - Historical Fiction
	# - Horror
	# - Science Fiction
	# - Biography/Autobiography
	# - Humor
	# - Romance
	# - Short Story
	# - Essay
	# - Memoir
	# - Poetry
	@SYS-346
	Scenario: Verify book categories presented
		When the user enters the edit book button
		And the user should see following book options at the edit option
		
		
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

	#As a librarian, I should be able to edit books
	#
	#Acceptance Criteria:
	#
	#Librarian can select related category to see all books in that category by using book categories dropdown.
	@SYS-347
	Scenario: Verify that Librarian can select category to see all books in that category
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

	#User Story :
	#
	#As a librarian, I should be able to edit books
	#
	#Acceptance Criteria:
	#
	#Librarian can use show records dropdown for getting the number of entries depends on the dropdown options.
	@SYS-348
	Scenario: Verify that librarian can use show records dropdown for getting the number of entries
		And the user should see following records options at the books page
		 
		      | 5   |
		      | 10  |
		      | 15  |
		      | 50  |
		      | 100 |
		      | 200 |
		      | 500 |	

	#User Story :
	#
	#As a librarian, I should be able to edit books
	#
	#Acceptance Criteria:
	#
	#Librarian can find book by using search box with the book's Name and Author.
	@SYS-349
	Scenario: Verify that Librarian can find book by the book's Name and Author
		And the user enters valid author name into search box
		Then the user should see the searched author name
		When the user enters valid book name into search box
		Then the user should see the searched book name	

	#User Story :
	#
	#As a librarian, I should be able to edit books
	#
	#Acceptance Criteria:
	#
	#1-Librarian can edit books
	#2- Edit book should have the following parameters: name,
	#author, description, category, ISBN, year.
	#3- ISBN must be 10 or 13 digits in length and consists of digits (0-9) and dashes.
	#4-Year parameter should have only digits (0-9)
	#5-Following categories should be present:
	# - Action and Adventure
	# - Anthology
	# - Classic
	# - Comic and Graphic Novel
	# - Crime and Detective
	# - Drama
	# - Fable
	# - Fairy Tale
	# - Fan-Fiction
	# - Fantasy
	# - Historical Fiction
	# - Horror
	# - Science Fiction
	# - Biography/Autobiography
	# - Humor
	# - Romance
	# - Short Story
	# - Essay
	# - Memoir
	# - Poetry
	#
	#6-Librarian can select related category to see all books in that category by using book categories dropdown.
	#7-Librarian can use show records dropdown for getting the number of entries depends on the dropdown options.
	#8-Librarian can find book by using search box with the book's Name and Author.
	@SYS-341
	Scenario: Verify that librarian can edit books
		When the user enters the edit books button
		And the user enters book information with valid credentials
		Then the user should be able to save the changes