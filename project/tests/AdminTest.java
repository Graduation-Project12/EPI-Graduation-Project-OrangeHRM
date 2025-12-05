package com.project.tests;

import com.project.base.BaseTest;
import com.project.pages.AdminPage;
import com.project.pages.DashboardPage;
import com.project.pages.LoginPage;
import com.project.utils.TestData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Objects;

public class AdminTest extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private AdminPage adminPage;


    @BeforeMethod
    public void setup() {
        loginPage = new LoginPage(driver);
        adminPage = new AdminPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @Test( description = "Verify that the admin can log into the dashboard")
    public void adminCanLogin()
    {
        loginPage.login(TestData.adminUsername,TestData.adminPassword);
        Assert.assertTrue(Objects.requireNonNull((getDriver()).getCurrentUrl()).contains("/dashboard"),
                "Admin login failed ");
    }


    @Test( description = "Create a new user from the Admin panel")
    public void adminCanCreateUser()
    {
        loginPage.login(TestData.adminUsername,TestData.adminPassword);
        adminPage.clickAdminTab();
        adminPage.clickAddButton();
        adminPage.clickUserRoleDropdown();
        adminPage.enterEmployeeName(TestData.employeeName);
        adminPage.clickStatusDropdown();
        adminPage.enterNewUsername(TestData.enterNewUsername);
        adminPage.enterNewPassword(TestData.newPassword);
        adminPage.confirmNewPassword(TestData.newPassword);
        adminPage.clickSaveButton();
    }

    @Test(description = "Verify that admin filter users by Username")
    public void filterByUsername(){
        adminPage.clickAdminTab();
        adminPage.filterByUsername(TestData.enterNewUsername);
        adminPage.clickSearchButton();
    }

    @Test (description = "Verify that admin filter users by UserRole")
    public void filterByUserRole(){
        adminPage.clickAdminTab();
        adminPage.filterByUserRole();
        adminPage.clickSearchButton();

    }

    @Test (description = "Verify that admin filter users by Status ")
    public void filterByStatus(){
        adminPage.filterByStatus();
        adminPage.clickSearchButton();
    }

}
