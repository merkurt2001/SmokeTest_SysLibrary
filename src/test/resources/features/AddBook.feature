
Feature:

  Background:
		#@SYS-360
    Given the user is on the login page
    When the user enters the librarian information
    Then the user should be able to login
    Then the user should go to book from dashboard
    When the librarian click the add book button


  @SYS-361 @SYS-362
  Scenario: şenol/Librarian can add books
    And Add book should have following parameters
      | Book Name     |
      | ISBN          |
      | Year          |
      | Author        |
      | Book Category |
      | Description   |
    Then the librarian should add a new book by valid credentials
      | Book Name   |
      | Author      |
      | Description |
      | ISBN        |
      | Year        |
    And verify that saving book


  @SYS-363 @SYS-362
  Scenario Outline: şeno/ISBN valid credentials
    Then the librarian should add a new book by valid credentials
      | Book Name   |
      | Author      |
      | Description |
      | Year        |

    And "ISBN" accept following "<data>" examples

    Examples:
      | data           |
      | 1234567890     |
      | 123423452345   |
      | 2343247098543  |
      | 23453456345688 |
      | 3-234-435--56  |


  @SYS-364 @SYS-362
  Scenario Outline: şenol/year parameter's correct credentials
    Then the librarian should add a new book by valid credentials
      | Book Name   |
      | Author      |
      | Description |
      | ISBN        |

    And "Year" accept following "<data>" examples

    Examples:
      | data |
      | 2021 |
      | 1234 |


  @SYS-365 @SYS-362 @shb
  Scenario: şenol/following categories
    And Following categories should be present
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

    And Following categories should be chekable
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


  @SYS-366 @SYS-362
  Scenario Outline: şenol/negatif senaryos of name parameter
    When the librarian should add a new book by valid credentials
      | Author      |
      | Description |
      | ISBN        |
      | Year        |


    And verify that "Book Name" doesnt accept following "<data>" examples
    Examples:
      | data    |
      | 12asd34 |
      | asd'^+  |
      | a       |
      |         |


  @SYS-367 @SYS-362
  Scenario Outline: şenol/negatif senaryos of auther parameter
    When the librarian should add a new book by valid credentials
      | Book Name   |
      | Description |
      | ISBN        |
      | Year        |

    And verify that "Author" doesnt accept following "<data>" examples
    Examples:
      | data    |
      | 12asd34 |
      | asd'^+  |
      | a       |
      | as      |


  @SYS-368 @SYS-362
  Scenario Outline: şenol/negatif senaryos of ISBN parameter
    When the librarian should add a new book by valid credentials
      | Book Name   |
      | Author      |
      | Description |
      | Year        |

    And verify that "ISBN" doesnt accept following "<data>" examples
    Examples:
      | data           |
      | 123456789      |
      | asdfasdf       |
      | _=)(/          |
      | 12345678901234 |


  @SYS-369 @SYS-362
  Scenario Outline: şenol/negatif senaryos of year parameter
    When the librarian should add a new book by valid credentials
      | Book Name   |
      | Author      |
      | Description |
      | ISBN        |


    And verify that "Year" doesnt accept following "<data>" examples
    Examples:
      | data  |
      | 12349 |
      | _=)(/ |
      | 134   |