package pages;

import core.BaseSeleniumTests;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage extends BaseSeleniumTests {
    @FindBy(xpath = "//button[text()='Click for JS Alert']")
    private WebElement alertButton;

    @FindBy(xpath = "//button[text()='Click for JS Confirm']")
    private WebElement confirmButton;

    @FindBy(xpath = "//button[text()='Click for JS Prompt']")
    private WebElement promptButton;

    @FindBy(id = "result")
    private WebElement result;

    public AlertsPage() {
        PageFactory.initElements(driver, this);
    }

    public WebElement getAlertButton() {
        return alertButton;
    }

    public WebElement getConfirmButton() {
        return confirmButton;
    }

    public WebElement getPromptButton() {
        return promptButton;
    }

    public String getResult() {
        return result.getText();
    }
}
