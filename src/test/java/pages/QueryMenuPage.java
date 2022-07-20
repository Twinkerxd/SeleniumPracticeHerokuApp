package pages;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QueryMenuPage extends BasePage {
    @FindBy(id = "ui-id-3") private WebElement enabled;
    @FindBy(id = "ui-id-4") private WebElement downloads;
    @FindBy(id = "ui-id-5") private WebElement pdf;

    public QueryMenuPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Mouseover enabled element")
    public void mouseoverEnabledElement() {
        mouseOverElement(enabled);
    }

    @Step("Mouseover downloads element")
    public void mouseoverDownloadsElement() {
        mouseOverElement(downloads);
    }

    @Step("Clicking pdf button")
    public void pdfButtonClick() {
        pdf.click();
    }
}
