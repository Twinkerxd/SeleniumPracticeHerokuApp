package pages;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadingPage extends BasePage {
    @FindBy(xpath = "//a[@href='/dynamic_loading/1']")
    private WebElement example1;

    @FindBy(xpath = "//a[@href='/dynamic_loading/2']")
    private WebElement example2;

    @FindBy(xpath = "//div[@id='finish']//h4")
    private WebElement hiddenText;

    @FindBy(xpath = "//button")
    private WebElement startButton;

    public DynamicLoadingPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Opening example 1")
    public DynamicLoadingPage clickExampleOneLink() {
        example1.click();
        return this;
    }

    @Step("Opening example 2")
    public DynamicLoadingPage clickExampleTwoLink() {
        example2.click();
        return this;
    }

    @Step("Getting hidden text")
    public String getHiddenText() {
        waitVisibility(hiddenText);
        return hiddenText.getText();
    }

    @Step("Clicking start button")
    public DynamicLoadingPage clickStartButton() {
        startButton.click();
        return this;
    }
}
