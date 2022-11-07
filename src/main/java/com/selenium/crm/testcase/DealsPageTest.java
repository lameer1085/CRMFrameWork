package com.selenium.crm.testcase;

import com.selenium.crm.baseclass.TestBase;
import com.selenium.crm.pages.DealsPage;
import com.selenium.crm.pages.HomePage;
import com.selenium.crm.pages.LoginPage;
import com.selenium.crm.utils.TestUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DealsPageTest extends TestBase {
    DealsPage dealsPage;
    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    public String titleBox="customerSearch",amount="25000", extendedDField="extended file box ",
                   contact="8870133616",company="XYZ pvt ltd", commission="25",tagBox="ameerContact";
    public DealsPageTest(){
        super();
    }
    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        initialization("chrome");
        log.info("Application started successfully");
        testUtil=new TestUtil();
        loginPage=new LoginPage();
        homePage=new HomePage();
        dealsPage=new DealsPage();
        homePage = loginPage.login(property.getProperty("username"),property.getProperty("password"));
    }
    @Test(enabled = true)
    public void enterIntoFullSearchPage(){
        testUtil.switchToFrame("mainpanel");
        dealsPage.goToDealFullSearchPage();
        String expected="Search Deals2";
        String actual= dealsPage.pageName();
        Assert.assertEquals(expected,actual);
        System.out.println("you are in deals search page");
         log.info("you are in deals search page");
    }
    @DataProvider(name = "DropDown_data")
    public Object[][] dataFromSheet(){   //DealsPageFullSearchPage  DatesForDealsPage  dropDownValues
        Object[][] data=TestUtil.getData("DealsPageFullSearchPage","dropDownValues");
        return data;
    }
    @Test(enabled = false, dependsOnMethods = "enterIntoFullSearchPage", dataProvider = "DropDown_data")
    public void setTheDropDownsInSearchPage(String data1,String data2,String data3,String data4, String data5){
        testUtil.switchToFrame("mainpanel");
        dealsPage.goToDealFullSearchPage();
        dealsPage.setDropDowns(data1,data2,data3,data4);

    }
    @DataProvider(name="Dates")
    public Object[][] dataFromSheetForDates(){
        return TestUtil.getData("DealsPageFullSearchPage","DatesForDealsPage");
    }
    @Test(enabled = true ,dataProvider = "Dates")
    public void setDates(String data1,String data2,String data3,String data4, String data5){
        testUtil.switchToFrame("mainpanel");
        dealsPage.goToDealFullSearchPage();
        dealsPage.setTitleBox_setStatus(titleBox);
        dealsPage.fillTheDetails(tagBox, extendedDField, contact,  company, amount, commission);
        dealsPage.setDates(data1,data2,data3,data4,data5);
        dealsPage.saveSearch();
    }
}
