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
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BorrowingBookDefs {


    @Then("the user clicks borrow book button")
    public void the_user_clicks_borrow_book_button() {
        new StudentBooksPage().borrowBook.click();
    }


    @When("the user enters valid book name into search box")
    public void the_user_enters_valid_book_name_into_search_box() {
        StudentBooksPage studentBooksPage = new StudentBooksPage();
        studentBooksPage.searchBox.clear();
        studentBooksPage.searchBox.sendKeys("SysLibrary-Project");
        BrowserUtils.waitFor(3);
    }

    @Then("the user should see the searched book name")
    public void the_user_should_see_the_searched_book_name() {
        String expected = "SysLibrary-Project";
        String actual = Driver.get().findElement(By.xpath("//tbody/tr/td[3]")).getText();
        Assert.assertEquals(expected, actual);
    }

    @Then("the user clicks borrowing books button")
    public void the_user_clicks_borrowing_books_button() {
        BrowserUtils.waitFor(5);
        new DashboardPage().borrowingBooksButton.click();
    }

    @Then("the user should see only one not return message")
    public void the_user_should_see_only_one_not_return_message() {
        String expected = "SysLibrary-Project";
        int count = 0;
        for (int i = 1; i <= new BorrowingBooksPage().rows.size(); i++) {
            String str1 = "//tbody/tr[" + i + "]/";
            String str2 = "td[2]";
            String element = str1 + str2;
            String actual = Driver.get().findElement(By.xpath(element)).getText();
            if (actual.equals(expected)) {

                String isReturned = Driver.get().findElement(By.xpath(str1 + "td[6]")).getText();
                if (isReturned.equals("NOT RETURNED")) {
                    count++;
                }
            }

        }
        Assert.assertTrue(count == 1);
    }

    @Then("the user should click return book button")
    public void the_user_should_click_return_book_button() {
        String expected = "SysLibrary-Project";
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

    @Then("the user should see the {} message")
    public void the_user_should_see_the_message(String message) {
        if (message.contains("borrowed")) {
            String expected = "The book has been borrowed...";
            Assert.assertEquals(expected, new StudentBooksPage().saveMessage.getText());
        } else if (message.contains("returned")) {
            String expected = "The book has been returned..";
            Assert.assertEquals(expected, new StudentBooksPage().saveMessage.getText());
        }
    }


    @Then("the user should see the history of borrowed books")
    public void the_user_should_see_the_history_of_borrowed_books() {
        int size = new BorrowingBooksPage().rows.size();
        Assert.assertTrue(size != 0);
        System.out.println(size);

    }


    @Given("the user should see following book options at the books page")
    public void the_user_should_see_following_book_options_at_the_books_page(List<String> bookOptions) {
        BrowserUtils.waitFor(2);
        List<String> options = new StudentBooksPage().bookList();

        Assert.assertTrue(options.equals(bookOptions));
    }


    @Then("the user should be able select category")
    public void the_user_should_be_able_select_category() {
        new StudentBooksPage().selectBook("Fable");
        Select chooseCategory = new Select(new StudentBooksPage().selectBookMain);
        Assert.assertEquals("Fable", chooseCategory.getFirstSelectedOption().getText());
    }

    @Given("the user should see following records options at the books page")
    public void the_user_should_see_following_records_options_at_the_books_page(List<String> recordsOptions) {
        BrowserUtils.waitFor(2);
        List<String> options = new StudentBooksPage().recordList();

        Assert.assertTrue(options.equals(recordsOptions));
    }

    @Then("the user should be able to use show records dropdown")
    public void the_user_should_be_able_to_use_show_records_dropdown() {
        new StudentBooksPage().selectRecord("50");
        Select chooseRecord = new Select(new StudentBooksPage().recordsDropdown);
        Assert.assertEquals("50", chooseRecord.getFirstSelectedOption().getText());

    }

    @Given("the user enters valid author name into search box")
    public void the_user_enters_valid_author_name_into_search_box() {
        StudentBooksPage studentBooksPage = new StudentBooksPage();
        studentBooksPage.searchBox.clear();
        studentBooksPage.searchBox.sendKeys("Group-25");
        BrowserUtils.waitFor(3);
    }

    @Then("the user should see the searched author name")
    public void the_user_should_see_the_searched_author_name() {
        String expected = "Group-25";
        String actual = Driver.get().findElement(By.xpath("//tbody/tr/td[4]")).getText();
        Assert.assertEquals(expected, actual);
    }
}


