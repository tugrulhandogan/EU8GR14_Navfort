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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteButton_SD {

    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    Vehicles_Page vehicles_page = new Vehicles_Page();

    @When("the user hovering over the three dot")
    public void theUserHoveringOverTheThreeDot() {
        BrowserUtils.waitForVisibility(vehicles_page.threeDotDropDown,5);
        BrowserUtils.hover(vehicles_page.threeDotDropDown);
        BrowserUtils.waitFor(3);
    }

    @Then("The user see the Delete button")
    public void theUserSeeTheDeleteButton() {
        BrowserUtils.waitFor(5);/// BrowserUtils.waitForClickablility(vehicles_page.deleteButton, 3);
        BrowserUtils.hover(vehicles_page.deleteButton);
        Assert.assertTrue(vehicles_page.deleteButton.isDisplayed());
        //vehicles_page.deleteButton.click();
    }

    @And("the user clicks on the delete button")
    public void theUserClicksOnTheDeleteButton() {
        vehicles_page.deleteButton.click();
    }


    @Then("the delete message should be displayed")
    public void theDeleteMessageShouldBeDisplayed() {
        Assert.assertTrue(vehicles_page.deleteMessage.isDisplayed());
    }


    @And("the user click conform delete button on pop up")
    public void theUserClickConformDeleteButtonOnPopUp() {
        vehicles_page.comfirmDelete.click();
    }

    @Then("the {string} should be displayed")
    public void theShouldBeDisplayed(String expectedMessage) {
     String actualMessage =  vehicles_page.itemDeletedMessage.getText();
     Assert.assertEquals(actualMessage,expectedMessage);
    }
}
