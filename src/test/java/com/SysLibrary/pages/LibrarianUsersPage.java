package com.SysLibrary.pages;

import com.SysLibrary.utilities.*;
import com.SysLibrary.utilities.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.sql.*;
import java.util.*;

public class LibrarianUsersPage extends BasePage {


    @FindBy(xpath = "//*[@id='add_user_modal']/div/h5")
    public WebElement addUserTitle;

    @FindBy(xpath = "//input[@name='full_name']")
    public WebElement addUserFullName;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement addUserPassword;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement addUserEmail;

    @FindBy(id = "user_group_id")
    public WebElement addUserUserGroup;

    @FindBy(xpath = "//select[@name='status']")
    public WebElement addUserStatus;

    @FindBy(xpath = "//input[@name='start_date']")
    public WebElement addUserStartDate;

    @FindBy(xpath = "//input[@name='end_date']")
    public WebElement addUserEndDate;

    @FindBy(id = "address")
    public WebElement addUserAddress;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement addUserSaveChanges;

    @FindBy(css = ".toast-message")
    public WebElement addUserCreatedMessage;

    @FindBy(id = "full_name-error")
    public WebElement fullNameError;

    @FindBy(id = "email-error")
    public WebElement emailError;

    @FindBy(id = "password-error")
    public WebElement passwordError;

    @FindBy(xpath = "//*[@class='fa fa-angle-right']/../..")
    public WebElement nextBtn;


    @FindBy(css = ".btn.default")
    public WebElement closeBtn;

    @FindBy(xpath = "//tbody/tr/td[1]")
    public WebElement firstRowEditUser;


    // with this method you can select Librarian and Student by writing as String

    public void addUserGroupSelection(String str) {
        new Select(addUserUserGroup).selectByVisibleText(str);
    }

    // with this method you can select ACTIVE and INACTIVE by writing as String

    public void addUserStatusSelection(String str) {
        new Select(addUserStatus).selectByVisibleText(str);
    }

    // with this method you can retrieve the subtitle names of Add User Page

    public List<String> addUserSubTitles() {
        List<String> addUsersSubTitles = BrowserUtils.getElementsText(Driver.get().findElements(By.xpath("//*[@id='add_user_form']//label")));
        return addUsersSubTitles;
    }

    public List<String> actualUserGroupTitle() {

        Select select = new Select(addUserUserGroup);
        List<WebElement> options = select.getOptions();

        List<String> actualUserGroupSubtitles = new ArrayList<>();

        for (WebElement s : options) {
            actualUserGroupSubtitles.add(s.getText());
        }

        return actualUserGroupSubtitles;

    }
}
