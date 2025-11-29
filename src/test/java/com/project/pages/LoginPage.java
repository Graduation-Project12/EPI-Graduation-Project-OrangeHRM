package com.project.pages;

import com.project.utils.ElementActions;
import com.project.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton =   By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void login(String username, String password) {
        ElementActions.write(driver, (WebElement) usernameField,username);
        ElementActions.write(driver, (WebElement) passwordField,password);
        ElementActions.click(driver, (WebElement) loginButton);
    }
    public void loginDefaultUser() {
        login("Admin", "admin123");
    }

}
