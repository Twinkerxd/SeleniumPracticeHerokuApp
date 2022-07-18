package pages;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class FileUploadPage extends BasePage {
    @FindBy(linkText = "File Upload") private WebElement fileUpdateLink;
    @FindBy(id = "file-upload") private WebElement chooseFileButton;
    @FindBy(id = "file-submit") private WebElement uploadButton;
    @FindBy(css = "h3") private WebElement title;

    public FileUploadPage() {
        PageFactory.initElements(driver, this);
    }

    public FileUploadPage uploadFile(String path) {
        File file = new File(path);
        chooseFileButton.sendKeys(file.getAbsolutePath());
        uploadButton.click();
        return this;
    }

    public String getTitle() {
        return title.getText();
    }
}
