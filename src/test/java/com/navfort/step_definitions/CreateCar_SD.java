package com.navfort.step_definitions;

import com.navfort.pages.CreateCarPage;
import com.navfort.pages.DashboardPage;
import com.navfort.pages.GeneralInformationPage;
import com.navfort.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateCar_SD{

    CreateCarPage createCarPage = new CreateCarPage();
    DashboardPage dashboardPage= new DashboardPage();
    GeneralInformationPage generalInformationPage = new GeneralInformationPage();

   /* @When("the user navigates to {string} {string}")
    public void theUserNavigatesTo(String tab, String module) {
        dashboardPage.navigateToModule(tab, module);

    }*/

    @And("the user clicks on Create Car button")
    public void theUserClicksOnCreateCarButton() {
        createCarPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.clickWithJSExe(createCarPage.createCarButton);
    }

    @And("the user enters new Car information")
    public void theUserEntersNewCarInformation() throws InterruptedException {
        createCarPage.newCarGenerator();

    }

    @And("the user clicks on save changes button")
    public void theUserClicksOnSaveChangesButton() {

        createCarPage.saveAndCloseButton.click();
    }

    @And("user click the delete button on the created car page")
    public void userClickTheDeleteButtonOnTheCreatedCarPage() {

        createCarPage.deleteCar.click();

    }

    @When("The user go to{string}")
    public void theUserGoToGeneralInformation() {
        generalInformationPage.generalInfoRow.click();

    }
}
