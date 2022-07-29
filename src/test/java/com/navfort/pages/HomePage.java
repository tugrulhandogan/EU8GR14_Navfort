package com.navfort.pages;

import com.navfort.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href='javascript: void(0);']")
    public static WebElement userNameBtn;

    @FindBy(xpath = "//a[@href='/user/logout']")
    public WebElement logout;

    @FindBy(xpath = "//span[@class='title title-level-1'][1]")
    public WebElement FleetOption;

    @FindBy(xpath = "//span[@class='title title-level-2'][1]")
    public WebElement VehicleOption;

    @FindBy(xpath = "//div[text()='You do not have permission to perform this action.']")
    public WebElement messageForDriver;



}
