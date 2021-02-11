package com.SysLibrary.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(id = "start_date")
    public WebElement startDate;

    @FindBy(id = "end_date")
    public WebElement endDate;

    @FindBy(id = "address")
    public WebElement address;

    @FindBy(css = "[type='submit']")
    public WebElement submit;
}