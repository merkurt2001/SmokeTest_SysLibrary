package com.SysLibrary.step_definitions;

import com.SysLibrary.pages.DashboardPage;
import com.SysLibrary.pages.LibrarianBooksPage;
import com.SysLibrary.pages.LoginPage;
import com.SysLibrary.utilities.BrowserUtils;
import com.SysLibrary.utilities.ConfigurationReader;
import com.SysLibrary.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class loginDefs {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("the user enters the librarian information")
    public void the_user_enters_the_librarian_information() {
        new LoginPage().signInAsLibrarian();

    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        BrowserUtils.waitFor(3);
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Library",actualTitle);
    }

    @When("the user enters the student information")
    public void the_user_enters_the_student_information() {
        new LoginPage().signInAsStudent();

    }
    @When("the user enters the invalid user {string}{string}")
    public void the_user_enters_the_invalid_user(String email, String password) {
        new LoginPage().signIn(email,password);
    }

    @When("the user enters the invalid passwords {string}{string}")
    public void the_user_enters_the_invalid_passwords(String email, String password) {
        new LoginPage().signIn(email,password);
    }

    @Then("the UnAuthorized user should not be able to login")
    public void the_UnAuthorized_user_should_not_be_able_to_login() {
        BrowserUtils.waitFor(3);
        String actualTitle = Driver.get().getTitle();
        Assert.assertNotEquals("Library",actualTitle);
    }

}
