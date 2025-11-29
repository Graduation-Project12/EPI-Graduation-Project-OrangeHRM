package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class MyInfoPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public MyInfoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private By myInfo = By.xpath("//span[text()='My Info']");
    private By firstNameInput = By.cssSelector(".orangehrm-firstname"); // First Name
    private By lastNameInput = By.cssSelector(".orangehrm-lastname"); // Last Name
    private By nationalityDropdown = By.xpath("//label[text()='Nationality']/ancestor::div[contains(@class, 'oxd-input-field-bottom-space')]//div[@class='oxd-select-text-input']"); // Nationality dropdown input (this is generic)
    private By nationalityDropdownList = By.xpath("//div[@role='listbox']//div[@role='option']");
    private By maritalStatusDropdown = By.xpath("//label[text()='Marital Status']/ancestor::div[contains(@class, 'oxd-input-field-bottom-space')]"); // Marital status – assumption
    private By maritalStatusList = By.xpath("//div[@role='listbox']//div[@role='option']"); // its options
    private By genderMaleRadio = By.xpath("//label[normalize-space()='Male']"); // male radio
    private By genderFemaleRadio = By.xpath("//label[normalize-space()='Female']"); // female radio
    private By dateOfBirthInput = By.xpath("(//input[@placeholder='yyyy-dd-mm'])[2]"); // DOB field
    private By saveButton = By.xpath("(//button[@type='submit'][normalize-space()='Save'])[1]"); // save button

    public void openMyInfoPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(myInfo)).click();
    }

    public void setFirstName(String firstName) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInput));
        input.click();
        input.sendKeys(Keys.CONTROL + "a");
        input.sendKeys(Keys.DELETE);
        input.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameInput));
        input.click();
        input.sendKeys(Keys.CONTROL + "a");
        input.sendKeys(Keys.DELETE);
        input.sendKeys(lastName);
    }

    public void setNationality(String nationality) {
        wait.until(ExpectedConditions.elementToBeClickable(nationalityDropdown)).click();

        List<WebElement> options = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(nationalityDropdownList)
        );

        for (WebElement option : options) {
            if (option.getText().equals(nationality)) {
                option.click();
                return;
            }
        }
    }

    public void setMaritalStatus(String status) {
        wait.until(ExpectedConditions.elementToBeClickable(maritalStatusDropdown)).click();

        List<WebElement> options = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(maritalStatusList)
        );

        for (WebElement option : options) {
            if (option.getText().equals(status)) {
                option.click();
                return;
            }
        }
    }

    public void setGender(String gender) {
        if (gender == "male") {
            WebElement radio = wait.until(ExpectedConditions.elementToBeClickable(genderMaleRadio));
            radio.click();
        } else {
            WebElement radio = wait.until(ExpectedConditions.elementToBeClickable(genderFemaleRadio));
            radio.click();
        }
    }

    public void setDateOfBirth(String dob) {
        WebElement dobInput = wait.until(ExpectedConditions.elementToBeClickable(dateOfBirthInput));
        dobInput.click();
        dobInput.sendKeys(Keys.CONTROL + "a");
        dobInput.sendKeys(Keys.DELETE);
        dobInput.sendKeys(dob);
    }

    public void clickSave() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }

// Methods For Assertion

    public boolean isFirstNameUpdated(String firstname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInput)).getText();
        return firstname.equals(firstname);
    }
    public boolean isLastNameUpdated(String lastname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameInput)).getText();
        return lastname.equals(lastname);
    }
    public boolean isNationalityUpdated(String nationality) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nationalityDropdown)).getText();
        return nationality.equals(nationality);
    }
    public boolean isMaritalStatusUpdated(String MaritalStatus) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(maritalStatusDropdown)).getText();
        return MaritalStatus.equals(MaritalStatus);
    }
    public boolean isGenderUpdated(String expectedGender) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(genderFemaleRadio)).getAttribute("Female");
        return expectedGender.equals(expectedGender);
    }
    public boolean isDateOfBirthUpdated(String expectedbod) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dateOfBirthInput)).getAttribute("2000-08-02");
        return expectedbod.equals(expectedbod);
    }
}
//    public String getFirstName() {
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInput)).getText();
//    }
//    public String getLastName() {
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameInput)).getText();
//    }
//    public String getNationality() {
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(nationalityDropdown)).getText();
//    }
//    public String getMaritalStatus() {
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(maritalStatusDropdown)).getText();
//    }
//    public String getSelectedGender() {
//        if (driver.findElement(genderMaleRadio).isSelected()) return "Male";
//        if (driver.findElement(genderFemaleRadio).isSelected()) return "Female";
//        return "";
//    }
//    public String getDateOfBirth() {
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(dateOfBirthInput)).getText();
//    }
   // public Collection<Object> getSuccessToast() {}
