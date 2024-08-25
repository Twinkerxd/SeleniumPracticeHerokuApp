package pages;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
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

    @Step("Login")
    public LoginPage login(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        submitButton.click();
        return this;
    }

    @Step("Logout")
    public LoginPage logout() {
        logoutButton.click();
        return this;
    }

    @Step("Getting page message")
    public String getFlashMessage() {
        return flashMessage.getText();
    }
}
