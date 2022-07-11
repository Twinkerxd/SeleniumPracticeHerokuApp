package pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseSeleniumPage {

    @FindBy(xpath = "//a[@href='/upload']") private WebElement fileUpdateLink;
    @FindBy(xpath = "//a[@href='/login']") private WebElement formAuthenticationLink;
    @FindBy(xpath = "//a[@href='/add_remove_elements/']") private WebElement addElementsLink;
    @FindBy(xpath = "//a[@href='/checkboxes']") private WebElement checkboxesLink;
    @FindBy(xpath = "//a[@href='/dropdown']") private WebElement dropDownLink;
    @FindBy(xpath = "//a[@href='/basic_auth']") private WebElement basicAuthLink;
    @FindBy(xpath = "//a[@href='/broken_images']") private WebElement brokenImagesLink;
    @FindBy(xpath = "//a[@href='/entry_ad']") private WebElement entryAdLink;
    @FindBy(xpath = "//a[@href='/floating_menu']") private WebElement floatingMenuLink;
    @FindBy(xpath = "//a[@href='/horizontal_slider']") private WebElement horizontalSliderLink;
    @FindBy(xpath = "//a[@href='/hovers']") private WebElement hoversLink;
    @FindBy(xpath = "//a[@href='/infinite_scroll']") private WebElement infiniteScrollLink;
    @FindBy(xpath = "//a[@href='/jqueryui/menu']") private WebElement jQueryUiMenuLink;
    @FindBy(xpath = "//a[@href='/javascript_alerts']") private WebElement alertsLink;
    @FindBy(xpath = "//a[@href='/windows']") private WebElement multipleWindowsLink;
    @FindBy(xpath = "//a[@href='/frames']") private WebElement iframeLink;


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

    public HorizontalSliderPage getHorizontalSliderPage() {
        horizontalSliderLink.click();
        return new HorizontalSliderPage();
    }

    public HoversPage getHoversPage() {
        hoversLink.click();
        return new HoversPage();
    }

    public InfiniteScrollPage getInfiniteScrollPage() {
        infiniteScrollLink.click();
        return new InfiniteScrollPage();
    }

    public QueryMenuPage getQueryMenuPage() {
        jQueryUiMenuLink.click();
        return new QueryMenuPage();
    }

    public AlertsPage getAlertsPage() {
        alertsLink.click();
        return new AlertsPage();
    }

    public MultipleWindowsPage getMultipleWindowsPage() {
        multipleWindowsLink.click();
        return new MultipleWindowsPage();
    }

    public iFramePage getiFramePage() {
        iframeLink.click();
        return new iFramePage();
    }
}
