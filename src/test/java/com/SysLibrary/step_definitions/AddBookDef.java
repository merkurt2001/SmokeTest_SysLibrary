package com.SysLibrary.step_definitions;

import com.SysLibrary.pages.DashboardPage;
import com.SysLibrary.pages.LibrarianBooksPage;
import com.SysLibrary.utilities.BrowserUtils;
import com.SysLibrary.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AddBookDef {

    Faker faker=new Faker();
    @Then("the user should go to book from dashboard")
    public void the_user_should_go_to_book_from_dashboard() {
        new DashboardPage().librarianBooksButton.click();
        BrowserUtils.waitFor(1);
    }

    @When("the librarian click the add book button")
    public void the_librarian_click_the_add_book_button() {
        new LibrarianBooksPage().addBooks.click();
        BrowserUtils.waitFor(1);
    }

    @When("Add book should have following parameters")
    public void add_book_should_have_following_parameters(List<String> dataTable) {
        Assert.assertEquals(LibrarianBooksPage.inputNames(),dataTable);
    }

    @Then("the librarian should add a new book by valid credentials")
    public void the_librarian_should_add_a_new_book_by_valid_credentials(List<String> dataTable) {
        for(String data:dataTable){
            switch (data){
                case "Book Name":
                case "Author":
                    LibrarianBooksPage.parameters(data).sendKeys(faker.name().fullName());
                    break;
                case "ISBN":
                    LibrarianBooksPage.parameters(data).sendKeys(String.valueOf(faker.number().digits(10)));
                    break;
                case "Year":
                    LibrarianBooksPage.parameters(data).sendKeys("2021");
                    break;
                case "Description":
                    LibrarianBooksPage.parameters(data).sendKeys(faker.address().fullAddress());
                    break;
            }
        }


    }

    @Then("{string} accept following {string} examples")
    public void accept_following_examples(String input, String data) {
        System.out.println(data);
        System.out.println(input);
        LibrarianBooksPage.parameters(input).sendKeys(data);
        new LibrarianBooksPage().bookSubmit.click();
        BrowserUtils.waitFor(1);
        new Actions(Driver.get()).moveToElement(new LibrarianBooksPage().saveMessage).perform();
        Assert.assertTrue(new LibrarianBooksPage().saveMessage.isDisplayed());
    }

    @Then("Following categories should be present")
    public void following_categories_should_be_present(List<String> bookCategories) {
        Assert.assertEquals(new LibrarianBooksPage().addBookList(), bookCategories);
    }

    @Then("Following categories should be chekable")
    public void following_categories_should_be_chekable(List<String> dataTable) {
        Select select=new Select(new LibrarianBooksPage().bookCategory);
        for(String data:dataTable  ){
            select.selectByVisibleText(data);
            Assert.assertEquals(data,select.getFirstSelectedOption());
        }
    }


    @When("verify that {string} doesnt accept following {string} examples")
    public void verify_that_doesnt_accept_following_examples(String input, String data) {
        if(data!=null){
        LibrarianBooksPage.parameters(input).sendKeys(data);
        }
        new LibrarianBooksPage().bookSubmit.click();
        BrowserUtils.waitFor(1);

        if(!Driver.get().findElement(By.xpath("//*[contains(@class,'modal fade')]")).isDisplayed()){
            new Actions(Driver.get()).moveToElement(new LibrarianBooksPage().saveMessage).perform();
            Assert.assertFalse(new LibrarianBooksPage().saveMessage.isDisplayed());
        }else{
            if(input.equals("Book Name")){ input="name";}
            String path=input.toLowerCase()+"-error";
            System.out.println(path);
            Assert.assertTrue(Driver.get().findElement(By.id(path)).isDisplayed());
        }
    }


    @Then("verify that saving book")
    public void verify_that_saving_book() {
        new LibrarianBooksPage().bookSubmit.click();
        BrowserUtils.waitFor(1);
        new Actions(Driver.get()).moveToElement(new LibrarianBooksPage().saveMessage).perform();
        Assert.assertTrue(new LibrarianBooksPage().saveMessage.isDisplayed());
    }



}
