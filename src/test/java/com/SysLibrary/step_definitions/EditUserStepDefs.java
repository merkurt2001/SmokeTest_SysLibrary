package com.SysLibrary.step_definitions;

import com.SysLibrary.pages.BasePage;
import com.SysLibrary.pages.*;
import com.SysLibrary.utilities.*;
import com.github.javafaker.Faker;
import io.cucumber.java.en.*;

import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EditUserStepDefs {

    @Given("Librarian is on the edit user page")
    public void librarian_is_on_the_edit_user_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        new LoginPage().signInAsLibrarian();
        new DashboardPage().navigatePages("Users");
        new LibrarianUsersPage().firstRowEditUser.click();
    }
    @Given("Librarian is on the users page")
    public void librarian_is_on_the_users_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        new LoginPage().signInAsLibrarian();
        new DashboardPage().navigatePages("Users");
    }

   @When("Librarian enter valid inputs to options fields")
    public void librarian_enter_valid_inputs_to_options_fields() {
        BrowserUtils.waitForPageToLoad(5);
        Faker faker = new Faker();
        LibrarianUsersPage librarianUsersPage = new LibrarianUsersPage();
        librarianUsersPage.addUserFullName.clear();
        librarianUsersPage.addUserFullName.sendKeys(faker.name().fullName());
        librarianUsersPage.addUserPassword.clear();
        librarianUsersPage.addUserPassword.sendKeys(faker.internet().password());
        librarianUsersPage.addUserEmail.clear();
        librarianUsersPage.addUserEmail.sendKeys(faker.internet().emailAddress());

    }
    @When("Librarian click save changes button")
    public void librarian_click_save_changes_button() {
        new LibrarianUsersPage().addUserSaveChanges.click();
    }

    @Then("Librarian should be able to see {string} message")
    public void librarian_should_be_able_to_see_message(String updatedMessage) {
        LibrarianUsersPage librarianUsersPage = new LibrarianUsersPage();
        BrowserUtils.waitForVisibility(librarianUsersPage.addUserCreatedMessage,10);
        Actions action = new Actions(Driver.get());
        action.moveToElement(librarianUsersPage.addUserCreatedMessage);
        Assert.assertEquals(librarianUsersPage.addUserCreatedMessage.getText(), updatedMessage);
    }

    @Then("Librarian see following options")
    public void librarian_see_following_options(List<String> options) {
        LibrarianUsersPage librarianUsersPage = new LibrarianUsersPage();
        BrowserUtils.waitFor(2);
        List<WebElement> actualOptions = Driver.get().findElements(By.xpath("//*[@id='edit_user_modal']//label[@class='control-label']"));
        System.out.println(BrowserUtils.getElementsText(actualOptions).toString());
        Assert.assertEquals(options,BrowserUtils.getElementsText(actualOptions));
    }

   @Then("Librarian should be able to see following {string} options")
    public void librarian_should_be_able_to_see_following_options(String dropdown,List<String> options) {
        BrowserUtils.waitForPageToLoad(5);
        String xpathString;
        if (dropdown.equals("Status")) {
            xpathString = "//*[@id='status']";
        }else {
            xpathString = "//*[@id='user_group_id']";
        }
        BrowserUtils.waitForPageToLoad(15);
        BrowserUtils.waitFor(5);
        List<WebElement> actualOptions = new Select(Driver.get().findElement(By.xpath(xpathString))).getOptions();
        System.out.println(BrowserUtils.getElementsText(actualOptions).toString());
        Assert.assertEquals(options,BrowserUtils.getElementsText(actualOptions));

    }

    @Then("Librarian should be able to select {string} in {string} dropdown")
    public void librarian_should_be_able_to_select_in_dropdown(String option, String dropdown) {
        LibrarianUsersPage librarianUsersPage = new LibrarianUsersPage();
        WebElement dropdownElement=null;
        BrowserUtils.waitForPageToLoad(5);
        if (dropdown.equals("UserGroup")) {
           dropdownElement = librarianUsersPage.addUserUserGroup;
        }else {
            dropdownElement = librarianUsersPage.addUserStatus;
        }
        BrowserUtils.waitForPageToLoad(5);
        BrowserUtils.waitFor(5);
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(option);
        BrowserUtils.waitForPageToLoad(5);
        String actualOptionText = select.getFirstSelectedOption().getText();
        Assert.assertEquals(option,actualOptionText);
        System.out.println(select.getFirstSelectedOption().getText());

    }

    @When("Librarian click {string} option")
    public void librarian_click_option(String number) {
        BrowserUtils.waitForPageToLoad(5);
        Select select = new Select(new LibrarianUsersPage().showRecords);
        select.selectByVisibleText(number);
    }

    @Then("Librarian should be able to see Showing {int} to {string} of sentence at the bottom of table")
    public void librarian_should_be_able_to_see_Showing_to_of_sentence_at_the_bottom_of_table(Integer int1, String number) {
        BrowserUtils.waitFor(10);
        BrowserUtils.waitForPageToLoad(5);
        WebElement tableInfo = Driver.get().findElement(By.id("tbl_users_info"));
        BrowserUtils.waitForVisibility(tableInfo,5);
        String actualTableInfoText = tableInfo.getText();
        System.out.println(actualTableInfoText);
        Assert.assertTrue(actualTableInfoText.contains(int1 + " to " + number + " of" ));
    }

    @When("Librarian enter {string} to search box")
    public void librarian_enter_to_search_box(String input) {
        LibrarianUsersPage librarianUsersPage = new LibrarianUsersPage();
        BrowserUtils.waitForPageToLoad(5);
        BrowserUtils.waitFor(4);
        librarianUsersPage.searchBox.sendKeys(input);


    }

    @Then("Librarian should be able to see results that filtered by {string}")
    public void librarian_should_be_able_to_see_results_that_filtered_by(String input) {
        List<WebElement> listTable=new ArrayList<>();
        List<WebElement> emailTable=new ArrayList<>();
        BrowserUtils.waitFor(3);
        if(!Driver.get().findElement(By.xpath("//table[@id='tbl_users']/tbody/tr/td[1]")).isEnabled()){
            throw new WebDriverException("no results");
        }
        do{
            BrowserUtils.waitFor(3);
            listTable=Driver.get().findElements(By.xpath("//table[@id='tbl_users']/tbody/tr/td[3]"));
            emailTable=Driver.get().findElements(By.xpath("//table[@id='tbl_users']/tbody/tr/td[4]"));
            List<String> nameList=BrowserUtils.getElementsText(listTable);
            List<String> emailList=BrowserUtils.getElementsText(emailTable);
            for (int i=1; i<nameList.size(); i++){
                BrowserUtils.waitForPageToLoad(10);
                BrowserUtils.waitFor(3);
                Assert.assertTrue(nameList.get(i).toLowerCase().contains(input.toLowerCase())
                                        || emailList.get(i).toLowerCase().contains(input.toLowerCase()));
            }
            try{
                BrowserUtils.waitForPageToLoad(10);
                new LibrarianUsersPage().nextBtn.click();
                BrowserUtils.waitFor(1);
            }catch (Exception e){
                throw new WebDriverException("next is disabled");
            }
        }while (!new LibrarianUsersPage().nextBtn.getAttribute("class").contains("disabled"));

    }

   @When("Librarian click on {string} dropdown")
    public void librarian_click_on_dropdown(String dropdown) {
       /*BrowserUtils.waitForPageToLoad(5);
       System.out.println(dropdown);
       WebElement element;
        if (dropdown.equals("UserGroup")) {
           element = Driver.get().findElement(By.id("user_group_id"));
        }else if(dropdown.equals("Status")){
            element = Driver.get().findElement(By.id("status"));
        }else {
            element = Driver.get().findElement(By.name("tbl_users_length"));
        }

       System.out.println(new Select(element).getOptions().toString());*/

   }

    @When("Librarian click on show records dropdown")
    public void librarian_click_on_show_records_dropdown() {
       /* BrowserUtils.waitForPageToLoad(5);
        LibrarianUsersPage librarianUsersPage = new LibrarianUsersPage();
        librarianUsersPage.closeBtn.click();
        BrowserUtils.waitForPageToLoad(5);
        librarianUsersPage.showRecords.click();*/

    }




}
