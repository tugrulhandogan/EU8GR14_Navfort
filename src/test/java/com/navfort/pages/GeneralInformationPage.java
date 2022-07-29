package com.navfort.pages;

import com.navfort.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class GeneralInformationPage {

    public GeneralInformationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

}
