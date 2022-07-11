package pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddElementsPage extends BaseSeleniumPage {
    @FindBy(xpath = "//button[@onclick='addElement()']")
    private WebElement addButton;
    @FindBy(xpath = "//button[@onclick='deleteElement()']")
    private List<WebElement> deleteButtons;

    public AddElementsPage() {
        PageFactory.initElements(driver, this);
    }

    public void addElement() {
        addButton.click();
    }

    public void deleteElement() {
        deleteButtons.get(0).click();
    }

    public List<WebElement> deleteButtonsList() {
        return deleteButtons;
    }
}
