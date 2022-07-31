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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class GridSettings_StepsDefs {

    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    Vehicles_Page vehicles_page = new Vehicles_Page();

    GridSetting gridSetting = new GridSetting();

    Actions actions = new Actions(Driver.getDriver());






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
        basePage.waitUntilLoaderScreenDisappear();
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

    @When("user deselect all the selected items")
    public void user_deselect_all_the_selected_items() {
        for (WebElement eachItem : gridSetting.gridSettingItems) {
            eachItem.click();
        }
    }
    @And("user clicks {string}")
    public void user_clicks(String columnName) {
        for (WebElement eachItem : gridSetting.gridSettingItems) {
            if (eachItem.getText().equals(columnName)){
                eachItem.click();
            }
        }

    }



    @When("user drag fifth item to the top")
    public void userDragFifthItemToTheTop() {
        actions.clickAndHold(gridSetting.fifthItemSort)
                .pause(1000)
                .moveToElement(gridSetting.firstItemSort)
                .pause(1000)
                .release()
                .perform();

    }

    @Then("user see the item in first of the list")
    public void userSeeTheItemInFirstOfTheList() {
        String actualFirstItemText = gridSetting.firstItemName.getText();
        Assert.assertEquals("Location",actualFirstItemText);
        System.out.println("actualFirstItemText = " + actualFirstItemText);
    }

    @And("user drag sixth item to the bottom")
    public void userDragSixthItemToTheBottom() {

        actions.clickAndHold(gridSetting.sixthItemSort)
                .pause(1000)
                .moveToElement(gridSetting.lastItemSort)
                .pause(1000)
                .release()
                .perform();
    }

    @Then("user see the item in the last of the list")
    public void userSeeTheItemInTheLastOfTheList() {
        List<String> actualList = gridSetting.getGridTableName();
        String actualLastItemText = actualList.get(19);
        System.out.println("actualLastItemText = " + actualLastItemText);
        Assert.assertEquals("Chassis Number",actualLastItemText);

    }


    @Then("user see Location is the first column at Fleet-Vehicles page")
    public void user_see_location_is_the_first_column_at_fleet_vehicles_page() {
        String actualFirstColumName = gridSetting.getColumnName().get(0);
        Assert.assertEquals("LOCATION",actualFirstColumName);

    }

    @And("user drag the item to the bottom")
    public void user_drag_the_item_to_the_bottom() {
        actions.clickAndHold(gridSetting.firstItemSort)
                .pause(1000)
                .moveToElement(gridSetting.lastItemSort)
                .pause(1000)
                .release()
                .perform();
    }
    @Then("user see Location is the last column at Fleet-Vehicles page")
    public void user_see_location_is_the_last_column_at_fleet_vehicles_page() {
        String actualLastColumn = gridSetting.getColumnName().get(18);
        Assert.assertEquals("LOCATION",actualLastColumn);
    }


    @When("user search {string} on Quick Search input box start with two white spaces")
    public void user_search_on_quick_search_input_box_start_with_two_white_spaces(String itemName) {
       gridSetting.QuickSearchBox.sendKeys(itemName);
    }
    @Then("Location should be displayed in result")
    public void location_should_be_displayed_in_result() {
        Assert.assertTrue(gridSetting.fifthItemSort.isDisplayed());
    }


}
