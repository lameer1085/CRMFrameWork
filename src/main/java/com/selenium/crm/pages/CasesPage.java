package com.selenium.crm.pages;

import com.selenium.crm.baseclass.TestBase;
import com.selenium.crm.utils.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CasesPage extends TestBase{

    @FindBy(xpath = "//body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[contains(text(),'AMEER SALMAN')]")
    WebElement username;

    @FindBy(id="title")
    WebElement titleBox;
    @FindBy(xpath = "//*[@name='status']")
    WebElement statusBox;
    @FindBy(id = "f_trigger_c_deadline")
    WebElement deadlineDate;
    @FindBy(name = "identifier")
    WebElement identifier;
    @FindBy(name = "description")
    WebElement description;
    @FindBy(xpath = "//*[@title='Cases']")
    WebElement actionToCases;
    @FindBy(xpath = "//*[@title='New Case']")
    WebElement newCaseOpen;
    @FindBy(xpath = "f_trigger_c_deadline")
    WebElement deadLineDate;
    @FindBy(xpath = "//input[@type='radio' and @value='N']")
    WebElement stateOpen;
    @FindBy(name = "priority")
    WebElement priorityDropDown;
    @FindBy(xpath = "//form[@id='caseForm']/table/tbody/tr[1]/td/input[@type='submit']")
    WebElement saveButton;

    String date="1/11/2022";

    TestUtil testUtil;
    public CasesPage(){
        PageFactory.initElements(driver,this);
    }
    public String verifyUser(){
        return username.getText();
    }
    public void setNewCaseOpen(){
        Actions act = new Actions(driver);
        act.moveToElement(actionToCases).build().perform();
        newCaseOpen.click();
    }

    public void titleBoxForCase(String sentence){
        titleBox.sendKeys(sentence);
    }
    public void setStatusBox(String statusType){
        statusBox.click();
        Select select =new Select(statusBox);
        select.selectByVisibleText(statusType);
    }
    public void setStateOpen(){
        stateOpen.click();
    }
    public void setIdentifier(String identity){
        identifier.sendKeys(identity);
    }
    public void setPriorityDropDown(String priority){
        priorityDropDown.click();
        Select select= new Select(priorityDropDown);
        select.selectByVisibleText(priority);
    }
    public void setDescription(String descript){
        description.sendKeys(descript);
    }
    public void setDeadlineDate(){
        int div=6;
        deadlineDate.click();
        TestUtil.pickDate(driver,date,div);

    }
    public void saveCase(){
    saveButton.click();
    }
}

