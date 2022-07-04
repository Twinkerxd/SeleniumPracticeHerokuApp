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

    public void clickButton(String name) {
        switch (name) {
            case "Click for JS Alert" -> alertButton.click();
            case "Click for JS Confirm" -> confirmButton.click();
            case "Click for JS Prompt" -> promptButton.click();
        }
    }

    public String getResult() {
        return result.getText();
    }
}
