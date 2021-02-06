package com.SysLibrary.pages;

import com.SysLibrary.utilities.ConfigurationReader;
import com.SysLibrary.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }


    @FindBy(id = "inputEmail")
    public WebElement emailInput;

    @FindBy(id = "inputPassword")
    public WebElement passwordInput;


    @FindBy(css = "[type='submit']")
    public WebElement signIn;


    public void signInAsLibrarian(){

        String email = ConfigurationReader.get("Librarian_Email");
        String password = ConfigurationReader.get("Librarian_Password");

        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signIn.click();
    }

    public void signInAsStudent(){

        String email = ConfigurationReader.get("Student_Email");
        String password = ConfigurationReader.get("Student_password");

        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signIn.click();
    }


}
