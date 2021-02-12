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
import org.openqa.selenium.By;

import java.util.List;

public class EditBooksDefs {

    @Given("the user is on the librarian books page")
    public void the_user_is_on_the_librarian_books_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        new LoginPage().signInAsLibrarian();
        new DashboardPage().librarianBooksButton.click();
    }

    @When("the user enters the edit book button")
    public void the_user_enters_the_edit_book_button() {

        new LibrarianBooksPage().editButton.click();

    }


    @Then("the user enters book information with valid credentials")
    public void the_user_enters_book_information_with_valid_credentials() {
        BrowserUtils.waitFor(2);
        Faker faker=new Faker();
        LibrarianBooksPage librarianBooksPage = new LibrarianBooksPage();
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

        String expected = "The book has been updated.";
        Assert.assertEquals(expected, new LibrarianBooksPage().saveMessage.getText());

    }

    @When("the user should see following fields options")
    public void the_user_should_see_following_fields_options(List<String> menuOptions) {
        BrowserUtils.waitFor(2);
        List<String> options = new LibrarianBooksPage().booksFieldsList();

        if (options.equals(menuOptions)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }

    @When("the user enters to ISBN {string}")
    public void the_user_enters_to_ISBN(String ISBN) {
        LibrarianBooksPage librarianBooksPage = new LibrarianBooksPage();
        librarianBooksPage.bookIsbn.clear();
        librarianBooksPage.bookIsbn.sendKeys(ISBN);
        BrowserUtils.waitFor(2);
        librarianBooksPage.bookSubmit.click();
    }

    @Then("the user should not be able save the changes")
    public void the_user_should_not_be_able_save_the_changes() {
        String expected = "The book has been updated.";
        Assert.assertNotEquals(expected, new LibrarianBooksPage().saveMessage.getText());
    }

    @When("the user enters to Years {string}")
    public void the_user_enters_to_Years(String years) {
        LibrarianBooksPage librarianBooksPage = new LibrarianBooksPage();
        librarianBooksPage.bookYear.clear();
        BrowserUtils.waitFor(2);
        librarianBooksPage.bookYear.sendKeys(years);
        BrowserUtils.waitFor(3);
        librarianBooksPage.bookSubmit.click();
    }

    @When("the user should see following book options at the edit option")
    public void the_user_should_see_following_book_options_at_the_edit_option(List<String> bookOptions) {
        BrowserUtils.waitFor(2);
        List<String> options = new LibrarianBooksPage().bookListAdd();

        if (options.equals(bookOptions)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }


    @Given("the user should see following book options at the books page")
    public void the_user_should_see_following_book_options_at_the_books_page(List<String> bookOptions) {
        BrowserUtils.waitFor(2);
        List<String> options = new LibrarianBooksPage().bookList();

        if (options.equals(bookOptions)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @Given("the user should see following records options at the books page")
    public void the_user_should_see_following_records_options_at_the_books_page(List<String> recordsOptions) {
        BrowserUtils.waitFor(2);
        List<String> options = new LibrarianBooksPage().recordList();

        if (options.equals(recordsOptions)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @Given("the user enters valid author name into search box")
    public void the_user_enters_valid_author_name_into_search_box() {
        LibrarianBooksPage librarianBooksPage = new LibrarianBooksPage();
        librarianBooksPage.searchBox.clear();
        librarianBooksPage.searchBox.sendKeys("Elif FASK");
        BrowserUtils.waitFor(3);
    }

    @Then("the user should see the searched author name")
    public void the_user_should_see_the_searched_author_name() {
        String expected = "Elif FASK";
        String actual = Driver.get().findElement(By.xpath("//tbody/tr/td[4]")).getText();
        Assert.assertEquals(expected,actual);
    }

    @When("the user enters valid book name into search box")
    public void the_user_enters_valid_book_name_into_search_box() {
        LibrarianBooksPage librarianBooksPage = new LibrarianBooksPage();
        librarianBooksPage.searchBox.clear();
        librarianBooksPage.searchBox.sendKeys("The Alchemist");
        BrowserUtils.waitFor(3);
    }

    @Then("the user should see the searched book name")
    public void the_user_should_see_the_searched_book_name() {
        String expected = "The Alchemist";
        String actual = Driver.get().findElement(By.xpath("//tbody/tr/td[3]")).getText();

        Assert.assertEquals(expected,actual);
    }

}
