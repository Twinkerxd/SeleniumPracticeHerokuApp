package heroku.pages;

import org.openqa.selenium.WebDriver;

public class HerokuAppSite {
    private final FileUploadPage fileUploadPage;


    public HerokuAppSite(WebDriver driver) {

        fileUploadPage = new FileUploadPage(driver);
    }

    public FileUploadPage getFileUploadPage() {
        return fileUploadPage;
    }
}
