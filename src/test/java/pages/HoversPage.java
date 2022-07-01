package pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HoversPage extends BaseSeleniumPage {
    @FindBy(xpath = "//div[@class='figure']")
    private WebElement firstAvatar;

    @FindBy(xpath = "//a[@href='/users/1']")
    private WebElement viewProfileLink;

    @FindBy(xpath = "//h1")
    private WebElement title;

    public HoversPage() {
        PageFactory.initElements(driver, this);
    }

    public void mouseOver() {
        Actions action = new Actions(driver);
        action.moveToElement(firstAvatar).perform();
    }

    public void viewProfileClick() {
        viewProfileLink.click();
    }

    public String getTitle() {
        return title.getText();
    }
}
