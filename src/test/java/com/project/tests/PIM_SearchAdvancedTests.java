package com.project.tests;

import com.project.base.BaseTest;
import com.project.pages.EmployeeListPage;
import com.project.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PIM_SearchAdvancedTests extends BaseTest {

    private LoginPage loginPage;
    private EmployeeListPage employeeListPage;

    @BeforeClass
    public void setUpPages() {
        loginPage = new LoginPage(driver);
        employeeListPage = new EmployeeListPage(driver);
    }

    // ================================
    // TC_SearchByEmploymentStatus
    // ================================
    @Test(priority = 1)
    public void TC_SearchByEmploymentStatus() {
        loginPage.loginDefaultUser();
        employeeListPage.openEmployeeList();
        employeeListPage.selectEmploymentStatus("Full-Time Contract");
        employeeListPage.clickSearch();

        Assert.assertTrue(employeeListPage.isSearchExecuted());
        System.out.println("✓ TC_SearchByEmploymentStatus: Search executed");
    }

    // ================================
    // TC_SearchByJobTitle
    // ================================
    @Test(priority = 2)
    public void TC_SearchByJobTitle() {
        employeeListPage.openEmployeeList();
        employeeListPage.selectJobTitle("QA Engineer");     // FIXED
        employeeListPage.clickSearch();

        Assert.assertTrue(employeeListPage.isSearchExecuted());
        System.out.println("✓ TC_SearchByJobTitle: Search executed");
    }

    // ================================
    // TC_SearchBySubUnit
    // ================================
    @Test(priority = 3)
    public void TC_SearchBySubUnit() {
        employeeListPage.openEmployeeList();
        employeeListPage.selectSubUnit("Engineering");
        employeeListPage.clickSearch();

        Assert.assertTrue(employeeListPage.isSearchExecuted());
        System.out.println("✓ TC_SearchBySubUnit: Search executed");
    }

    // ================================
    // TC_SearchWithMultipleFilters
    // ================================
    @Test(priority = 4)
    public void TC_SearchWithMultipleFilters() {
        employeeListPage.openEmployeeList();
        employeeListPage.selectEmploymentStatus("Full-Time Contract");
        employeeListPage.selectJobTitle("QA Engineer");     // FIXED
        employeeListPage.selectSubUnit("Engineering");
        employeeListPage.clickSearch();

        Assert.assertTrue(employeeListPage.isSearchExecuted());
        System.out.println("✓ TC_SearchWithMultipleFilters: Multi-filter search executed");
    }
}
