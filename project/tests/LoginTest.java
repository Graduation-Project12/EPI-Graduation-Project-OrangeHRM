package com.project.tests;

import com.project.base.BaseTest;
import com.project.pages.DashboardPage;
import com.project.pages.LoginPage;
import com.project.utils.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.BaseTestMethod;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @BeforeMethod
    public void initPages() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @Test(priority = 1,description = "Verify that  admin login with valid credentials")
    public void TC_ValidLogin() {
        loginPage.login(TestData.adminUsername, TestData.adminPassword);
        Assert.assertTrue(dashboardPage.isAtDashboard(), "Dashboard not displayed!");
        System.out.println("✓ TC_ValidLogin: Login successful");
    }

    @Test(priority = 2)
    public void TC_InvalidLogin() {
        loginPage.login(TestData.adminInvalidUsername,TestData.adminInvalidPassword);
        Assert.assertTrue(driver.getCurrentUrl().contains("auth"),
                "Invalid login ");
        System.out.println("✓ TC_InvalidLogin: Invalid login ");
    }
    @Test
    public void testForgotPasswordLink() {

        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot your password?"));
        Assert.assertNotNull(forgotPasswordLink);
        driver.quit();
    }}

