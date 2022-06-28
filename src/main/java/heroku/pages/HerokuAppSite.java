package heroku.pages;

import org.openqa.selenium.WebDriver;

public class HerokuAppSite {
    private final FileUploadPage fileUploadPage;
    private final LoginPage loginPage;

    public HerokuAppSite(WebDriver driver) {
        fileUploadPage = new FileUploadPage(driver);
        loginPage = new LoginPage(driver);
    }

    public FileUploadPage getFileUploadPage() {
        return fileUploadPage;
    }
}
