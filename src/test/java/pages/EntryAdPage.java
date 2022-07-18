package pages;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EntryAdPage extends BasePage {
    @FindBy(xpath = "//div[@class='modal-footer']") private WebElement closeButton;
    @FindBy(xpath = "//div[@id='modal']") private WebElement modalWindow;
    @FindBy(xpath = "//a[@id='restart-ad']") private WebElement clickHereButton;

    public EntryAdPage() {
        PageFactory.initElements(driver, this);
    }

    public void closeButtonClick() {
        closeButton.click();
    }

    public boolean isModalWindowUp() {
        return modalWindow.getAttribute("style").equals("display: block;");
    }

    public void clickHereButtonClick() {
        clickHereButton.click();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }
}
