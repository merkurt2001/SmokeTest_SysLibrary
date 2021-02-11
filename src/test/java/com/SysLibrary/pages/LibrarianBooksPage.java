package com.SysLibrary.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LibrarianBooksPage extends BasePage{

    @FindBy(css =".portlet-title>span>a")
    public WebElement addBooks;

    @FindBy(css ="[name='name']")
    public WebElement bookName;

    @FindBy(css ="[name='isbn']")
    public WebElement bookIsbn;

    @FindBy(css ="[name='year']")
    public WebElement bookYear;

    @FindBy(css ="[placeholder='Author']")
    public WebElement bookAuthor;

    @FindBy(css ="#book_group_id")
    public WebElement bookCategory;

    @FindBy(css ="#description")
    public WebElement bookDescription;

    @FindBy(css ="[type='submit']")
    public WebElement bookSubmit;

    @FindBy(css =".toast-message")
    public WebElement saveMessage;

    @FindBy(name = "tbl_books_length")
    public WebElement showRecordsDropdown;

    @FindBy(css = "[type='search']")
    public WebElement searchBox;
}
