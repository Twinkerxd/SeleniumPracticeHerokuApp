package pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseSeleniumPage {
    @FindBy(linkText = "Form Authentication")
    private WebElement formAuthenticationLink;

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//a[@href='/logout']")
    private WebElement logoutButton;

    @FindBy(id = "flash")
    private WebElement flashMessage;


    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public LoginPage login(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        submitButton.click();
        return this;
    }

    public LoginPage logout() {
        logoutButton.click();
        return this;
    }

    public String getFlashMessage() {
        return flashMessage.getText();
    }
}
