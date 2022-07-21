package com.navfort.step_definitions;

import com.navfort.pages.BasePage;
import com.navfort.utilities.Driver;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestStepDef extends BasePage {

	@FindBy(id = "prependedInput")
	private WebElement usernameField;

	@FindBy(id = "prependedInput2")
	private WebElement passwordField;

	@FindBy(id = "_submit")
	private WebElement loginBtn;

	@Given("test")
	public void test() {

		Driver.getDriver().get("https://qa.perfleet.com/");
			usernameField.sendKeys("salesmanager101");
			passwordField.sendKeys("UserUser123");
			loginBtn.click();
			new BasePage().waitUntilLoaderScreenDisappear();
		    new BasePage().clickMenuElement("Fleet", "Vehicles");


	}

}
