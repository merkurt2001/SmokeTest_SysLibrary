
@wip
Feature:

  @SYS-371 @SYS-385
  Scenario: Librarian should be able to edit user
    Given Librarian is on the edit user page
    When Librarian enter valid inputs to options fields
    And Librarian click save changes button
    Then Librarian should be able to see "The user updated." message

  @SYS-373 @SYS-385
  Scenario: Verify edit user options
    Given Librarian is on the edit user page
    Then Librarian see following options
      | Full Name  |
      | Password   |
      | Email      |
      | User Group |
      | Status     |
      | Start Date |
      | End Date   |
      | Address    |

  @SYS-374 @SYS-385
  Scenario: Verify user groups on edit user page
    Given Librarian is on the edit user page
    When Librarian click on "UserGroup" dropdown
    Then Librarian should be able to see following "UserGroup" options
      | Librarian |
      | Students  |


  @SYS-375 @SYS-385
  Scenario: Verify status options on edit user page
    Given Librarian is on the edit user page
    When Librarian click on "Status" dropdown
    Then Librarian should be able to see following "Status" options
      | ACTIVE   |
      | INACTIVE |



  @SYS-376 @SYS-385
  Scenario Outline: Verify Librarian can select user group options
    Given Librarian is on the edit user page
    When Librarian click on "UserGroup" dropdown
    Then Librarian should be able to select "<option>" in "UserGroup" dropdown
    Examples:
      | option    |
      | Librarian |
      | Students  |


  @SYS-382 @SYS-385
  Scenario Outline: Verify Librarian can use show records dropdown on User Management page
    Given Librarian is on the users page
    When Librarian click on show records dropdown
    And Librarian click "<number>" option
    Then Librarian should be able to see Showing 1 to "<number>" of sentence at the bottom of table

    Examples:
      | number |
      | 5      |
      | 10     |
      | 200    |


  @SYS-383 @SYS-385
  Scenario Outline: Verify Librarian can use search box on the User Management page
    Given Librarian is on the users page
    When Librarian enter "<input>" to search box
    Then Librarian should be able to see results that filtered by "<input>"
    Examples:
      | input |
      | Ciara |
      #| Mike  |


  @SYS-384 @SYS-385
  Scenario Outline: Verify Librarian can use Status dropdown
    Given Librarian is on the edit user page
    When Librarian click on "Status" dropdown
    Then Librarian should be able to select "<option>" in "Status" dropdown
    Examples:
      | option   |
      | ACTIVE   |
      | INACTIVE |