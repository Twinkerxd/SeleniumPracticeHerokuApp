package pages;

import core.BasePage;
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

    public AlertsPage clickAlertButton() {
        alertButton.click();
        return this;
    }

    public AlertsPage clickConfirmButton() {
        confirmButton.click();
        return this;
    }

    public AlertsPage clickPromptButton() {
        promptButton.click();
        return this;
    }

    public String getResult() {
        return result.getText();
    }
}
