package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DevisionMainPage {
    public WebDriver driver;

    public DevisionMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "/html/body/div[1]/div[13]/div/div/table/tbody/tr/td[2]/div/div[3]/form/div[2]/div[1]/div/input")
    static
    WebElement eMailField;

    @FindBy(xpath = "/html/body/div[1]/div[13]/div/div/table/tbody/tr/td[2]/div/div[3]/form/div[2]/div[2]/div/input")
    static
    WebElement nameField;

    @FindBy(xpath = "/html/body/div[1]/div[13]/div/div/table/tbody/tr/td[2]/div/div[3]/form/div[2]/div[3]/div/input")
    static
    WebElement phoneField;

    @FindBy(xpath = "/html/body/div[1]/div[13]/div/div/table/tbody/tr/td[2]/div/div[3]/form/div[2]/div[5]/button")
    static
    WebElement sendButton;

    @FindBy(xpath = "/html/body/div[1]/div[13]/div/div/table/tbody/tr/td[2]/div/div[3]/form/div[1]")
    static
    WebElement Result;

    public static void inputMail(String mail) {
        eMailField.sendKeys(mail);
    }

    public static void inputName(String name) {
        nameField.sendKeys(name);
    }

    public static void inputPhone(String phone) {
        phoneField.sendKeys(phone);
    }

    public static void clickSendButton() {
        sendButton.click();
    }

    public static String getResult() {

        return Result.getText();
    }
}
