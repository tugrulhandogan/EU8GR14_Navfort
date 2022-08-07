package com.navfort.pages;

import com.navfort.utilities.BrowserUtils;
import com.navfort.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class Vehicles_Page {

    public Vehicles_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//tr[@class='grid-row row-click-action'][5]")
    private WebElement anyRow;

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

    //------Annzir-------located elements for Delete Button  start !!-------------

    @FindBy(xpath = "(//div[@class='dropdown']//*[text()='...'])[5]")
    private WebElement threeDots;

    @FindBy(xpath = "//a[@title='Delete'])[2]")
    public WebElement deleteButton;

    @FindBy(xpath = "//div[@h3='Delete Confirmation']")
    public WebElement deleteMessage;

    @FindBy(xpath = "//a[class='btn ok btn-danger']")
    public WebElement comfirmDelete;

    @FindBy(xpath = "//div[@class='flash-messages-holder']")
    public WebElement itemDeletedMessage;

    public void hoverOverThreeDots(){
        Actions actions = new Actions(Driver.getDriver());
        //web element receives the mouse event in second attempt
        //we try twice
        try {
            for (int i = 0; i < 2; i++) {
                actions.moveToElement(threeDots).pause(100).build().perform();
                BrowserUtils.waitFor(2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void clickAnyRow() {
        //click any row with actions class
        BrowserUtils.clickWithMouseHoverAction(anyRow);

        //regular click method sometimes doesn't work
        //it works when we click twice
//		for (int i = 0; i < 2; i++) {
//			try {
//				BrowserUtils.waitClickability(anyRow, 2);
//				anyRow.click();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}

    }

//-------------Annzir-----located elements fro delete button finish!!----------------

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

    public void fillFilterInputs(String str1, String str2) {
        filterValueFirstInput.sendKeys(str1);
        filterValueSecondInput.sendKeys(str2);
        // updateButton.click();
    }


    public void fillFilterInputs(Integer int1) {
        filterValueFirstInput.sendKeys("" + int1);
        updateButton.click();
    }

    public void fillFilterInputs(String str) {
        filterValueFirstInput.sendKeys("" + str);
        // updateButton.click();
    }

    /**
     * This method provide us to get list of values of the webElements
     *
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
