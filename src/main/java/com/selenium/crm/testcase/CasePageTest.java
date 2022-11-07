package com.selenium.crm.testcase;

import com.beust.jcommander.Parameter;
import com.selenium.crm.baseclass.TestBase;
import com.selenium.crm.pages.CasesPage;
import com.selenium.crm.pages.HomePage;
import com.selenium.crm.pages.LoginPage;
import com.selenium.crm.utils.TestUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CasePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    CasesPage casePage;
    TestUtil testUtil;

    public CasePageTest(){
        super();
    }
    @BeforeMethod(alwaysRun = true)
    @Parameters(value = "browser")
    public void setUp(String browser){
        initialization(browser);
        log.info("application successfully opened");

        testUtil=new TestUtil();
        loginPage=new LoginPage();
        homePage=new HomePage();
        casePage=new CasesPage();
        homePage = loginPage.login(property.getProperty("username"),property.getProperty("password"));
    }
    @Test(priority = 12, enabled = false)
    public void userVerify() {
        testUtil.switchToFrame("mainpanel");
        String user = "  User: AMEER SALMAN";
        Assert.assertEquals(user, casePage.verifyUser(), "Not a exact user name");
        log.info("username verified");
    }
    @Test(priority = 13,enabled = true)
    public void newCasePage(){
        testUtil.switchToFrame("mainpanel");
        casePage.setNewCaseOpen();
        log.info("New case page successfully opened");
        casePage.titleBoxForCase("search at ameer account");
        casePage.setStatusBox("Awaiting input");
        casePage.setStateOpen();
        casePage.setIdentifier("for ameer account");
        casePage.setDescription("This is first search case for ameer account, it is successfully done");
        casePage.setPriorityDropDown("High");
        casePage.saveCase();
        log.info("case page checked ......");
    }
    @Test(priority = 14,enabled = true)
    public void setDate(){
        testUtil.switchToFrame("mainpanel");
        casePage.setNewCaseOpen();
        casePage.setDeadlineDate();
        log.info("date is picked successfully");
    }
}
