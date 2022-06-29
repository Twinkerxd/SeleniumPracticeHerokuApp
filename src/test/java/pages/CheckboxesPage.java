package pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckboxesPage extends BaseSeleniumPage {
    @FindBy(xpath = "//input[@type='checkbox']")
    private List<WebElement> checkboxes;

    public CheckboxesPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isCheckboxChecked(int checkboxPageNumber) {
        return checkboxes.get(checkboxPageNumber - 1).isSelected();
    }

    public void clickCheckbox(int checkboxPageNumber) {
        checkboxes.get(checkboxPageNumber - 1).click();
    }
}
