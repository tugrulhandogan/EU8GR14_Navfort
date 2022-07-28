package com.navfort.step_definitions;

import com.navfort.pages.BasePage;
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

public class DeleteButton_SD {

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

    }

    @When("the user hovering over the three dot")
    public void theUserHoveringOverTheThreeDot() {
        BrowserUtils.hover(vehicles_page.threeDotDropDown);
    }

    @Then("The user see the Delete button")
    public void theUserSeeTheDeleteButton() {
        Assert.assertTrue(vehicles_page.deleteButton.isDisplayed());
    }

    @And("the user clicks on the delete button")
    public void theUserClicksOnTheDeleteButton() {
        vehicles_page.deleteButton.click();
    }
}
