package com.navfort.pages;

import com.navfort.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class Vehicles_Page {

    public Vehicles_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "[class=add-filter-button]")
    public WebElement manageFiltersButton;

    @FindBy(xpath= "//input[@value='LastOdometer']")
    public WebElement lastOdometerCheckBox;

    @FindBy(css = "[class='btn dropdown-toggle']")
    public WebElement lastOdometerMethodsDropdown;

    @FindBy(xpath = "//div[@class='btn filter-criteria-selector oro-drop-opener oro-dropdown-toggle filter-default-value']")
    public WebElement lastOdometerFilterButton;

    @FindBy(css="[title=Filters]")
    public WebElement filtersButton;

    public List<String> getLastOdometerMethods() {

        List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//a[@class='dropdown-item choice-value']"));

        List<String> textOfElements = new ArrayList<>();

        for (WebElement element : elements) {
            textOfElements.add(element.getText());
        }
        return textOfElements;
    }
}
