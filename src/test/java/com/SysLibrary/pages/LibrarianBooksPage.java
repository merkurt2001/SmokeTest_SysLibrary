package com.SysLibrary.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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
    public WebElement recordsDropdown;

    @FindBy(css = "[type='search']")
    public WebElement searchBox;

    @FindBy(id = "book_categories")
    public WebElement selectBook;



    public void selectBook (String selection){
        Select bookList = new Select(selectBook);
        bookList.selectByVisibleText(selection);
    }

    public void selectRecord (String selection){
        Select chooseRecord = new Select(recordsDropdown);
        chooseRecord.selectByVisibleText(selection);
    }
}
