package com.navfort.step_definitions;

import com.navfort.pages.*;
import com.navfort.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class GeneralInfo_SD {

    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    HomePage homePage = new HomePage();
    Vehicles_Page vehicles_page = new Vehicles_Page();
    GeneralInformationPage generalInformationPage = new GeneralInformationPage();

    @When("the user go to'General Information'")
    public void the_user_go_to_general_information() {
        generalInformationPage.generalInfoRow.click();
    }

    @When("The user clicks on any row on the Vehicle - All Cars page")
    public void the_user_clicks_on_any_row_on_the_vehicle_all_cars_page() {
        vehicles_page.clickAnyRow();
        BrowserUtils.waitFor(3);
    }

    @When("the user click Delete button")
    public void the_user_click_button() {
        BrowserUtils.waitFor(3);
        generalInformationPage.deleteButtonGenePage.click();
    }

    @And("user click the confirm delete button on pop up")
    public void userClickTheConfirmDeleteButtonOnPopUp() {
        BrowserUtils.waitFor(3);
        generalInformationPage.deleteConfirmBtn.click();
    }

    @Then("the Item delete message should be displayed")
    public void theItemDeleteMessageShouldBeDisplayed() {
        String expectedMessage = "Item delete";
        String actualMessage = generalInformationPage.itemDeleteMessage.getText();
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @And("The user is on the General Information page")
    public void theUserIsOnTheGeneralInformationPage() {

        Assert.assertTrue(generalInformationPage.getPageName());

    }
}
