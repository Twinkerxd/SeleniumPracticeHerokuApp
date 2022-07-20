package pages;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InfiniteScrollPage extends BasePage {
    @FindBy(xpath = "//div[@class='jscroll-added']") private List<WebElement> paragraphs;
    @FindBy(xpath = "//div[@class='jscroll-added'][last()]") private WebElement lastParagraph;

    public InfiniteScrollPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Getting count of paragraphs")
    public int getCountOfParagraphs() {
        return paragraphs.size();
    }

    @Step("Scrolling to the last paragraph")
    public void scrollToLastParagraph() {
        scrollToElement(lastParagraph);
    }
}
