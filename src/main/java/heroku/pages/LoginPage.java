package heroku.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
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


    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void open() {
        formAuthenticationLink.click();
    }

    public void login(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        submitButton.click();
    }

    public void logout() {
        logoutButton.click();
    }

    public String getFlashMessage() {
        return flashMessage.getText();
    }
}
