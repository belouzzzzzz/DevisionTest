package org.example;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.Duration.ofSeconds;
import static org.example.DevisionMainPage.Result;

public class TestLogic {
    public static WebDriver driver;
    public static DevisionMainPage devisionMainPage;
    public static String url = "https://devision.io/";
    public static String mail = "test@test.ru";
    public static String name = "Yarolyan";
    public static String phone = "+712312312312";

    @BeforeClass
    public static void setDevisionMainPage() {
        System.setProperty("webdriver.chrome.driver", "/Users/alekseybelousov/Downloads/chromedriver_mac64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
        driver.get(url);

        devisionMainPage = new DevisionMainPage(driver);
    }

    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
    @Test
    public void DevisionTest() {
        DevisionMainPage.inputMail(mail);
        DevisionMainPage.inputName(name);
        DevisionMainPage.inputPhone(phone);
        DevisionMainPage.clickSendButton();

        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(2));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(Result));

        Assert.assertEquals(DevisionMainPage.getResult(), "Спасибо! Данные успешно отправлены.");
    }
}
