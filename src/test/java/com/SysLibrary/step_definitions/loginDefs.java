package com.SysLibrary.step_definitions;

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
}
