package pages;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DropDownPage extends BasePage {
    @FindBy(id = "dropdown") private WebElement dropdown;
    @FindBy(xpath = "//option") private List<WebElement> dropdownElements;

    public DropDownPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isOptionSelected(int optionNumber) {
        return dropdownElements.get(optionNumber).isSelected();
    }

    public DropDownPage setDropdownValue(int optionNumber) {
        dropdown.click();
        dropdownElements.get(optionNumber).click();
        return this;
    }
}
