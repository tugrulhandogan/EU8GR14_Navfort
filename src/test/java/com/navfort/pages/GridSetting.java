package com.navfort.pages;

import com.navfort.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class GridSetting {
    public GridSetting(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//i[@class='fa-cog hide-text']")
    public WebElement GridSettingsButton;

    @FindBy(xpath = "//div[@class='dropdown-menu']")
    public WebElement GridSettingTitle;


   // @FindBy(xpath = "//table[@class='grid table-hover table table-condensed']/tbody/tr/td/label")
   // public WebElement gridSettingTable;

    @FindBy(xpath = "//input[@data-role='column-manager-search']")
    public WebElement QuickSearchBox;

    @FindBy (xpath ="//table[@class='grid table-hover table table-condensed']/tbody/tr/td/label")
    public List<WebElement> gridSettingItems;


    public List<String> getGridTableName(){

        List<WebElement> tableItems = Driver.getDriver().findElements(By.xpath(
                "//table[@class='grid table-hover table table-condensed']/tbody/tr/td/label"));

        List<String> actualTableItemNames = new ArrayList<>();

        for (WebElement item : tableItems) {
            actualTableItemNames.add(item.getText());
        }

        return actualTableItemNames;
    }







}
