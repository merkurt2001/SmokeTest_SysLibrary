package com.SysLibrary.pages;

import com.SysLibrary.utilities.BrowserUtils;
import com.SysLibrary.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {


    @FindBy(xpath = "//*[@id='menu_item']/li[1]")
    public WebElement dashboardButton;

    @FindBy(xpath = "//*[@id='menu_item']/li[2]")
    public WebElement usersButton;

    @FindBy(xpath = "//*[@id='menu_item']/li[3]")
    public WebElement booksButton;


    @FindBy(xpath = "//span[contains(.,'Test')]")
    public WebElement userName;

    @FindBy(css =".dropdown-item")
    public WebElement logOutLink;

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }


    public String getUserName(){
        BrowserUtils.waitForVisibility(userName, 5);
        return userName.getText();
    }


    public void logOut(){
        BrowserUtils.waitFor(1);
        BrowserUtils.clickWithJS(userName);
        BrowserUtils.clickWithJS(logOutLink);
    }


}