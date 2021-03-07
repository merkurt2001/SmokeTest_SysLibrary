package com.SysLibrary.step_definitions;


import com.SysLibrary.pages.DashboardPage;
import com.SysLibrary.utilities.BrowserUtils;
import com.SysLibrary.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
public class LogoutDefs {

    @And("the user using the logout button")
    public void the_user_using_the_logout_button() {
        BrowserUtils.waitFor(3);
        new DashboardPage().logOut();
    }


    @Then("the user should be able to logout")
    public void the_user_should_be_able_to_logout() {
        BrowserUtils.waitFor(3);
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Login - Library",actualTitle);
    }
}
