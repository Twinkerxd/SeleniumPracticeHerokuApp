package pages;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class BrokenImagesPage extends BasePage {
    @FindBy(xpath = "//div[@class='example']//img") private List<WebElement> images;
    @FindBy(xpath = "//img") private WebElement image;
    @FindBy(xpath = "//h1") private WebElement header;

    public BrokenImagesPage() {
        PageFactory.initElements(driver, this);
    }

    public ArrayList<String> getAllSrcImg() {
        ArrayList<String> str = new ArrayList<>();

        for (WebElement x : images) {
            str.add(x.getAttribute("src"));
        }
        return str;
    }

    public boolean isImageHere(String src) {
        driver.get(src);
        return isElementDisplayed(image);
    }
}
