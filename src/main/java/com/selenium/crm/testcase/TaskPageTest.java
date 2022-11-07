package com.selenium.crm.testcase;

import com.selenium.crm.baseclass.TestBase;
import com.selenium.crm.pages.HomePage;
import com.selenium.crm.pages.LoginPage;
import com.selenium.crm.pages.TasksPage;
import com.selenium.crm.utils.TestUtil;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TaskPageTest extends TestBase {
    TasksPage tasksPage;
    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;

    String sheetName="Search_Name";

    public TaskPageTest() {
        super();
    }

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        initialization("chrome");
        log.info("Application started successfully");
        testUtil = new TestUtil();
        loginPage = new LoginPage();
        tasksPage = new TasksPage();
        homePage = loginPage.login(property.getProperty("username"), property.getProperty("password"));
    }

    @Test(priority = 15, enabled = true)
    public void verifyTasksLabel() {
        testUtil.switchToFrame("mainpanel");
        tasksPage = homePage.clickOnTasksLink();
        Assert.assertTrue(tasksPage.verifyTasksLabel(), " this is not tasks page");
        log.info("label is verified");
    }

    @Test(priority = 16, enabled = true)
    public void details() {
        testUtil.switchToFrame("mainpanel");
        tasksPage=homePage.clickOnTasksLink();
        tasksPage.searchWithData("ameer", "salman", "75", "search for name");
        tasksPage.statusSelection();
        tasksPage.typeSelection();
        log.info("all the information's are entered ");
    }

    @DataProvider(name = "data")
    public Object[][] dataPro() {

        /*Object[][] data = TestUtil.getTestData(sheetName);*/
        return new Object[][]{{"search for contacts"}};
    }

    @Test(priority = 17, enabled = true, dataProvider = "data")
    public void saveSearch(String searchAs) {
        testUtil.switchToFrame("mainpanel");
        tasksPage=homePage.clickOnTasksLink();
        tasksPage.saveMarkSelection(searchAs);
        log.info("search tasks saved successfully");
    }
}
