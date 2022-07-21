package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NestedFramesPage extends BasePage {
    @FindBy(xpath = "//frame[@name='frame-top']") private WebElement top;

    public NestedFramesPage() {
        PageFactory.initElements(driver,this);
    }

    public String iframeText(Enum iframeName) {
        if (iframeName != frame.bottom) {
            driver
                    .switchTo()
                    .frame(top);
        }
        return driver
                .switchTo()
                .frame(driver.findElement(By.xpath("//frame[@name='frame-"+iframeName+"']")))
                .findElement(By.cssSelector("#content"))
                .getText();

    }

    public enum frame {
        top, bottom, left, right, middle
    }
}
