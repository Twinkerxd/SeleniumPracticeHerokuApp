package pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseSeleniumPage {

    @FindBy(xpath = "//a[@href='/upload']")
    private WebElement fileUpdateLink;

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement formAuthenticationLink;

    @FindBy(xpath = "//a[@href='/add_remove_elements/']")
    private WebElement addElementsLink;

    @FindBy(xpath = "//a[@href='/checkboxes']")
    private WebElement checkboxesLink;

    public MainPage() {
        PageFactory.initElements(driver, this);
    }

    public FileUploadPage getFileUploadPage() {
        fileUpdateLink.click();
        return new FileUploadPage();
    }

    public LoginPage getLoginPage() {
        formAuthenticationLink.click();
        return new LoginPage();
    }

    public AddElementsPage getAddElementsPage() {
        addElementsLink.click();
        return new AddElementsPage();
    }

    public CheckboxesPage getCheckBoxesPage() {
        checkboxesLink.click();
        return new CheckboxesPage();
    }
}
