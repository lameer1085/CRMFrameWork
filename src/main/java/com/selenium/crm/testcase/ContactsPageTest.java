package com.selenium.crm.testcase;

import com.selenium.crm.TestListeners.ExtentReportListener;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.selenium.crm.baseclass.TestBase;
import com.selenium.crm.pages.ContactsPage;
import com.selenium.crm.pages.DealsPage;
import com.selenium.crm.pages.HomePage;
import com.selenium.crm.pages.LoginPage;
import com.selenium.crm.utils.TestUtil;
//@Listeners({ExtentReportListener.class})
public class ContactsPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	
	String sheetName = "Contacts"; 
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod(alwaysRun=true)
	public void setUp()
	{
		initialization("chrome");
		testUtil = new TestUtil();
		log.info("Application Launched Successfully");
		
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		dealsPage = new DealsPage();
		homePage = loginPage.login(property.getProperty("username"),property.getProperty("password"));
	}
	
	@Test(priority=8, enabled=true)
	public void verifyContactsPageLabelTest()

	{
		testUtil.switchToFrame("mainpanel");
		contactsPage = homePage.clickOnContactsLink();
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts Label is Missing in the Page");
		log.info("Verified Contacts Page Label");
	}
	
	@Test(priority=9, enabled=true)
	public void selectSingleContactsTest()
	{
		testUtil.switchToFrame("mainpanel");
		contactsPage = homePage.clickOnContactsLink();
		contactsPage.selectContactByName("AMEER SALMAN");
		log.info("Verified Single Contacts");
	}
	
	@Test(priority=10, enabled=true)
	public void selectMultipleContactsTest()
	{
		testUtil.switchToFrame("mainpanel");
		contactsPage = homePage.clickOnContactsLink();
		contactsPage.selectContactByName("David Cris");
		contactsPage.selectContactByName("Tom Peter");
		log.info("Verified Multiple Contacts");
	}
	
	@DataProvider(name= "CRMData")
	public Object[][] getCRMContactsTestData()
	{
		Object data [][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=11, enabled=true, dataProvider="CRMData")
	public void validateCreateNewContactTest(String Title, String FirstName, String LastName, String Company)
	{
		testUtil.switchToFrame("mainpanel");
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact(Title, FirstName, LastName, Company);
		log.info("New Contacts Created Successfully");
	}
	
}
