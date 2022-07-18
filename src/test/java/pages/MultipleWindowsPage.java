package pages;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class MultipleWindowsPage extends BasePage {
    @FindBy(xpath = "//a[@href='/windows/new']") private WebElement clickHereButton;
    @FindBy(xpath = "//h3") private WebElement header;

    public MultipleWindowsPage() {
        PageFactory.initElements(driver, this);
    }

    public MultipleWindowsPage clickClickHereButton() {
        clickHereButton.click();
        return this;
    }

    public ArrayList<String> getAllTabs() {
        return new ArrayList<>(driver.getWindowHandles());
    }

    public String getHeader() {
        return header.getText();
    }

    public MultipleWindowsPage closeTab() {
        driver.close();
        return this;
    }
}
