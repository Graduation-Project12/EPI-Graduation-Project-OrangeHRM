package com.project.tests;

import com.project.pages.LoginPage;
import com.project.pages.MyInfoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddPersonalDetailsTest
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
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // Initialize page classes
        loginPage = new LoginPage(driver);
        myInfoPage = new MyInfoPage(driver);
    }

    @Test()
          public void AddPersonalDetails() {
        loginPage.login("Admin", "admin123");
        myInfoPage.openMyInfoPage();
        myInfoPage.setFirstName("Zeyad");
        myInfoPage.setLastName("Osama");
        myInfoPage.setNationality("Canadian");
        myInfoPage.setMaritalStatus("Married");
        myInfoPage.setGender("female");
        myInfoPage.setDateOfBirth("2000-08-02");
        myInfoPage.clickSave();
    }
}
