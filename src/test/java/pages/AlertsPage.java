package pages;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage extends BasePage {
    @FindBy(xpath = "//button[text()='Click for JS Alert']") private WebElement alertButton;
    @FindBy(xpath = "//button[text()='Click for JS Confirm']") private WebElement confirmButton;
    @FindBy(xpath = "//button[text()='Click for JS Prompt']") private WebElement promptButton;
    @FindBy(id = "result") private WebElement result;

    public AlertsPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Clicking alert button")
    public AlertsPage clickAlertButton() {
        alertButton.click();
        return this;
    }

    @Step("Clicking confirm button")
    public AlertsPage clickConfirmButton() {
        confirmButton.click();
        return this;
    }

    @Step("Clicking prompt button")
    public AlertsPage clickPromptButton() {
        promptButton.click();
        return this;
    }

    @Step("Getting result text")
    public String getResult() {
        return result.getText();
    }

    @Step("Clicking alert accept")
    public void clickAlertAccept() {
        waitForAlertReady().accept();
    }

    @Step("Clicking alert dismiss")
    public void clickAlertDismiss() {
        waitForAlertReady().dismiss();
    }

    @Step("Sending alert value")
    public void setAlertValue(String text) {
        waitForAlertReady().sendKeys(text);
    }
}
