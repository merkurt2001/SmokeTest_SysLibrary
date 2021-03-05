package com.SysLibrary.step_definitions;

import com.SysLibrary.pages.*;
import com.SysLibrary.utilities.*;
import com.github.javafaker.*;
import io.cucumber.java.en.*;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.util.*;

public class AddUserStepDefs {

    LibrarianBooksPage librarianBooksPage = new LibrarianBooksPage();
    LibrarianUsersPage librarianUsersPage = new LibrarianUsersPage();
    Faker faker = new Faker();

    @Then("Librarian is on the add user page")
    public void librarian_is_on_the_add_user_page() {

        BrowserUtils.waitForPageToLoad(10);
        librarianUsersPage.usersButton.click();
        BrowserUtils.waitFor(1);
        librarianBooksPage.addUser.click();
        BrowserUtils.waitFor(2);
        String actualText = librarianUsersPage.addUserTitle.getText();
        Assert.assertEquals("Add user page cannot be opened", "Add User", actualText);
    }

    @When("Librarian will enter valid information for a new user")
    public void librarian_will_enter_valid_information_for_a_new_user() {


        BrowserUtils.waitForPageToLoad(5);

        librarianUsersPage.addUserFullName.clear();
        librarianUsersPage.addUserFullName.sendKeys(faker.name().fullName());
        librarianUsersPage.addUserPassword.clear();
        librarianUsersPage.addUserPassword.sendKeys(String.valueOf(faker.number().numberBetween(1, 9)));
        librarianUsersPage.addUserEmail.clear();
        librarianUsersPage.addUserEmail.sendKeys(faker.internet().emailAddress());
        librarianUsersPage.addUserUserGroup.click();
        librarianUsersPage.addUserGroupSelection("Librarian");
        librarianUsersPage.addUserStatus.click();
        librarianUsersPage.addUserStatusSelection("INACTIVE");
        librarianUsersPage.addUserStartDate.clear();
        librarianUsersPage.addUserStartDate.sendKeys("2020-01-01",Keys.ENTER);
        librarianUsersPage.addUserEndDate.clear();
        librarianUsersPage.addUserEndDate.sendKeys("2021-03-05",Keys.TAB);
        librarianUsersPage.addUserAddress.clear();
        librarianUsersPage.addUserAddress.sendKeys(faker.address().fullAddress());
        BrowserUtils.waitFor(3);

        }

    @When("Librarian will click on Save Changes button")
    public void librarian_will_click_on_Save_Changes_button() {

       try {
           librarianUsersPage.addUserSaveChanges.click();
           BrowserUtils.waitFor(2);
       }catch (Exception e){
           throw new WebDriverException("email may be repetitive");
       }

    }

    @Then("{string} message should be displayed")
    public void message_should_be_displayed(String string) {
        Assert.assertTrue(librarianUsersPage.addUserCreatedMessage.isDisplayed());
    }


    @Given("Add User should have following parameters")
    public void add_User_should_have_following_parameters(List<String> expectedsubTitles) {

        System.out.println(expectedsubTitles);
        System.out.println(librarianUsersPage.addUserSubTitles());
        Assert.assertEquals("Add User Subtitles are existing",expectedsubTitles,librarianUsersPage.addUserSubTitles());
    }

    @Then("Following categories should be present under User Group")
    public void following_categories_should_be_present_under_User_Group(List<String> expectedUserGroupTitles) {

        System.out.println(librarianUsersPage.actualUserGroupTitle());
        System.out.println(expectedUserGroupTitles);
        Assert.assertEquals("User Group Titles are existing",expectedUserGroupTitles,librarianUsersPage.actualUserGroupTitle());
    }


    @Then("Status dropdown should have the following options:{}")
    public void status_dropdown_should_have_the_following_options (String options) {

        List<String> actualList = BrowserUtils.getElementsText(new Select(librarianUsersPage.addUserStatus).getOptions());

        List<String> expectedList = BrowserUtils.getCommaList(options);

        Assert.assertEquals(actualList, expectedList);

        System.out.println(actualList);
        System.out.println(expectedList);
    }

    @When("the user enters {string}{string}{string}{string}{string}{string}{string}{string} information")
    public void the_user_enters_information(String FullName, String Password, String Email, String UserGroup,
                                            String Status, String StartDate, String EndDate, String Address) {
        librarianUsersPage.addUserFullName.clear();
        librarianUsersPage.addUserFullName.sendKeys(FullName);
        librarianUsersPage.addUserPassword.clear();
        librarianUsersPage.addUserPassword.sendKeys(Password);
        librarianUsersPage.addUserEmail.clear();
        librarianUsersPage.addUserEmail.sendKeys(Email);
        librarianUsersPage.addUserUserGroup.click();
        librarianUsersPage.addUserGroupSelection(UserGroup);
        librarianUsersPage.addUserStatus.click();
        librarianUsersPage.addUserStatusSelection(Status);
        librarianUsersPage.addUserStartDate.clear();
        librarianUsersPage.addUserStartDate.sendKeys(StartDate,Keys.ENTER);
        librarianUsersPage.addUserEndDate.clear();
        librarianUsersPage.addUserEndDate.sendKeys(EndDate,Keys.TAB);
        librarianUsersPage.addUserAddress.clear();
        librarianUsersPage.addUserAddress.sendKeys(Address);
        librarianUsersPage.addUserSaveChanges.click();
        BrowserUtils.waitFor(2);
    }

    @Then("{string} message should be displayed under Full Name, Password or Email")
    public void message_should_be_displayed_under_Full_Name_Password_or_Email(String expectedText) {
       String text1=librarianUsersPage.fullNameError.getText();
       String text2=librarianUsersPage.passwordError.getText();
       String text3=librarianUsersPage.emailError.getText();

       Assert.assertTrue(expectedText.equals(text1)||expectedText.equals(text2)||expectedText.equals(text3));
    }

    @When("Librarian will enter following valid information for a new user")
    public void librarian_will_enter_following_valid_information_for_a_new_user(Map<String,String> validInfo) {
        librarianUsersPage.addUserFullName.clear();
        librarianUsersPage.addUserFullName.sendKeys(validInfo.get("Full Name"));
        librarianUsersPage.addUserPassword.clear();
        librarianUsersPage.addUserPassword.sendKeys(validInfo.get("Password"));
        librarianUsersPage.addUserEmail.clear();
        librarianUsersPage.addUserEmail.sendKeys(validInfo.get("Email"));
        librarianUsersPage.addUserUserGroup.click();
        librarianUsersPage.addUserGroupSelection(validInfo.get("User Group"));
        librarianUsersPage.addUserStatus.click();
        librarianUsersPage.addUserStatusSelection(validInfo.get("Status"));
        librarianUsersPage.addUserStartDate.clear();
        librarianUsersPage.addUserStartDate.sendKeys(validInfo.get("Start Date"),Keys.ENTER);
        librarianUsersPage.addUserEndDate.clear();
        librarianUsersPage.addUserEndDate.sendKeys(validInfo.get("End Date"),Keys.TAB);
        librarianUsersPage.addUserAddress.clear();
        librarianUsersPage.addUserAddress.sendKeys(validInfo.get("Address"));

        BrowserUtils.waitFor(3);
    }

    @When("The user enter the {string} to the search box on the Users Page")
    public void the_user_enter_the_to_the_search_box_on_the_Users_Page(String string) {

        librarianBooksPage.searchBox.sendKeys(string,Keys.ENTER);
        BrowserUtils.waitFor(3);
    }

    @When("{string} information should be seen in the Users List")
    public void information_should_be_seen_in_the_Users_List(String string) {

        List<WebElement> listTable=new ArrayList<>();
        List<WebElement> emailTable=new ArrayList<>();
        if(!Driver.get().findElement(By.xpath("//tbody/tr/td[1]")).isEnabled()){
            throw new WebDriverException("no results");
        }
        do{
            listTable=Driver.get().findElements(By.xpath("//tbody/tr/td[3]"));
            emailTable=Driver.get().findElements(By.xpath("//tbody/tr/td[4]"));
            List<String> nameList=BrowserUtils.getElementsText(listTable);
            List<String> emailList=BrowserUtils.getElementsText(emailTable);
            for (int i=1; i<nameList.size(); i++){
                Assert.assertTrue(nameList.get(i).toLowerCase().contains(string.toLowerCase()) || emailList.get(i).toLowerCase().contains(string.toLowerCase()));
            }
            try{
                librarianUsersPage.nextBtn.click();
                BrowserUtils.waitFor(1);
            }catch (Exception e){
                throw new WebDriverException("next is disabled");
            }
        }while (!librarianUsersPage.nextBtn.getAttribute("class").contains("disabled"));

        Driver.get().navigate().refresh();
        BrowserUtils.waitFor(2);
        librarianUsersPage.firstRowEditUser.click();
        BrowserUtils.waitFor(2);
        librarianUsersPage.addUserEmail.clear();
        BrowserUtils.waitFor(1);
        librarianUsersPage.addUserEmail.sendKeys(faker.internet().emailAddress());
        BrowserUtils.waitFor(3);
        librarianUsersPage.addUserSaveChanges.click();
        BrowserUtils.waitFor(2);
        Driver.get().navigate().refresh();
        BrowserUtils.waitFor(2);

    }

    @When("Librarian will enter {string} for Start Date and {string} for End Date while other info are valid")
    public void librarian_will_enter_for_Start_Date_and_for_End_Date_while_other_info_are_valid(String startDate, String endDate) {
        librarianUsersPage.addUserFullName.clear();
        librarianUsersPage.addUserFullName.sendKeys(faker.name().fullName());
        librarianUsersPage.addUserPassword.clear();
        librarianUsersPage.addUserPassword.sendKeys(String.valueOf(faker.number().numberBetween(1, 9)));
        librarianUsersPage.addUserEmail.clear();
        librarianUsersPage.addUserEmail.sendKeys(faker.internet().emailAddress());
        librarianUsersPage.addUserUserGroup.click();
        librarianUsersPage.addUserGroupSelection("Librarian");
        librarianUsersPage.addUserStatus.click();
        librarianUsersPage.addUserStatusSelection("INACTIVE");
        librarianUsersPage.addUserStartDate.clear();
        librarianUsersPage.addUserStartDate.sendKeys(startDate,Keys.ENTER);
        librarianUsersPage.addUserEndDate.clear();
        librarianUsersPage.addUserEndDate.sendKeys(endDate,Keys.TAB);
        librarianUsersPage.addUserAddress.clear();
    }

    @Then("{string} message should not be displayed")
    public void message_should_not_be_displayed(String string) {
        Assert.assertFalse(librarianUsersPage.addUserCreatedMessage.isDisplayed());
    }


}
