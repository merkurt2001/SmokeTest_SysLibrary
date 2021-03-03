package com.SysLibrary.pages;

import com.SysLibrary.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class StudentBooksPage extends BasePage{

    @FindBy(id = "book_categories")
    public WebElement selectBookMain;

    @FindBy(name = "tbl_books_length")
    public WebElement recordsDropdown;

    @FindBy(css = "[type='search']")
    public WebElement searchBox;

    @FindBy(xpath = "//tbody/tr[1]/td[1]")
    public WebElement borrowBook;

    @FindBy(css =".toast-message")
    public WebElement saveMessage;

        //deneme


    // this code bloc select book at the student books page according to user enterance
    public void selectBook (String selection){
        Select bookList = new Select(selectBookMain);
        bookList.selectByVisibleText(selection);
    }

    //         this code bloc returns list of books at the student books MAIN page

    public List<String> bookList(){

        Select showRecordsDropdown = new Select(selectBookMain);

        List<WebElement> options = showRecordsDropdown.getOptions();

        List<String> actualList = BrowserUtils.getElementsText(options);

        return actualList;
    }

    //    this code bloc select record type (5, 10..) at the student books page according to user enterance

    public void selectRecord (String selection){
        Select chooseRecord = new Select(recordsDropdown);
        chooseRecord.selectByVisibleText(selection);
    }
    //     this code bloc returns list of records dropdown at the student books page
    public List<String> recordList(){

        Select showRecordsDropdown = new Select(recordsDropdown);

        List<WebElement> options = showRecordsDropdown.getOptions();

        List<String> actualList = BrowserUtils.getElementsText(options);

        return actualList;
    }
}
