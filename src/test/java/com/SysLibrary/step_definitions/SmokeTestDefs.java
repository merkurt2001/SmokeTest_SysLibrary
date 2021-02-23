package com.SysLibrary.step_definitions;

import com.SysLibrary.pages.*;
import com.SysLibrary.utilities.BrowserUtils;
import com.SysLibrary.utilities.ConfigurationReader;
import com.SysLibrary.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SmokeTestDefs {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("the user login as a librarian")
    public void the_user_login_as_a_librarian() {
        new LoginPage().signInAsLibrarian();

    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        BrowserUtils.waitFor(3);
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Library", actualTitle);
    }

    @When("the user login as a student")
    public void the_user_login_as_a_student() {
        new LoginPage().signInAsStudent();

    }




    @Then("the user clicks borrow book button")
    public void the_user_clicks_borrow_book_button() {
        new StudentBooksPage().borrowBook.click();
    }

    @Then("the user should see the borrowed message")
    public void the_user_should_see_the_borrowed_message() {
        String expected = "The book has been borrowed...";
        Assert.assertEquals(expected, new StudentBooksPage().saveMessage.getText());
    }

    @When("the user enters valid book name into search box")
    public void the_user_enters_valid_book_name_into_search_box() {
        StudentBooksPage studentBooksPage = new StudentBooksPage();
        studentBooksPage.searchBox.clear();
        studentBooksPage.searchBox.sendKeys("The Alchemist");
        BrowserUtils.waitFor(3);
    }

    @Then("the user should see the searched book name")
    public void the_user_should_see_the_searched_book_name() {
        String expected = "The Alchemist";
        String actual = Driver.get().findElement(By.xpath("//tbody/tr/td[3]")).getText();
        Assert.assertEquals(expected, actual);
    }

    @Then("the user clicks borrowing books button")
    public void the_user_clicks_borrowing_books_button() {
        BrowserUtils.waitFor(5);
        new DashboardPage().borrowingBooksButton.click();
    }

    @Then("the user should click return book button")
    public void the_user_should_click_return_book_button() {
        String expected = "The Alchemist";
        for (int i = 1; i <= new BorrowingBooksPage().rows.size(); i++) {
            String str1 = "//tbody/tr[" + i + "]/";
            String str2 = "td[2]";
            String element = str1 + str2;
            String actual = Driver.get().findElement(By.xpath(element)).getText();
            if (actual.equals(expected)) {
                Driver.get().findElement(By.xpath(str1 + "td[1]")).click();
            }
        }
    }

    @Then("the user should see the returned message")
    public void the_user_should_see_the_returned_message() {
        String expected = "The book has been returned..";
        Assert.assertEquals(expected, new StudentBooksPage().saveMessage.getText());
    }

    @Then("the user should not see the borrowed message")
    public void the_user_should_not_see_the_borrowed_message() {
        Assert.assertTrue(new StudentBooksPage().borrowBook.isEnabled());

    }

    @When("the user clicks the users button")
    public void the_user_clicks_the_users_button() {
        new DashboardPage().usersButton.click();
    }

    @Then("the user clicks the add user button")
    public void the_user_clicks_the_add_user_button() {
        new UsersPage().addBooksButton.click();
    }

    @Then("the user enters user information with valid credentials")
    public void the_user_enters_user_information_with_valid_credentials() {
        BrowserUtils.waitFor(3);
        Faker faker = new Faker();
        UsersPage usersPage = new UsersPage();
        usersPage.userName.clear();
        usersPage.userName.sendKeys(faker.name().fullName());
        usersPage.password.clear();
        usersPage.password.sendKeys(String.valueOf(faker.number().numberBetween(100000000, 900000000)));
        usersPage.email.clear();
        usersPage.email.sendKeys(faker.name().firstName() + "@gmail.com");
        usersPage.address.clear();
        usersPage.address.sendKeys(String.valueOf(faker.address()));
        BrowserUtils.waitFor(1);
        usersPage.submit.click();
    }

    @Then("the user should be able to save the user")
    public void the_user_should_be_able_to_save_the_user() {
        BrowserUtils.waitFor(2);
        String expected = "The user has been created.";
        Assert.assertEquals(expected, new UsersPage().saveMessage.getText());
    }

    @Then("the user clicks the edit user button")
    public void the_user_clicks_the_edit_user_button() {
        new UsersPage().editUser.click();
    }

    @Then("the user should be able to updated")
    public void the_user_should_be_able_to_updated() {
        String expected = "The user updated.";
        Assert.assertEquals(expected, new UsersPage().saveMessage.getText());
    }


    @Then("the user clicks the books button")
    public void the_user_clicks_the_books_button() {
        new DashboardPage().librarianBooksButton.click();
    }

    @When("the user clicks the add book button")
    public void the_user_clicks_the_add_book_button() {
        new LibrarianBooksPage().addBooks.click();
    }

    @Then("the user should be able to add the book")
    public void the_user_should_be_able_to_add_the_book() {
        String expected = "The book has been created.";
        Assert.assertEquals(expected, new LibrarianBooksPage().saveMessage.getText());
    }

    @When("the user clicks the edit book button")
    public void the_user_clicks_the_edit_book_button() {
        new LibrarianBooksPage().editButton.click();
    }


    @Then("the user enters book information with valid credentials")
    public void the_user_enters_book_information_with_valid_credentials() {
        BrowserUtils.waitFor(3);
        Faker faker = new Faker();
        LibrarianBooksPage librarianBooksPage = new LibrarianBooksPage();
        librarianBooksPage.bookName.clear();
        librarianBooksPage.bookName.sendKeys(faker.book().title());
        librarianBooksPage.bookIsbn.clear();
        librarianBooksPage.bookIsbn.sendKeys(String.valueOf(faker.number().numberBetween(100000000, 900000000)));
        librarianBooksPage.bookYear.clear();
        librarianBooksPage.bookYear.sendKeys(String.valueOf(faker.number().numberBetween(1980, 2020)));
        librarianBooksPage.bookAuthor.clear();
        librarianBooksPage.bookAuthor.sendKeys(faker.book().author());
        librarianBooksPage.selectBookInEdit("Fable");
        librarianBooksPage.bookDescription.clear();
        librarianBooksPage.bookDescription.sendKeys(faker.shakespeare().asYouLikeItQuote());
        BrowserUtils.waitFor(3);
        librarianBooksPage.bookSubmit.click();

    }

    @Then("the user should be able to update the book")
    public void the_user_should_be_able_to_update_the_book() {
        String expected = "The book has been updated.";
        Assert.assertEquals(expected, new LibrarianBooksPage().saveMessage.getText());

    }

    @Then("the user should be log out")
    public void the_user_should_be_log_out() {
        new LibrarianBooksPage().logOut();
    }


}
