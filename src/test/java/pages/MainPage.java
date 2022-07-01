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

    @FindBy(xpath = "//a[@href='/dropdown']")
    private WebElement dropDownLink;

    @FindBy(xpath = "//a[@href='/basic_auth']")
    private WebElement basicAuthLink;

    @FindBy(xpath = "//a[@href='/broken_images']")
    private WebElement brokenImagesLink;

    @FindBy(xpath = "//a[@href='/entry_ad']")
    private WebElement entryAdLink;

    @FindBy(xpath = "//a[@href='/floating_menu']")
    private WebElement floatingMenuLink;

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

    public DropDownPage getDropDownPage() {
        dropDownLink.click();
        return new DropDownPage();
    }

    public BasicAuthPage getBasicAuthPage() {
        basicAuthLink.click();
        return new BasicAuthPage();
    }

    public BrokenImagesPage getBrokenImagesPage() {
        brokenImagesLink.click();
        return new BrokenImagesPage();
    }

    public EntryAdPage getEntryAdPage() {
        entryAdLink.click();
        return new EntryAdPage();
    }

    public FloatingMenuPage getFloatingMenuPage() {
        floatingMenuLink.click();
        return new FloatingMenuPage();
    }
}
