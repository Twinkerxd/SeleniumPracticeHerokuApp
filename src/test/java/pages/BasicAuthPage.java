package pages;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasicAuthPage extends BasePage {

    @FindBy(xpath = "//p") private WebElement text;

    BasicAuthPage() {
        PageFactory.initElements(driver, this);
    }

    public String getTextPage() {
        return text.getText();
    }
}
