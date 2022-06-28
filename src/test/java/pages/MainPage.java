package pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseSeleniumPage {

    @FindBy(linkText = "File Upload")
    private WebElement fileUpdateLink;

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement formAuthentication;

    public MainPage() {
        PageFactory.initElements(driver,this);
    }

    public FileUploadPage getFileUploadPage() {
        fileUpdateLink.click();
        return new FileUploadPage();
    }

    public LoginPage getLoginPage() {
        formAuthentication.click();
        return new LoginPage();
    }
}
