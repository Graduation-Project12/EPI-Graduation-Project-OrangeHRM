package com.project.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class EmployeeListPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By pimMenu = By.xpath("//span[text()='PIM']");
    private By employeeListMenu = By.xpath("//a[text()='Employee List']");

    private By employeeNameInput = By.xpath("(//input[@placeholder='Type for hints...'])[1]");
    private By employeeIdInput = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");

    private By employmentStatusDropdown = By.xpath("(//div[@class='oxd-select-text-input'])[1]");
    private By includeDropdown = By.xpath("(//div[@class='oxd-select-text-input'])[2]");
    private By jobTitleDropdown = By.xpath("(//div[@class='oxd-select-text-input'])[3]");
    private By subUnitDropdown = By.xpath("(//div[@class='oxd-select-text-input'])[4]");

    private By dropdownOptions = By.xpath("//div[@role='listbox']//span");

    private By searchBtn = By.xpath("//button[@type='submit']");
    private By resetBtn = By.xpath("//button[@type='reset']");

    private By noRecordsFound = By.xpath("//*[text()='No Records Found']");
    private By resultsTable = By.cssSelector(".oxd-table-body");

    public EmployeeListPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Open Employee List
    public void openEmployeeList() {
        wait.until(ExpectedConditions.elementToBeClickable(pimMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(employeeListMenu)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBtn));
    }

    public void enterEmployeeName(String name) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(employeeNameInput));
        input.clear();
        input.sendKeys(name);
    }

    public void enterEmployeeId(String id) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(employeeIdInput));
        input.clear();
        input.sendKeys(id);
    }

    // ======================================================
    // 🔥 Smart dropdown selector (Auto fallback to first option)
    // ======================================================
    private void selectFromDropdown(By dropdown, String optionText) {

        wait.until(ExpectedConditions.elementToBeClickable(dropdown)).click();

        List<WebElement> options = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(dropdownOptions)
        );

        // لو اللي داخل فاضي → اختار أول اختيار
        if (optionText == null || optionText.trim().isEmpty()) {
            options.get(0).click();
            return;
        }

        // دور على الاختيار المطلوب
        for (WebElement option : options) {
            if (option.getText().trim().equalsIgnoreCase(optionText.trim())) {
                option.click();
                return;
            }
        }

        // لو الاختيار مش موجود → اختار أول اختيار
        options.get(0).click();
    }

    // Employment Status
    public void selectEmploymentStatus(String status) {
        selectFromDropdown(employmentStatusDropdown, status);
    }

    // Job Title
    public void selectJobTitle(String title) {
        selectFromDropdown(jobTitleDropdown, title);
    }

    // Sub Unit
    public void selectSubUnit(String subUnit) {
        selectFromDropdown(subUnitDropdown, subUnit);
    }

    public void clickSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultsTable));
    }

    public void clickReset() {
        wait.until(ExpectedConditions.elementToBeClickable(resetBtn)).click();
    }

    // Assertions
    public boolean isSearchExecuted() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(resultsTable));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isNoRecordFoundDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(noRecordsFound));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
