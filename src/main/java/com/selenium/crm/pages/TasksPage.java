package com.selenium.crm.pages;

import com.selenium.crm.baseclass.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TasksPage extends TestBase{

    @FindBy(xpath="//*[contains(text(),'Showing all tasks')]")
    WebElement tasksLabel;

    @FindBy(xpath="//*[@name='cs_keyword']")
    WebElement keyWord;

    @FindBy(xpath="//*[@name='cs_extended']")
    WebElement extendedField;

    @FindBy(name="cs_completion")
    WebElement completion;

    @FindBy(name="cs_notes")
    WebElement notes;

    @FindBy(name="cs_status")
    WebElement status;

    @FindBy(name="cs_task_type")
    WebElement taskType;

    @FindBy(css="input[name='cs_save_search']")
    WebElement saveMark;

    @FindBy(css="input[name='cs_search_title']")
    WebElement searchTitle;

    public TasksPage(){
        PageFactory.initElements(driver,this);
    }
    public boolean verifyTasksLabel(){
        return tasksLabel.isDisplayed();
    }

    public void searchWithData(String keyword, String extended, String compPer,String note){
        keyWord.sendKeys(keyword);
        extendedField.sendKeys(extended);
        completion.sendKeys(compPer);
        notes.sendKeys(note);

    }

    public void statusSelection(){

        Select select = new Select(status);
        select.selectByVisibleText("Complete");
    }
    public void typeSelection(){

        Select select = new Select(taskType);
        select.selectByVisibleText("Event");
    }
    public void saveMarkSelection(String nameOfCustomer){
        saveMark.click();
        searchTitle.sendKeys(nameOfCustomer);

    }
}
