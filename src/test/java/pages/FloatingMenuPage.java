package pages;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FloatingMenuPage extends BasePage {
    @FindBy(css = "div#menu") private WebElement menu;

    public FloatingMenuPage() {
        PageFactory.initElements(driver, this);
    }

    public String getMenuCoordinates() {
        return menu.getAttribute("style");
    }

    @Step("Scrolling page")
    public void scrollPageFirst() {
        scrollPage();
    }
}
