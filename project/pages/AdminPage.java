package com.project.pages;

import com.project.utils.ElementActions;
import com.project.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage {

    public AdminPage(WebDriver driver)
    {
        this.driver=driver;
    }
    private WebDriver driver;



    public void clickAdminTab() {
        WebElement adminTabLocator = driver.findElement(By.xpath("//span[text()='Admin']"));
        WaitUtils.waitAndClick(driver, adminTabLocator);
    }

    public void clickAddButton() {
        WebElement addIcon = driver.findElement(By.cssSelector("button.oxd-button.oxd-button--secondary i.bi-plus"));
        WaitUtils.waitAndClick(driver, addIcon);
    }

    public void clickUserRoleDropdown() {
         WebElement userRoleDropdownLocator = driver.findElement(By.xpath("(//div[@class='oxd-select-text--after'])[1]"));
         WaitUtils.selectFromDropdown(driver,  userRoleDropdownLocator, "ESS");
    }

    public void enterEmployeeName(String employeeName) {
        WebElement employeeNameInput = driver.findElement(By.cssSelector("input[placeholder='Type for hints...']"));
        ElementActions.write(driver,employeeNameInput,employeeName);
    }

    public void clickStatusDropdown() {
        By statusDropdownLocator = By.xpath("(//div[@class='oxd-select-text--after'])[2]");
        WaitUtils.selectFromDropdown(driver, (WebElement) statusDropdownLocator, "Enabled");
    }


    public void enterNewUsername(String newUsername) {
        WebElement newUsernameLocator = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));
        newUsernameLocator.clear();
        newUsernameLocator.sendKeys(newUsername);
    }

    public void enterNewPassword(String newPassword) {
        WebElement newPasswordLocator = driver.findElement(By.xpath("(//input[@type='password'])[1]"));
        newPasswordLocator.clear();
        newPasswordLocator.sendKeys(newPassword);
    }

    public void confirmNewPassword(String newPassword) {
        WebElement confirmNewPasswordLocator = driver.findElement(By.xpath("(//input[@type='password'])[2]"));
        confirmNewPasswordLocator.clear();
        confirmNewPasswordLocator.sendKeys(newPassword);
    }

    public void clickSaveButton() {
        WebElement saveBtnLocator = driver.findElement(By.cssSelector("button[type='submit']"));
        WaitUtils.waitAndClick(driver, saveBtnLocator);
    }


    public void filterByUsername(String username) {
        WebElement filterUsernameLocator = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));
        filterUsernameLocator.clear();
        filterUsernameLocator.sendKeys(username);
    }

    public void filterByUserRole() {
        WebElement filterUserRoleDropdownLocator = (WebElement) By.xpath("(//div[@class='oxd-select-text--after'])[1]");
        WaitUtils.selectFromDropdown((driver), filterUserRoleDropdownLocator, "ESS");
    }

    public void filterByStatus() {
        By filterStatusDropdownLocator = By.xpath("(//div[@class='oxd-select-text--after'])[2]");
        WaitUtils.selectFromDropdown(driver, (WebElement) filterStatusDropdownLocator, "Enabled");
    }

    public void clickSearchButton() {
        WebElement searchBtnLocator = driver.findElement(By.xpath("//button[@type='submit']"));
        WaitUtils.waitAndClick(driver, searchBtnLocator);
    }


}


