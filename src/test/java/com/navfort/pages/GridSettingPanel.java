package com.navfort.pages;

import com.navfort.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GridSettingPanel {
    public GridSettingPanel(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//i[@class='fa-cog hide-text']")
    public WebElement GridSettingsButton;

    @FindBy(xpath = "//div[@class='dropdown-menu']")
    public WebElement GridSettingTitle;


    @FindBy(xpath = "//input[@data-role='column-manager-search']")
    public WebElement QuickSearchBox;

    @FindBy (xpath ="//table[@class='grid table-hover table table-condensed']/tbody/tr/td/label")
    public List<WebElement> gridSettingItems;

    @FindBy (linkText = "Select All")
    public WebElement gridSettingSelectAllBtn;

    @FindBy(xpath = "//table[@class='grid table-hover table table-condensed']/tbody/tr[5]/td/span")
    public WebElement fifthItemSort;

    @FindBy(xpath = "//table[@class='grid table-hover table table-condensed']/tbody/tr[5]/td/label")
    public WebElement fifthItemName;

    @FindBy(xpath = "//table[@class='grid table-hover table table-condensed']/tbody/tr[1]/td/span")
    public WebElement firstItemSort;

    @FindBy(xpath = "//table[@class='grid table-hover table table-condensed']/tbody/tr[1]/td/label")
    public WebElement firstItemName;


    @FindBy(xpath = "//table[@class='grid table-hover table table-condensed']/tbody/tr[6]/td/span")
    public WebElement sixthItemSort;

    @FindBy(xpath = "//table[@class='grid table-hover table table-condensed']/tbody/tr[6]/td/label")
    public WebElement sixthItemName;

    @FindBy(xpath = "//table[@class='grid table-hover table table-condensed']/tbody/tr[20]/td/span")
    public WebElement lastItemSort;

    @FindBy(xpath = "//table[@class='grid table-hover table table-condensed']/tbody/tr[20]/td/label")
    public WebElement lastItemName;







    public List<String> getGridTableName(){

        List<WebElement> tableItems = Driver.getDriver().findElements(By.xpath(
                "//table[@class='grid table-hover table table-condensed']/tbody/tr/td/label"));
        List<String> actualTableItemNames = new ArrayList<>();

        for (WebElement item : tableItems) {
            actualTableItemNames.add(item.getText());
        }

        return actualTableItemNames;
    }

    public List<String> getGridSort(){

        List<WebElement> allSOrtItems = Driver.getDriver().findElements(By.xpath(
                "//td[@class='sort-cell']"));

        List<String> allSortItemNames = new ArrayList<>();
        for (WebElement eachSortItem : allSOrtItems) {
            allSortItemNames.add(eachSortItem.getText());
        }
        return allSortItemNames;
    }

    public List<String> getColumnName(){
        List<WebElement> allColumn = Driver.getDriver().findElements(By.xpath(
                "//span[@class='grid-header-cell__label']"));

        List<String> allColumnName = new ArrayList<>();

        for (WebElement eachColumn : allColumn) {
            allColumnName.add(eachColumn.getText());
        }
        return allColumnName;
    }







}
