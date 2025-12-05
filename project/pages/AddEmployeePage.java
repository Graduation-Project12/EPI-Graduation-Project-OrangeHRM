package com.project.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AddEmployeePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // ===== Locators =====
    private By pimMenu = By.xpath("//span[text()='PIM']");
    private By addEmployeeButton = By.xpath("//a[text()='Add Employee']");
    private By firstNameField = By.name("firstName");
    private By lastNameField = By.name("lastName");
    private By employeeIdField = By.xpath("//label[text()='Employee Id']/../following-sibling::div/input");
    private By saveButton = By.xpath("//button[@type='submit']");
    private By successMessage = By.xpath("//*[contains(text(),'Successfully Saved')]");
    private By firstNameError = By.xpath("//span[contains(.,'Required')]");

    // ===== Constructor =====
    public AddEmployeePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // ==========================================================
    // 🔥 الميثود الأساسية لفتح الفورم
    // ==========================================================
    public void openAddEmployeeForm() {
        wait.until(ExpectedConditions.elementToBeClickable(pimMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addEmployeeButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
    }

    // ==========================================================
    // 🔥 حسب الاتفاق: نرجع الميثود القديمة علشان التست متبظش
    // ==========================================================
    public void goToAddEmployee() {
        openAddEmployeeForm();
    }

    // ==========================================================
    // Actions
    // ==========================================================

    public void enterFirstName(String firstName) {
        WebElement firstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        WebElement lastNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField));
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
    }

    public void clickSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }

    // إضافة موظف جديد
    public void addEmployee(String firstName, String lastName) {
        enterFirstName(firstName);
        enterLastName(lastName);
        clickSaveButton();
        wait.until(ExpectedConditions.urlContains("viewPersonalDetails"));
    }

    // التحقق من أن الموظف اتضاف
    public boolean isEmployeeAdded() {
        try {
            wait.until(ExpectedConditions.urlContains("/pim/viewPersonalDetails"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // ظهور رسالة الحفظ
    public boolean isSuccessMessageDisplayed() {
        try {
            WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
            return msg.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // رسالة Required عند ترك firstName فارغ
    public boolean isFirstNameErrorDisplayed() {
        try {
            WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameError));
            return error.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // الحقول
    public boolean isFirstNameFieldDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).isDisplayed();
    }

    public boolean isLastNameFieldDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField)).isDisplayed();
    }

    public boolean isEmployeeIdFieldDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(employeeIdField)).isDisplayed();
    }

    public boolean isAddEmployeeFormDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
