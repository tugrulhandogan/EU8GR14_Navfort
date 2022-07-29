package com.navfort.step_definitions;

import com.navfort.pages.BasePage;
import com.navfort.pages.HomePage;
import com.navfort.pages.LoginPage;
import com.navfort.pages.Vehicles_Page;
import com.navfort.utilities.BrowserUtils;
import com.navfort.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DriverDeleteCar_SD {

    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    HomePage homePage = new HomePage();
    Vehicles_Page vehicles_page = new Vehicles_Page();


    @When("Driver on the Quick Lanched page")
    public void driverOnTheQuickLanchedPage() {
        BrowserUtils.waitFor(5);
        homePage.userNameBtn.click();
        BrowserUtils.waitFor(5);
        homePage.logout.click();
        BrowserUtils.waitFor(3);
        loginPage.inputUsername.sendKeys("user1");
        loginPage.inputPassword.sendKeys("UserUser123");
        loginPage.loginButton.click();

    }
    @When("Driver click the Fleet option")
    public void driverClickTheFleetOption() {
        BrowserUtils.waitFor(3);
        BrowserUtils.hover(homePage.FleetOption);
        BrowserUtils.waitFor(3);

    }

    @And("Driver click the Vehicles option")
    public void driverClickTheVehiclesOption() {
        homePage.VehicleOption.click();
        BrowserUtils.waitFor(3);
    }

    @Then("You do not have permission to perform this action message should be displayed")
    public void messageShouldBeDisplayed() {
        Assert.assertTrue(homePage.messageForDriver.isDisplayed());

    }


}
