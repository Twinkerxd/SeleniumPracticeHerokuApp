package pages;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckboxesPage extends BasePage {
    @FindBy(xpath = "//input[@type='checkbox']") private List<WebElement> checkboxes;

    public CheckboxesPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Is checkbox checked")
    public boolean isCheckboxChecked(int checkboxPageNumber) {
        return checkboxes.get(checkboxPageNumber - 1).isSelected();
    }

    public void clickCheckbox(int checkboxPageNumber) {
        checkboxes.get(checkboxPageNumber - 1).click();
    }
}
