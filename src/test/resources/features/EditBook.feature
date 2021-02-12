Feature: Edit Book Functionality

  Background:
    Given the user is on the librarian books page

  Scenario: Verify that librarian can edit books

    When the user enters the edit book button
    And the user enters book information with valid credentials
    Then the user should be able to save the changes


  Scenario: Verify Edit book parameters

    When the user enters the edit book button
    And the user should see following fields options

      | Book Name     |
      | ISBN          |
      | Year          |
      | Author        |
      | Book Category |
      | Description   |

  Scenario: Verify that ISBN is consist of 10 or 13 digits

    When the user enters the edit book button
    And the user enters to ISBN "12F"
    Then the user should not be able save the changes

  Scenario: Verify that Year is consist of only digits

    When the user enters the edit book button
    And the user enters to Years "abc"
    Then the user should not be able save the changes

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


  Scenario: Verify that librarian can use show records dropdown for getting the number of entries

    And the user should see following records options at the books page
      | 5   |
      | 10  |
      | 15  |
      | 50  |
      | 100 |
      | 200 |
      | 500 |

  @wip
  Scenario: Verify that Librarian can find book by the book's Name and Author

    And the user enters valid author name into search box
    Then the user should see the searched author name
    When the user enters valid book name into search box
    Then the user should see the searched book name