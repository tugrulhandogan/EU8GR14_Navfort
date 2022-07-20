package com.navfort.step_definitions;

import com.navfort.pages.BasePage;
import com.navfort.pages.LoginPage;
import com.navfort.pages.Vehicles_Page;
import com.navfort.utilities.BrowserUtils;
import com.navfort.utilities.ConfigurationReader;
import com.navfort.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;
public class LastOdometer_StepDefs {

    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    Vehicles_Page vehicles_page = new Vehicles_Page();

    @Given("{string} is logged in to the application and is on the Fleet-Vehicles page")
    public void is_logged_in_to_the_application_and_is_on_the_page(String userType) {

        Driver.getDriver().get(ConfigurationReader.getProperty("loginPage"));
        if (userType.equalsIgnoreCase("driver")) {
            loginPage.login(ConfigurationReader.getProperty("driverUsername"), ConfigurationReader.getProperty("password"));
        } else if (userType.equalsIgnoreCase("salesmanager")) {
            loginPage.login(ConfigurationReader.getProperty("salesManagerUsername"), ConfigurationReader.getProperty("password"));
        } else if (userType.equalsIgnoreCase("storemanager")) {
            loginPage.login(ConfigurationReader.getProperty("storeManagerUsername"), ConfigurationReader.getProperty("password"));
        }
        basePage.waitUntilLoaderScreenDisappear();

        basePage.findModule("Fleet").click();
        basePage.findButton("Vehicles").click();

        basePage.waitUntilLoaderScreenDisappear();

    }


    @When("User clicks on {string} filter button")
    public void user_clicks_on_filter_button(String filterButton) {

        vehicles_page.filtersButton.click();
        vehicles_page.manageFiltersButton.click();
    }

    @Then("user should be able to click the {string} filter")
    public void user_should_be_able_to_click_the_filter(String checkBox) {

        BrowserUtils.waitForClickablility(vehicles_page.lastOdometerCheckBox, 5);
        vehicles_page.lastOdometerCheckBox.click();
        assertTrue(vehicles_page.lastOdometerCheckBox.isSelected());

    }

}
