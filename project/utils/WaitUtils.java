package com.project.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    private static final int Timeout = 10;

    public static WebElement waitForVisibilty (WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(Timeout))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitAndClick(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(Timeout))
                .until(ExpectedConditions.elementToBeClickable(element))
                .click();
    }

    public static void selectFromDropdown(WebDriver driver, WebElement dropdown, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout));

        wait.until(ExpectedConditions.elementToBeClickable(dropdown)).click();

        WebElement option = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[text()='" + text + "']"))
        );

        option.click();
    }

}
