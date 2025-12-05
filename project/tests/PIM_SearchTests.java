package com.project.tests;

import com.project.base.BaseTest;
import com.project.pages.EmployeeListPage;
import com.project.pages.LoginPage;
import com.project.pages.DashboardPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PIM_SearchTests extends BaseTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private EmployeeListPage employeeListPage;

    @BeforeClass
    public void setUpPages() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        employeeListPage = new EmployeeListPage(driver);
    }

    // TC_SearchByName
    @Test(priority = 1)
    public void TC_SearchByName() {
        loginPage.login("Admin", "admin123");
        employeeListPage.openEmployeeList();
        employeeListPage.enterEmployeeName("Kero");
        employeeListPage.clickSearch();

        Assert.assertTrue(employeeListPage.isSearchExecuted());
        System.out.println("✓ TC_SearchByName: Search executed");
    }

    // TC_SearchByEmployeeID
    @Test(priority = 2)
    public void TC_SearchByEmployeeID() {
        employeeListPage.openEmployeeList();
        employeeListPage.enterEmployeeId("0392");
        employeeListPage.clickSearch();

        Assert.assertTrue(employeeListPage.isSearchExecuted());
        System.out.println("✓ TC_SearchByEmployeeID: Search executed");
    }

    // TC_SearchInvalidName
    @Test(priority = 3)
    public void TC_SearchInvalidName() {
        employeeListPage.openEmployeeList();
        employeeListPage.enterEmployeeName("XYZ12345");
        employeeListPage.clickSearch();

        Assert.assertTrue(employeeListPage.isNoRecordFoundDisplayed());
        System.out.println("✓ TC_SearchInvalidName: No record found");
    }

    // TC_ResetSearch
    @Test(priority = 4)
    public void TC_ResetSearch() {
        employeeListPage.openEmployeeList();
        employeeListPage.enterEmployeeName("Test");
        employeeListPage.enterEmployeeId("1234");
        employeeListPage.clickReset();

        Assert.assertTrue(employeeListPage.isSearchExecuted());
        System.out.println("✓ TC_ResetSearch: Reset executed");
    }
}
