package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class registrationPage
{
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "firstName")
    private WebElement firstNameText;

    @FindBy(name = "lastName")
    private WebElement lastNameText;

    @FindBy(name = "email")
    private WebElement usernameTxt;

    @FindBy(name = "password")
    private WebElement passwordText;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPasswordtext;


    @FindBy(name = "register")
    private WebElement submitButton;




    public registrationPage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver, this);
    }


    public void goTo()
    {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html#");
        this.wait.until(ExpectedConditions.visibilityOf(this.firstNameText));
    }

    public void enterUserDetails(String firstName, String lastName)
    {
        this.firstNameText.sendKeys(lastName);
        this.firstNameText.sendKeys(lastName);
    }


    public void enterUserCredentials(String email, String password)
    {
        this.usernameTxt.sendKeys(email);
        this.passwordText.sendKeys(password);
        this.confirmPasswordtext.sendKeys(password);
    }

    public void submit()
    {
        this.submitButton.click();
    }


}
