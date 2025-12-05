package com.project.tests;

import com.project.pages.LoginPage;
import com.project.pages.DashboardPage;
import com.project.pages.AddEmployeePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddEmployeeTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private AddEmployeePage addEmployeePage;

    @BeforeClass
    public void setUp() {
        // Initialize Chrome browser
        driver = new ChromeDriver();

        // Maximize window
        driver.manage().window().maximize();

        // Navigate to Login Page
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // Initialize page classes
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        addEmployeePage = new AddEmployeePage(driver);
    }

    // TC_LoginSuccessful: Verify that the user can log in successfully
    @Test(priority = 1)
    public void TC_LoginSuccessful() {
        loginPage.login("Admin", "admin123");
        Assert.assertTrue(dashboardPage.isAtDashboard(), "Login failed!");
        System.out.println("✓ TC_LoginSuccessful: Login successful");
    }

    // TC_OpenAddEmployeeForm: Verify Add Employee form opens
    @Test(priority = 2, dependsOnMethods = "TC_LoginSuccessful")
    public void TC_OpenAddEmployeeForm() {
        addEmployeePage.openAddEmployeeForm();
        Assert.assertTrue(addEmployeePage.isAddEmployeeFormDisplayed(),
                "Add Employee form did not open.");
        System.out.println("✓ TC_OpenAddEmployeeForm: Add Employee form opened");
    }

    // TC_MandatoryFieldsDisplayed: Verify mandatory fields appear
    @Test(priority = 3, dependsOnMethods = "TC_LoginSuccessful")
    public void TC_MandatoryFieldsDisplayed() {
        addEmployeePage.openAddEmployeeForm();
        Assert.assertTrue(addEmployeePage.isFirstNameFieldDisplayed(), "First Name missing");
        Assert.assertTrue(addEmployeePage.isLastNameFieldDisplayed(), "Last Name missing");
        Assert.assertTrue(addEmployeePage.isEmployeeIdFieldDisplayed(), "Employee ID missing");
        System.out.println("✓ TC_MandatoryFieldsDisplayed: Mandatory fields displayed");
    }

    // TC_EmptyFirstNameShowsError: Verify required message appears
    @Test(priority = 4, dependsOnMethods = "TC_LoginSuccessful")
    public void TC_EmptyFirstNameShowsError() {
        addEmployeePage.openAddEmployeeForm();
        addEmployeePage.enterLastName("samuel");
        addEmployeePage.clickSaveButton();
        Assert.assertTrue(addEmployeePage.isFirstNameErrorDisplayed(),
                "Error message not displayed for empty First Name");
        System.out.println("✓ TC_EmptyFirstNameShowsError: Error displayed");
    }

    // TC_AddEmployeeWithSpecialChars: Verify employee with special chars is added
    @Test(priority = 5, dependsOnMethods = "TC_LoginSuccessful")
    public void TC_AddEmployeeWithSpecialChars() {
        addEmployeePage.openAddEmployeeForm();
        addEmployeePage.addEmployee("@@@@", "@@@");
        Assert.assertTrue(addEmployeePage.isEmployeeAdded(),
                "Employee with special chars not added");
        System.out.println("✓ TC_AddEmployeeWithSpecialChars: Employee added");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
