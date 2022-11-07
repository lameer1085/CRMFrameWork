package com.selenium.crm.pages;

import com.selenium.crm.baseclass.TestBase;
import com.selenium.crm.utils.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class DealsPage extends TestBase {
    @FindBy(css="a[title='Deals']")
    WebElement dealsTitle;
    @FindBy(xpath="//div[@id='navmenu']/ul/li[5]/ul/li[3]/a[@title='Full Search Form']")
    WebElement fullSearchPage;
    @FindBy(xpath="//legend[text()='Search Deals']")
    WebElement pageName;

    @FindBy(css="input[name='cs_keyword']")
    WebElement titleBox;

    @FindBy(xpath="//*[@name='cs_closed' and @value='N']")
    WebElement status;

    @FindBy(xpath="//select[@name='cs_type' and @class='select']")
    WebElement typeDropDown;
    //SelectbyValue("New");

    @FindBy(xpath="//select[@name='by_user' and @class='select']")
    WebElement userDropDown;
    //selectbyVisibleText("AMEER SALMAN")

    @FindBy(xpath="//select[@name='cs_source' and @class='select']")
    WebElement sourceDropDown;
    //selectbyVisibleText("Existing Customer")

    @FindBy(css="img[id='f_trigger_c_cs_created_at_from']")
    WebElement creationDateFrom;
    @FindBy(css="img[id='f_trigger_c_cs_created_at_to']")
    WebElement creationDateTo;

    @FindBy(css="img[id='f_trigger_c_cs_last_modified_from']")
    WebElement modifiedDateFrom;
    @FindBy(css="img[id='f_trigger_c_cs_last_modified_to']")
    WebElement modifiedDateTo;

    @FindBy(css="img[id='f_trigger_c_cs_close_date']")
    WebElement closingDate;
    @FindBy(name="tag")
    WebElement tagsBox;

    @FindBy(name="cs_save_search")
    WebElement saveSearch;

    @FindBy(name="cs_extended")
    WebElement extendedField;
    @FindBy(name="cs_contact_name")
    WebElement contactNameBox;
    @FindBy(name="cs_company_name")
    WebElement companyNameBox;
    @FindBy(name="cs_probability")
    WebElement probabilityBox;

    @FindBy(xpath="//select[@name='cs_amount_operator' and @class='select']")
    WebElement amountTypeDropDown;
    //selectbyVisibleText("Equal to")
    @FindBy(name="cs_amount")
    WebElement amountBox;
    @FindBy(name="cs_commission")
    WebElement commissionBox;
    @FindBy(id="cs_search_extended")
    WebElement searchExtendedCheckBox;

    @FindBy(xpath="//form[@name='prospectForm']/table/tbody/tr[8]/td/input[@value='Search Deals']")
    WebElement searchDeals;

    public DealsPage(){
        PageFactory.initElements(driver,this);
    }
    public void goToDealFullSearchPage(){
        TestUtil.moveToElementAndClickOnSubElement(dealsTitle,fullSearchPage);
    }
    public String pageName(){
        return pageName.getText();
    }
    public void setTitleBox_setStatus(String title){
        titleBox.sendKeys(title);
        status.click();
    }
    public void setDropDowns(String type,String userName,String source, String amount){
        TestUtil.selectValueFromDropDownByText(typeDropDown,type);
        TestUtil.selectValueFromDropDownByText(userDropDown,userName);
        TestUtil.selectValueFromDropDownByText(sourceDropDown,source);
        TestUtil.selectValueFromDropDownByText(amountTypeDropDown,amount);
        log.info("all the dropDowns are selected successfully");
    }
    public void setDates(String createFrom,String createTo,String modifiedFrom,String modifiedTo,String closeDate){
        int div=6;
        creationDateFrom.click();
        TestUtil.pickDate(driver,createFrom,div);
        creationDateTo.click();
        TestUtil.pickDate(driver,createTo,++div);
        log.info("Creation date was correctly noted>>>>>>");
        modifiedDateFrom.click();
        TestUtil.pickDate(driver,modifiedFrom,++div);
        modifiedDateTo.click();
        TestUtil.pickDate(driver,modifiedTo,++div);
        log.info("modified date was correctly noted>>>>>>");
        closingDate.click();
        TestUtil.pickDate(driver,closeDate,++div);
        log.info("close date was correctly noted>>>>>>");
    }
    public void fillTheDetails(String tag,String extended,String contact, String company,String amount,String commission){
        tagsBox.sendKeys(tag);
        extendedField.sendKeys(extended);
        contactNameBox.sendKeys(contact);
        companyNameBox.sendKeys(company);
        amountBox.sendKeys(amount);
        commissionBox.sendKeys(commission);
    }
    public void saveSearch() {
        saveSearch.click();
        searchExtendedCheckBox.click();
        searchDeals.click();
        log.info("search Deals is saved >>>>>>");
    }
}
