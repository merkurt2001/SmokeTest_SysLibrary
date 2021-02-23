package com.SysLibrary.pages;

import com.SysLibrary.utilities.BrowserUtils;
import com.SysLibrary.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class UsersPage extends BasePage{

    @FindBy(css =".btn.btn-lg.btn-outline.btn-primary.btn-sm")
    public WebElement addBooksButton;

    @FindBy(css ="[name='full_name']")
    public WebElement userName;

    @FindBy(css ="[name='password']")
    public WebElement password;

    @FindBy(css ="[name='email']")
    public WebElement email;

    @FindBy(id = "user_group_id")
    public WebElement userGroupId;

    @FindBy(id = "status")
    public WebElement status;

    @FindBy(id = "user_groups")
    public WebElement UserGroupMainPage;

    @FindBy(id = "user_status")
    public WebElement statusMainPage;

    @FindBy(name = "tbl_users_length")
    public WebElement records;

    @FindBy(id = "start_date")
    public WebElement startDate;

    @FindBy(id = "end_date")
    public WebElement endDate;

    @FindBy(id = "address")
    public WebElement address;

    @FindBy(css = "[type='submit']")
    public WebElement submit;

    @FindBy(css = "[type='search']")
    public WebElement seachBox;

    @FindBy(css =".toast-message")
    public WebElement saveMessage;

    @FindBy(xpath = "//tbody/tr[1]/td[1]")
    public WebElement editUser;




//    this code bloc select user group at ADD USER funcionality according user entrance
    public void selectUserGroupAdd (String selection){
        Select userList = new Select(userGroupId);
        userList.selectByVisibleText(selection);
    }

//    this code bloc select status ADD USER funcionality according user entrance
    public void selectStatusAdd (String selection){
        Select chooseStatus = new Select(status);
        chooseStatus.selectByVisibleText(selection);
    }
//    this code bloc select user group at UserPage according user entrance
    public void selectUserGroupMain (String selection){
        Select userList = new Select(UserGroupMainPage);
        userList.selectByVisibleText(selection);
    }
//       this code bloc select status at UserPage according user entrance

    public void selectStatusMain (String selection){
        Select chooseStatus = new Select(statusMainPage);
        chooseStatus.selectByVisibleText(selection);
    }

//    this code bloc select record at UserPage according user entrance
    public void selectRecord (String selection){
        Select chooseRecord = new Select(records);
        chooseRecord.selectByVisibleText(selection);
    }
//  This code blok returns the list of user group at ADD USER functionality
    public List<String> userGroupList(){
        WebElement dropdownElement = Driver.get().findElement(By.id("user_group_id"));
        Select showRecordsDropdown = new Select(dropdownElement);

        List<WebElement> options = showRecordsDropdown.getOptions();

        List<String> actualList = BrowserUtils.getElementsText(options);

        return actualList;
    }

//    This code blok returns the list of status at ADD USER functionality
    public List<String> statusList(){
        WebElement dropdownElement = Driver.get().findElement(By.id("status"));
        Select showRecordsDropdown = new Select(dropdownElement);

        List<WebElement> options = showRecordsDropdown.getOptions();

        List<String> actualList = BrowserUtils.getElementsText(options);

        return actualList;
    }

//    This code blok returns the list of FIELDS in ADD USER functionality
    public List<String> addUserFieldsList(){

        List<WebElement> fields = Driver.get().findElements(By.xpath("(//*[@class='form-body'])[1]//label"));
        List<String> actualList = BrowserUtils.getElementsText(fields);

        return actualList;
    }


}