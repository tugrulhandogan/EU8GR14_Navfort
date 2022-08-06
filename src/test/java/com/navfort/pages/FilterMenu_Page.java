package com.navfort.pages;

import com.navfort.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilterMenu_Page {
    public FilterMenu_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@class='title title-level-1']")
    public WebElement fleetMenuBtn;

    @FindBy(xpath = "//span[@class='title title-level-2']")
    public WebElement VehicleBtn;

    @FindBy(xpath = "//i[@class='fa-filter hide-text']")
    public WebElement filterMenuBtn;

    @FindBy(xpath = "//a[@class='action btn mode-icon-only']")
    public WebElement filterIcon;

    @FindBy(xpath = "//button[@class='ui-multiselect ui-corner-all select-filter-widget']")
    public WebElement manageFilterBtn;

    @FindBy(id = "ui-multiselect-0-0-option-0")
    public WebElement licencePlate;

    @FindBy(id = "ui-multiselect-0-0-option-3")
    public WebElement location;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement filterInput;

    @FindBy(xpath = "//i[text()=' Reset ']")
    public WebElement resetBtn;
}
