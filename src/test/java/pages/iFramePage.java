package pages;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class iFramePage extends BasePage {
    @FindBy(xpath = "//p") private WebElement messageBox;
    @FindBy(xpath = "//iframe") private WebElement iframe;
    @FindBy(xpath = "//a[@href='/iframe']") private WebElement iframeLink;

    public iFramePage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Sending message to iframe")
    public iFramePage sendMessage(String text) {
        driver.switchTo().frame(iframe);
        messageBox.clear();
        messageBox.sendKeys(text);
        return this;
    }

    @Step("Getting text")
    public String getText() {
        return messageBox.getText();
    }

    @Step("Clicking iframe")
    public iFramePage iFrameClick() {
        iframeLink.click();
        return this;
    }
}
