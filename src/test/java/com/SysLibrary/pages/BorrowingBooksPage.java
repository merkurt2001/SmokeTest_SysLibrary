package com.SysLibrary.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BorrowingBooksPage extends BasePage {

    @FindBy(id = "book_categories")
    public WebElement selectBookMain;

    @FindBy(xpath = "//tbody/tr/td[2]")
    public List<WebElement> rows;
}
