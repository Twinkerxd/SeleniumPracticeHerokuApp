package pages;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShadowDomPage extends BasePage {
    @FindBy(xpath = "//my-paragraph[1]") private WebElement myParagraphElement;

    public ShadowDomPage() {
        PageFactory.initElements(driver,this);
    }

    @Step("Getting hidden shadow dom text")
    public String getHiddenText() {
        SearchContext shadowRoot = myParagraphElement.getShadowRoot();
        WebElement shadowContent = shadowRoot.findElement(By.cssSelector("slot[name='my-text']"));
        /*
            Chrome By.cssSelector() and By.className() are valid, but By.id() and By.tagName() fail with
            \org.openqa.selenium.InvalidArgumentException: invalid argument: invalid locator
            example here: https://titusfortner.com/2021/11/22/shadow-dom-selenium.html
         */

        return shadowContent.getText();
    }
}
