package com.navfort.step_definitions;

import com.navfort.pages.BasePage;
import com.navfort.pages.GridSetting;
import com.navfort.pages.LoginPage;
import com.navfort.pages.Vehicles_Page;
import com.navfort.utilities.BrowserUtils;
import com.navfort.utilities.ConfigurationReader;
import com.navfort.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GridSettings_StepsDefs {

    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    Vehicles_Page vehicles_page = new Vehicles_Page();

    GridSetting gridSetting = new GridSetting();




    @Given("user logged on as {string} and clicks {string} module and {string} tab")
    public void userLoggedOnAsAndClicksModuleAndTab(String userType, String module, String tab) {
        Driver.getDriver().get(ConfigurationReader.getProperty("loginPage"));

        if (userType.equalsIgnoreCase("driver")) {
            loginPage.login(ConfigurationReader.getProperty("driverUsername"), ConfigurationReader.getProperty("password"));
        } else if (userType.equalsIgnoreCase("salesmanager")) {
            loginPage.login(ConfigurationReader.getProperty("salesManagerUsername"), ConfigurationReader.getProperty("password"));
        } else if (userType.equalsIgnoreCase("storemanager")) {
            loginPage.login(ConfigurationReader.getProperty("storeManagerUsername"), ConfigurationReader.getProperty("password"));
        }
        basePage.waitUntilLoaderScreenDisappear();

        basePage.findModule(module).click();
        basePage.findButton(tab).click();
    }

    @And("clicks on the gear icon")
    public void clicksOnTheGearIcon() {
        gridSetting.GridSettingsButton.click();
        BrowserUtils.waitForVisibility(gridSetting.GridSettingsButton,10);
    }

    @Then("user see Grid Settings panel")
    public void user_see_grid_settings_panel() {
        Assert.assertTrue(gridSetting.GridSettingTitle.isDisplayed());
    }

    @Then("user see Column names in grid settings panel as expected")
    public void userSeeColumnNamesInGridSettingsPanelAsExpected(List<String> expectedItem) {

        List<String> actualItemNames = gridSetting.getGridTableName();

        Assert.assertEquals(expectedItem,actualItemNames);

    }


    @When("user typing {string} on Quick Search input box")
    public void user_typing_on_quick_search_input_box(String columnName) {
        gridSetting.QuickSearchBox.sendKeys(columnName);
    }
    @Then("user see {string} on result")
    public void user_see_on_result(String columnName) {


        for (WebElement gridSettingItem : gridSetting.gridSettingItems) {
            if (gridSettingItem.getText().equals(columnName)){
                Assert.assertTrue(gridSettingItem.isDisplayed());
            }
        }
    }



    @When("user typing invalid {string} on Quick Search input box")
    public void user_typing_invalid_on_quick_search_input_box(String columnName) {
        gridSetting.QuickSearchBox.sendKeys(columnName);
    }
    @Then("user can't see {string} on result")
    public void user_can_t_see_on_result(String columnName) {
        for (WebElement gridSettingItem : gridSetting.gridSettingItems) {
            Assert.assertFalse(gridSettingItem.isDisplayed());
        }
    }


}
