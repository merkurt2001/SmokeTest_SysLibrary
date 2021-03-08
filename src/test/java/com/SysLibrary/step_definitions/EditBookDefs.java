package com.SysLibrary.step_definitions;

import com.SysLibrary.pages.DashboardPage;
import com.SysLibrary.pages.LibrarianBooksPage;
import com.SysLibrary.pages.LoginPage;
import com.SysLibrary.utilities.BrowserUtils;
import com.SysLibrary.utilities.ConfigurationReader;
import com.SysLibrary.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class EditBookDefs {

    @Given("the user is on the librarian books page")
    public void the_user_is_on_the_librarian_books_page() {
        String url= ConfigurationReader.get("url");
        Driver.get().get(url);
        new LoginPage().signInAsLibrarian();
        new DashboardPage().librarianBooksButton.click();

    }

    @When("the user enters the edit book button")
    public void the_user_enters_the_edit_book_button() {

        new LibrarianBooksPage().editButton.click();
    }

    @When("the user should see following fields options")
    public void the_user_should_see_following_fields_options(List<String> menuOptions) {
        BrowserUtils.waitFor(5);
        List<String> options=new LibrarianBooksPage().booksFieldsList();
        if(options.equals(menuOptions)){
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }


    }

    @When("the user enters to ISBN {string}")
    public void the_user_enters_to_ISBN(String ISBN) {
        LibrarianBooksPage librarianBooksPage=new LibrarianBooksPage();
        librarianBooksPage.bookIsbn.clear();
        librarianBooksPage.bookIsbn.sendKeys(ISBN);
        BrowserUtils.waitFor(4);
        librarianBooksPage.bookSubmit.click();

    }

    @Then("the user should not be able save the changes")
    public void the_user_should_not_be_able_save_the_changes() {
       String expectedResult="The book has been updated.";
       String actualResult=new LibrarianBooksPage().saveMessage.getText();
       Assert.assertNotEquals(expectedResult,actualResult);

    }

    @When("the user enters to Years {string}")
    public void the_user_enters_to_Years(String years) {
      LibrarianBooksPage librarianBooksPage=new LibrarianBooksPage();
      librarianBooksPage.bookYear.clear();
      BrowserUtils.waitFor(2);
      librarianBooksPage.bookYear.sendKeys(years);
      BrowserUtils.waitFor(3);
      librarianBooksPage.bookSubmit.click();
    }

    @When("the user should see following book options at the edit option")
    public void the_user_should_see_following_book_options_at_the_edit_option(List<String> bookOptions) {
        BrowserUtils.waitFor(3);
        List<String> options=new LibrarianBooksPage().bookListAdd();
        if(options.equals(bookOptions)){
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }

    }

    @When("the user enters the edit books button")
    public void the_user_enters_the_edit_books_button() {
        new DashboardPage().librarianBooksButton.click();
        new LibrarianBooksPage().editButton.click();
    }

    @When("the user enters book information with valid credentials")
    public void the_user_enters_book_information_with_valid_credentials() {
       BrowserUtils.waitFor(2);
       Faker faker=new Faker();
       LibrarianBooksPage librarianBooksPage=new LibrarianBooksPage();
       librarianBooksPage.bookName.clear();
       librarianBooksPage.bookName.sendKeys(faker.book().title());
        librarianBooksPage.bookIsbn.clear();
        librarianBooksPage.bookIsbn.sendKeys(String.valueOf(faker.number().numberBetween(100000000,900000000)));
        librarianBooksPage.bookYear.clear();
        librarianBooksPage.bookYear.sendKeys(String.valueOf(faker.number().numberBetween(1980,2020)));
        librarianBooksPage.bookAuthor.clear();
        librarianBooksPage.bookAuthor.sendKeys(faker.book().author());
        librarianBooksPage.selectBookInEdit("Classic");
        librarianBooksPage.bookDescription.clear();
        librarianBooksPage.bookDescription.sendKeys(faker.shakespeare().asYouLikeItQuote());
        BrowserUtils.waitFor(3);
        librarianBooksPage.bookSubmit.click();
    }

    @Then("the user should be able to save the changes")
    public void the_user_should_be_able_to_save_the_changes() {
     String expectedResult="The book has been updated.";
     Assert.assertEquals(expectedResult,new LibrarianBooksPage().saveMessage.getText());
    }

}
