package pages;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

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
    @FindBy(xpath = "//a[@href='/dynamic_loading']") private WebElement dynamicLoadingLink;
    @FindBy(xpath = "//a[@href='/shadowdom']") private WebElement shadowDomLink;
    @FindBy(xpath = "//a[@href='/nested_frames']") private WebElement nestedFrames;

    public MainPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Opening file upload page")
    public FileUploadPage getFileUploadPage() {
        fileUpdateLink.click();
        return new FileUploadPage();
    }

    @Step("Opening login page")
    public LoginPage getLoginPage() {
        formAuthenticationLink.click();
        return new LoginPage();
    }

    @Step("Opening elements page")
    public AddElementsPage getAddElementsPage() {
        addElementsLink.click();
        return new AddElementsPage();
    }

    @Step("Opening checkboxes page")
    public CheckboxesPage getCheckBoxesPage() {
        checkboxesLink.click();
        return new CheckboxesPage();
    }

    @Step("Opening dropdown page")
    public DropDownPage getDropDownPage() {
        dropDownLink.click();
        return new DropDownPage();
    }

    public BasicAuthPage getBasicAuthPage() {
        basicAuthLink.click();
        return new BasicAuthPage();
    }

    @Step("Opening images page")
    public BrokenImagesPage getBrokenImagesPage() {
        brokenImagesLink.click();
        return new BrokenImagesPage();
    }

    @Step("Opening entry page")
    public EntryAdPage getEntryAdPage() {
        entryAdLink.click();
        return new EntryAdPage();
    }

    @Step("Opening floating menu page")
    public FloatingMenuPage getFloatingMenuPage() {
        floatingMenuLink.click();
        return new FloatingMenuPage();
    }

    @Step("Opening slider page")
    public HorizontalSliderPage getHorizontalSliderPage() {
        horizontalSliderLink.click();
        return new HorizontalSliderPage();
    }

    @Step("Opening hovers page")
    public HoversPage getHoversPage() {
        hoversLink.click();
        return new HoversPage();
    }

    @Step("Opening scroll page")
    public InfiniteScrollPage getInfiniteScrollPage() {
        infiniteScrollLink.click();
        return new InfiniteScrollPage();
    }

    @Step("Opening query menu page")
    public QueryMenuPage getQueryMenuPage() {
        jQueryUiMenuLink.click();
        return new QueryMenuPage();
    }

    @Step("Opening alerts page")
    public AlertsPage getAlertsPage() {
        alertsLink.click();
        return new AlertsPage();
    }

    @Step("Opening multiple windows page")
    public MultipleWindowsPage getMultipleWindowsPage() {
        multipleWindowsLink.click();
        return new MultipleWindowsPage();
    }

    @Step("Opening iframe page")
    public iFramePage getiFramePage() {
        iframeLink.click();
        return new iFramePage();
    }

    @Step("Opening dynamic loading page")
    public DynamicLoadingPage getDynamicLoadingPage() {
        dynamicLoadingLink.click();
        return new DynamicLoadingPage();
    }

    @Step("Opening shadow dom page")
    public ShadowDomPage getShadowDomPage() {
        shadowDomLink.click();
        return new ShadowDomPage();
    }

    @Step("Opening nested frames page")
    public NestedFramesPage getNestedFramesPage() {
        nestedFrames.click();
        return new NestedFramesPage();
    }
}
