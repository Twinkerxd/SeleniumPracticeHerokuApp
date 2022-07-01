package pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FloatingMenuPage extends BaseSeleniumPage {
    @FindBy(css = "div#menu")
    private WebElement menu;

    public FloatingMenuPage() {
        PageFactory.initElements(driver, this);
    }

    public String getCords() {
        return menu.getAttribute("style");
    }
}
