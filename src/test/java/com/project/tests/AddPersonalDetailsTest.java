package com.project.tests;

import com.project.base.BaseTest;
import com.project.pages.LoginPage;
import com.project.pages.MyInfoPage;
import com.project.utils.TestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddPersonalDetailsTest extends BaseTest
{
    private WebDriver driver;
    private LoginPage loginPage;
    private MyInfoPage myInfoPage;

    @BeforeClass
    public void setUp() {
        // Initialize Chrome browser
        driver = new ChromeDriver();
        // Maximize window
        driver.manage().window().maximize();
        // Navigate to Login Page
        // Initialize page classes
        loginPage = new LoginPage(driver);
        myInfoPage = new MyInfoPage(driver);
    }

    @Test()
    public void AddPersonalDetails_SoftAssert() {

        SoftAssert soft = new SoftAssert();

        loginPage.login(TestData.adminUsername,TestData.adminPassword);
        myInfoPage.openMyInfoPage();

        myInfoPage.setFirstName("Zeyad");
        soft.assertTrue(myInfoPage.isFirstNameUpdated("Zeyad"));

        myInfoPage.setLastName("Osama");
        soft.assertTrue(myInfoPage.isLastNameUpdated("Osama"));

        myInfoPage.setNationality("Canadian");
        soft.assertTrue(myInfoPage.isNationalityUpdated("Canadian"));

        myInfoPage.setMaritalStatus("Married");
        soft.assertTrue(myInfoPage.isMaritalStatusUpdated("Married"));

        myInfoPage.setGender("Female");
        soft.assertTrue(myInfoPage.isGenderUpdated("female"));

        myInfoPage.setDateOfBirth("2000-08-02");
        soft.assertTrue(myInfoPage.isDateOfBirthUpdated("2000-08-02"));

        myInfoPage.clickSave();

        soft.assertAll();
    }
}
