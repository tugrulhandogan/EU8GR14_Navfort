package com.navfort.pages;

import com.navfort.utilities.Driver;
import com.navfort.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/*
In this class we will store WebElements common to all pages
 */
public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[1]")
    public WebElement username;

    @FindBy(xpath = "//a[.='Logout']")
    public WebElement logoutButton;

    @FindBy(xpath = "//a[.='My Calendar']")
    public WebElement myCalendarButton;

    @FindBy(xpath = "//a[.='My Configuration']")
    public WebElement myConfigurationButton;

    @FindBy(xpath = "//a[.='Fleet Management']")
    public WebElement fleetManagementButton;


    @FindBy(xpath = "(//span[@class='title title-level-1'])[1]")
    public WebElement fleetModule;

    @FindBy(xpath = "(//span[@class='title title-level-1'])[2]")
    public WebElement customersModule;

    @FindBy(xpath = "(//span[@class='title title-level-1'])[3]")
    public WebElement activitiesModule;

    @FindBy(xpath = "(//span[@class='title title-level-1'])[4]")
    public WebElement systemModule;

    @FindBy(xpath = "(//span[@class='title title-level-2'])[1]")
    public WebElement vehiclesButton;

    @FindBy(xpath = "(//span[@class='title title-level-2'])[2]")
    public WebElement vehicleOdometerButton;

    @FindBy(xpath = "(//span[@class='title title-level-2'])[3]")
    public WebElement vehicleCostsButton;

    @FindBy(xpath = "(//span[@class='title title-level-2'])[4]")
    public WebElement vehicleContractsButton;

    @FindBy(xpath = "(//span[@class='title title-level-2'])[5]")
    public WebElement vehiclesFuelLogsButton;

    @FindBy(xpath = "(//span[@class='title title-level-2'])[6]")
    public WebElement vehicleServicesLogsButton;

    @FindBy(xpath = "(//span[@class='title title-level-2'])[7]")
    public WebElement vehiclesModelButton;

    @FindBy(xpath = "(//span[@class='title title-level-2'])[8]")
    public WebElement contactsButton;

    @FindBy(xpath = "(//span[@class='title title-level-2'])[9]")
    public WebElement calendarEventsButton;

    @FindBy(xpath = "(//span[@class='title title-level-2'])[10]")
    public WebElement jobsButton;

    @FindBy(xpath = "(//span[@class='title title-level-2'])[11]")
    public WebElement menusButton;

    @FindBy(xpath = "(//span[@class='title title-level-2'])[12]")
    public WebElement systemCalendarsButton;

    @FindBy(xpath = "//i[@class='fa-share-square']")
    public WebElement shortcutsButton;

    public WebElement findModule(String moduleName) {

        List<WebElement> modules = Driver.getDriver().findElements(By.xpath("//span[@class='title title-level-1']"));

        WebElement baseModule = null;
        for (WebElement module : modules) {
            if (module.getAttribute("innerText").equalsIgnoreCase(moduleName)) {
                baseModule = module;
            }
        }
        return baseModule;
    }

    public WebElement findButton(String buttonName) {

        List<WebElement> modules = Driver.getDriver().findElements(By.xpath("//span[@class='title title-level-2']"));

        WebElement baseButton = null;
        for (WebElement module : modules) {
            if (module.getAttribute("innerText").equalsIgnoreCase(buttonName)) {
                baseButton = module;
            }
        }
        return baseButton;
    }



}

