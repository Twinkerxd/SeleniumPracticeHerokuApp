package pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QueryMenuPage extends BaseSeleniumPage {
    @FindBy(id = "ui-id-3")
    private WebElement enabled;
    @FindBy(id = "ui-id-4")
    private WebElement downloads;
    @FindBy(id = "ui-id-5")
    private WebElement pdf;

    public QueryMenuPage() {
        PageFactory.initElements(driver, this);
    }

    public WebElement getEnabledElement() {
        return enabled;
    }

    public WebElement getDownloadsElement() {
        return downloads;
    }

    public void pdfButtonClick() {
        pdf.click();
    }
}
