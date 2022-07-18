package pages;

import core.BasePage;
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

    public int getCountOfParagraphs() {
        return paragraphs.size();
    }

    public void scrollToLastParagraph() {
        scrollToElement(lastParagraph);
    }
}
