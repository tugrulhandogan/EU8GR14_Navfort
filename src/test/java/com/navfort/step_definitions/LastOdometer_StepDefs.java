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
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LastOdometer_StepDefs {

    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    Vehicles_Page vehicles_page = new Vehicles_Page();

    @Given("{string} is logged in to the application and clicks {string} module and {string} tab")
    public void is_logged_in_to_the_application_and_is_on_the_page(String userType, String module, String tab) {

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


    @When("User clicks on Last Odometer filter checkbox")
    public void user_clicks_on_filter() {
        BrowserUtils.waitForClickablility(vehicles_page.lastOdometerCheckBox, 5);
        vehicles_page.lastOdometerCheckBox.click();
    }

    @Then("User should be able to see the Last Odometer filter options as below list")
    public void user_should_be_able_to_see_the(List<String> expectedMethods) {


        List<String> actualLastOdometerMethods = vehicles_page.getLastOdometerMethods();

        assertEquals(expectedMethods, actualLastOdometerMethods);

    }


    @When("User selects {string} method")
    public void user_selects_method(String method) {
        vehicles_page.getLastOdometerMethod(method).click();

    }

    @When("User enters {int} and {int} in the filter fields")
    public void user_enters_and_in_the_filter_fields(Integer int1, Integer int2) {

        vehicles_page.fillFilterInputs(int1, int2);

        BrowserUtils.waitFor(1);

    }

    @Then("User should be able to see the vehicles with last odometer between {int} and {int}")
    public void user_should_be_able_to_see_the_vehicles_with_last_odometer_between_and(Integer int1, Integer int2) {
        List<WebElement> lastOdometerValuesElements = vehicles_page.lastOdometerValues();

        List<Integer> lastOdometerValues = vehicles_page.getListOfWebElementsValues(lastOdometerValuesElements);

        //  System.out.println("lastOdometerValues = " + lastOdometerValues);

        for (Integer lastOdometerValue : lastOdometerValues) {
            if (lastOdometerValue < int1 || lastOdometerValue > int2) {
                assertTrue(false);
            } else {
                assertTrue(true);
            }
        }
    }

    @Given("User clicks on the Last Odometer button")
    public void user_clicks_on_the_last_odometer_button() {
        BrowserUtils.waitForVisibility(vehicles_page.lastOdometerFilterButton, 5);

        vehicles_page.lastOdometerFilterButton.click();

        vehicles_page.lastOdometerMethodsDropdown.click();
    }

    @When("User enters {int} in the filter field")
    public void user_enters_in_the_filter_field(Integer int1) {
        vehicles_page.fillFilterInputs(int1);
        BrowserUtils.waitFor(1);

    }

    @Then("User should be able to see the vehicles with last odometer equal to {int}")
    public void user_should_be_able_to_see_the_vehicles_with_last_odometer_equal_to(Integer int1) {

        List<Integer> listOfWebElementsValues = vehicles_page.getListOfWebElementsValues(vehicles_page.lastOdometerValues());

        for (Integer value : listOfWebElementsValues) {
            if (!(value.equals(int1))) {
                assertTrue(false);
            } else {
                assertTrue(true);
            }
        }
    }


}
