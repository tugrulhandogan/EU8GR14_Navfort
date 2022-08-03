package com.navfort.step_definitions;

import com.navfort.pages.FilterMenu_Page;
import com.navfort.pages.LoginPage;
import com.navfort.utilities.BrowserUtils;
import com.navfort.utilities.ConfigurationReader;
import com.navfort.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FilterMenu_Steps {

    LoginPage loginPage = new LoginPage();
    FilterMenu_Page filterMenu_page = new FilterMenu_Page();

    //Pre-Cond
    @Given("The user is on the Fleet Vehicles page")
    public void theUserIsOnTheFleetVehiclesPage() {
        Driver.getDriver().get("https://qa.perfleet.com");
         loginPage.inputUsername.sendKeys(ConfigurationReader.getProperty("driverUsername"));
         loginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("password"));
         loginPage.loginButton.click();

         filterMenu_page.fleetMenuBtn.click();
         BrowserUtils.waitFor(3);
         filterMenu_page.VehicleBtn.click();

    }

    //US- 1
    @When("user clicks on filter icon")
    public void user_clicks_on_filter_icon() {
        BrowserUtils.waitFor(5);
        filterMenu_page.filterIcon.click();
    }

    @Then("Manage Filter button should be visible")
    public void manage_filter_button_should_be_visible() {
        filterMenu_page.manageFilterBtn.isDisplayed();
    }

    //US- 2
    @When("user clicks on filter button")
    public void userClicksOnFilterButton() {
        BrowserUtils.waitFor(3);
        filterMenu_page.filterIcon.click();
    }

    @And("user clicks on Manage Filters menu")
    public void userClicksOnManageFiltersMenu() {
        filterMenu_page.manageFilterBtn.click();
    }

    @Then("user can apply any of the filters")
    public void userCanApplyAnyOfTheFilters() {
        filterMenu_page.licencePlate.click();
    }

    //US3
    @When("the user clicks on filter menu icon")
    public void theUserClicksOnFilterMenuIcon() {
        BrowserUtils.waitFor(5);
        filterMenu_page.filterIcon.click();
    }
    @And("the user clicks on manage filters icon")
    public void theUserClicksOnManageFiltersIcon() {
        filterMenu_page.manageFilterBtn.click();
    }

    @And("user types a filter name")
    public void userTypesAFilterName() {
        filterMenu_page.filterInput.sendKeys("location");
    }

    @Then("user should be able to select that filter")
    public void userShouldBeAbleToSelectThatFilter() {
        filterMenu_page.location.click();
    }




}
