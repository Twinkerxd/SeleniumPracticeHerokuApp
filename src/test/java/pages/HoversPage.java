package pages;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HoversPage extends BasePage {
    @FindBy(xpath = "//div[@class='figure']") private WebElement firstAvatar;
    @FindBy(xpath = "//a[@href='/users/1']") private WebElement viewProfileLink;
    @FindBy(xpath = "//h1") private WebElement title;

    public HoversPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Mouseover first avatar")
    public HoversPage mouseOverFirstAvatar() {
        Actions action = new Actions(driver);
        action.moveToElement(firstAvatar).perform();
        return this;
    }

    @Step("Clicking view profile")
    public HoversPage viewProfileClick() {
        viewProfileLink.click();
        return this;
    }

    @Step("Getting title text")
    public String getTitle() {
        return title.getText();
    }
}
