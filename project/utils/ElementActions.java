package com.project.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementActions {

    public ElementActions() {
    }

    public static void click( WebDriver driver, WebElement element) {
        WaitUtils.waitForVisibilty(driver , element);
        element.click();
    }

    public static void write(WebDriver driver, WebElement element, String text) {
        WaitUtils.waitForVisibilty(driver, element);
        element.clear();
        element.sendKeys(text);
    }

}
