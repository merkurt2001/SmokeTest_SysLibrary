package com.SysLibrary.pages;

import com.SysLibrary.utilities.BrowserUtils;
import com.SysLibrary.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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
    public WebElement selectBookMain;


// this code bloc select book at the librarian books page according to user enterance
    public void selectBook (String selection){
        Select bookList = new Select(selectBookMain);
        bookList.selectByVisibleText(selection);
    }
//    this code bloc select record type (5, 10..) at the librarian books page according to user enterance

    public void selectRecord (String selection){
        Select chooseRecord = new Select(recordsDropdown);
        chooseRecord.selectByVisibleText(selection);
    }
//     this code bloc returns list of records dropdown at the librarian books page
    public List<String> recordList(){

        Select showRecordsDropdown = new Select(recordsDropdown);

        List<WebElement> options = showRecordsDropdown.getOptions();

        List<String> actualList = BrowserUtils.getElementsText(options);

        return actualList;
    }
//         this code bloc returns list of books at the librarian books MAIN page

    public List<String> bookList(){

        Select showRecordsDropdown = new Select(selectBookMain);

        List<WebElement> options = showRecordsDropdown.getOptions();

        List<String> actualList = BrowserUtils.getElementsText(options);

        return actualList;
    }

//    this code bloc returns list of books at the ADD book Functionality
    public List<String> bookListAdd(){

        Select showRecordsDropdown = new Select(bookCategory);

        List<WebElement> options = showRecordsDropdown.getOptions();

        List<String> actualList = BrowserUtils.getElementsText(options);

        return actualList;
    }

//    This code blok returns the list of FIELDS in ADD BOOKS functionality
    public List<String> addBooksFieldsList(){

        List<WebElement> fields = Driver.get().findElements(By.xpath("//*[@class='form-body']//label"));
        List<String> actualList = BrowserUtils.getElementsText(fields);

        return actualList;
    }

}
