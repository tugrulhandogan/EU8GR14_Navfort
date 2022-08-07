package com.navfort.pages;

import com.navfort.utilities.BrowserUtils;
import com.navfort.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GeneralInformationPage {

    public GeneralInformationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//td[@class='string-cell grid-cell grid-body-cell grid-body-cell-LicensePlate'][1]")
    public WebElement generalInfoRow;

    @FindBy(xpath = "//a[@title='Delete Car']")
    public WebElement deleteButtonGenePage;

    @FindBy(xpath = "//a[@class='btn ok btn-danger']")
    public WebElement deleteConfirmBtn;

    @FindBy(xpath = "//div[@class='flash-messages-holder']")
    public WebElement itemDeleteMessage;

    @FindBy(css = "div.items.list-box.list-shaped div.list-item strong")
    private List<WebElement> allEvents;

    @FindBy(xpath = "//span[text()='General Information']")
    private WebElement generalInfoPage;

    @FindBy(css = "div.control-label")
    private List<WebElement> allCarInfo;


    public void clickAnyBtn(String btnName) {
        WebElement btn = Driver.getDriver().findElement(By.xpath("//*[text()[normalize-space() = '" + btnName + "']]"));
        BrowserUtils.clickWithWait((By) btn, 2);
    }

    public void isEventsDisplayed() {
        //just in case there is no any event
        //we use try-catch clock
        try {
            if (allEvents.size() == 0) {
                System.out.println("There is no event");
            } else {

                for (int i = 0; i < allEvents.size(); i++) {
                    BrowserUtils.waitFor(2);
                    System.out.println("Event: " + allEvents.get(i).getText());
                    Assert.assertTrue(allEvents.get(i).isDisplayed());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean getPageName(){
        BrowserUtils.waitForVisibility(generalInfoPage,2);
        Assert.assertTrue(generalInfoPage.isDisplayed());
        return false;
    }

    public void isVisibleEditDeleteAddEvent(String btn1, String btn2, String btn3){
        WebElement btn1WE = Driver.getDriver().findElement(By.xpath("//*[normalize-space(text()) = '"+btn1+"']"));
        WebElement btn2WE = Driver.getDriver().findElement(By.xpath("//*[normalize-space(text()) = '"+btn2+"']"));
        WebElement btn3WE = Driver.getDriver().findElement(By.xpath("//*[normalize-space(text()) = '"+btn3+"']"));
        BrowserUtils.waitFor(2);

        Assert.assertTrue(btn1WE.isDisplayed());
        Assert.assertTrue(btn2WE.isDisplayed());
        Assert.assertTrue(btn3WE.isDisplayed());
    }

    public void isNotVisibleEditDeleteAddEvent(String btn1, String btn2, String btn3){
        WebElement btn1WE = Driver.getDriver().findElement(By.xpath("//*[normalize-space(text()) = '"+btn1+"']"));
        WebElement btn2WE = Driver.getDriver().findElement(By.xpath("//*[normalize-space(text()) = '"+btn2+"']"));
        WebElement btn3WE = Driver.getDriver().findElement(By.xpath("//*[normalize-space(text()) = '"+btn3+"']"));
        BrowserUtils.waitFor(2);

        Assert.assertFalse(btn1WE.isDisplayed());
        Assert.assertFalse(btn2WE.isDisplayed());
        Assert.assertFalse(btn3WE.isDisplayed());
    }

    public List<String> getCarInfoFromGeneralInfo(){
        List<WebElement> allCarInfoWE = this.allCarInfo;
        List<String> allCarInfoString = new ArrayList<>();
        BrowserUtils.waitForVisibility(generalInfoPage,2);

        //don't include the last three value cause they are irrelevant
        for (int i = 0; i < allCarInfoWE.size()-3; i++) {
            if (allCarInfoWE.get(i).getText().contains(",")) {
                allCarInfoString.add(allCarInfoWE.get(i).getText().replace(",",""));
                continue;
            }
            allCarInfoString.add(allCarInfoWE.get(i).getText());
        }

        return allCarInfoString;
    }


}

