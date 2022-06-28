package heroku.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class FileUploadPage {

    @FindBy(linkText = "File Upload")
    private WebElement fileUpdateLink;

    @FindBy(id = "file-upload")
    private WebElement chooseFileButton;

    @FindBy(id = "file-submit")
    private WebElement uploadButton;

    @FindBy(css = "h3")
    private WebElement title;

    public FileUploadPage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);
    }

    public void open() {
        fileUpdateLink.click();
    }

    public void uploadFile(String path) {
        File file = new File(path);
        chooseFileButton.sendKeys(file.getAbsolutePath());
        uploadButton.click();
    }

    public String getTitle() {
        return title.getText();
    }
}
