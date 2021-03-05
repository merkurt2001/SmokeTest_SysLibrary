@SYS-358
Feature:

  Background:
		#@SYS-351
    Given the user is on the login page
    When the user enters the librarian information
    Then the user should be able to login
    And Librarian is on the add user page
		
    #  SCENARIO NUMBER 1_POSITIVE SCENARIO;
	#  Librarian can add new user
    #  Full Name, Password, Email, User Group, Status, Start Date, End Date, Address
    #  information will be achieved from Faker class

  @SYS-350 @SYS-358
  Scenario: Librarian can add user with valid inputs
    When Librarian will enter valid information for a new user
    And Librarian will click on Save Changes button
    Then "The user has been created." message should be displayed

	# SCENARIO NUMBER 2_POSITIVE SCENARIO;
	#   Full Name, Password, Email, User Group, Status, Start Date, End Date, Address should be seen on the Add User Page

  @SYS-352 @SYS-358
  Scenario: Parameters should be available on Add User Page
    Given Add User should have following parameters
      | Full Name  |
      | Password   |
      | Email      |
      | User Group |
      | Status     |
      | Start Date |
      | End Date   |
      | Address    |

     # SCENARIO NUMBER 3_POSITIVE SCENARIO;
	#User Group should have 2 user types as Librarian and Students

  @SYS-353 @SYS-358
  Scenario: User Group should have 2 user types as Librarian and Student
    And Following categories should be present under User Group
      | Librarian |
      | Students  |

    # SCENARIO NUMBER 4_POSITIVE SCENARIO;
	#Status should have ACTIVE and INACTIVE

  @SYS-354 @SYS-358
  Scenario: Status should have  ACTIVE and INACTIVE
    And Status dropdown should have the following options: ACTIVE,INACTIVE

    # SCENARIO NUMBER 5_NEGATIVE SCENARIO;
   #  Full Name, Password and  Email shouldn't be empty.
   #  Otherwise "This field is required." message should be seen under the related input area.

  @SYS-355 @SYS-358
  Scenario Outline: Librarian cannot add users without Full Name, Password, Email inputs
    When the user enters "<Full Name>""<Password>""<Email>""<User Group>""<Status>""<Start Date>""<End Date>""<Address>" information
    Then "This field is required." message should be displayed under Full Name, Password or Email
    Examples:
      | Full Name  | Password  | Email          | User Group | Status | Start Date | End Date   | Address                     |
      |            | 123456789 | mike@gmail.com | Librarian  | ACTIVE | 2021-02-04 | 2021-03-04 | 3211 Street 54 Virginia/USA |
      | Mike Smith |           | mike@gmail.com | Librarian  | ACTIVE | 2021-02-04 | 2021-03-04 | 3211 Street 54 Virginia/USA |
      | Mike Smith | 123456789 |                | Librarian  | ACTIVE | 2021-02-04 | 2021-03-04 | 3211 Street 54 Virginia/USA |
			

	   # SCENARIO NUMBER 6_POSITIVE SCENARIO;
       #  Verify from the User List

  @SYS-356 @SYS-358
  Scenario: Librarian can add user with valid inputs and check information when user added
    When Librarian will enter following valid information for a new user
      | Full Name  | Steven King                 |
      | Password   | 123456789                   |
      | Email      | stevenking@gmail.com        |
      | User Group | Librarian                   |
      | Status     | ACTIVE                      |
      | Start Date | 2021-02-04                  |
      | End Date   | 2021-03-04                  |
      | Address    | 8877 Street 66 Virginia/USA |

    And Librarian will click on Save Changes button
    Then "The user has been created." message should be displayed
    When The user enter the "Steven King" to the search box on the Users Page
    And "Steven King" information should be seen in the Users List
			
        # SCENARIO NUMBER 7_NEGATIVE SCENARIO;
        #  Check the end date shouldn't be earlier than start date. If it is earlier than start date
        #  "The user has been created." message should not be displayed


  @SYS-357 @SYS-358
  Scenario: End date shouldn't be earlier than Start date
    When Librarian will enter "2021-03-04" for Start Date and "2020-01-01" for End Date while other info are valid
    And Librarian will click on Save Changes button
    Then "The user has been created." message should not be displayed