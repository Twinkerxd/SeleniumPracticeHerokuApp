package pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class iFramePage extends BaseSeleniumPage {
    @FindBy(xpath = "//p") private WebElement messageBox;
    @FindBy(xpath = "//iframe") private WebElement iframe;
    @FindBy(xpath = "//a[@href='/iframe']") private WebElement iframeLink;

    public iFramePage() {
        PageFactory.initElements(driver, this);
    }

    public iFramePage sendMessage(String text) {
        driver.switchTo().frame(iframe);
        messageBox.clear();
        messageBox.sendKeys(text);
        return this;
    }

    public String getText() {
        return messageBox.getText();
    }

    public iFramePage iFrameClick() {
        iframeLink.click();
        return this;
    }
}
