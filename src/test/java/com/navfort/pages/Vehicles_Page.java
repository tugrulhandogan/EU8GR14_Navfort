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

    @FindBy(xpath = "//input[@value='LastOdometer']")
    public WebElement lastOdometerCheckBox;

    @FindBy(css = "[class='btn dropdown-toggle']")
    public WebElement lastOdometerMethodsDropdown;

    @FindBy(xpath = "//div[@class='btn filter-criteria-selector oro-drop-opener oro-dropdown-toggle filter-default-value']")
    public WebElement lastOdometerFilterButton;

    @FindBy(css = "[title=Filters]")
    public WebElement filtersButton;

    @FindBy(css = "[name=value]")
    public WebElement filterValueFirstInput;

    @FindBy(css = "[name=value_end]")
    public WebElement filterValueSecondInput;

    @FindBy(xpath = "//button[.='Update']")
    public WebElement updateButton;


    public List<String> getLastOdometerMethods() {

        List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//a[@class='dropdown-item choice-value']"));

        List<String> textOfElements = new ArrayList<>();

        for (WebElement element : elements) {
            textOfElements.add(element.getAttribute("innerText"));
        }
        return textOfElements;
    }

    public WebElement getLastOdometerMethod(String method) {
        return Driver.getDriver().findElement(By.xpath("//a[@class='dropdown-item choice-value' and text()='" + method.toLowerCase() + "']"));
    }


    public List<WebElement> lastOdometerValues() {
        return Driver.getDriver().findElements(By.xpath("//td[@data-column-label='Last Odometer']"));
    }

    public void fillFilterInputs(Integer int1, Integer int2) {
        filterValueFirstInput.sendKeys("" + int1);
        filterValueSecondInput.sendKeys("" + int2);
        updateButton.click();
    }


    public void fillFilterInputs(Integer int1) {
        filterValueFirstInput.sendKeys("" + int1);
        updateButton.click();
    }

    /**
     * This method provide us to get list of values of the webElements
     * @param list of WebElement
     * @return list of Integer
     */
    public List<Integer> getListOfWebElementsValues(List<WebElement> list) {
        List<Integer> values = new ArrayList<>();

        for (WebElement webElement : list) {

            String lastOdometerValue = webElement.getText();

            if (lastOdometerValue.contains(",")) {
                lastOdometerValue = lastOdometerValue.replace(",", "");
            } else
                values.add(Integer.parseInt(lastOdometerValue));
        }
        return values;
    }

}
