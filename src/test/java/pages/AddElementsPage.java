package pages;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddElementsPage extends BasePage {
    @FindBy(xpath = "//button[@onclick='addElement()']")
    private WebElement addButton;

    @FindBy(xpath = "//button[@onclick='deleteElement()']")
    private List<WebElement> deleteButtons;

    public AddElementsPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Adding new element")
    public AddElementsPage addElement() {
        addButton.click();
        return this;
    }

    @Step("Deleting one element")
    public AddElementsPage deleteElement() {
        deleteButtons.get(0).click();
        return this;
    }

    @Step("Get count of delete buttons")
    public int getCountOfDeletedButtons() {
        return deleteButtons.size();
    }
}
