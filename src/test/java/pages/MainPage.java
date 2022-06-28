package pages;

import core.BaseSeleniumPage;
import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseSeleniumPage {
//    private FileUploadPage fileUploadPage;
//    private LoginPage loginPage;

    @FindBy(linkText = "File Upload")
    private WebElement fileUpdateLink;

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement formAuthentication;

    public MainPage() {
        //fileUploadPage = new FileUploadPage(driver);
        //loginPage = new LoginPage(driver);

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
