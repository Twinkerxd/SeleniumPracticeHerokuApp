package pages;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HorizontalSliderPage extends BasePage {
    @FindBy(xpath = "//div[@class='sliderContainer']/input")
    private WebElement slider;

    @FindBy(xpath = "//div[@class='sliderContainer']/span[@id='range']")
    private WebElement sliderValue;

    public HorizontalSliderPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Setting new slider value")
    public HorizontalSliderPage setSliderValue(String direction, double value) {
        do {
            if (direction.equals("right")) {
                slider.sendKeys(Keys.ARROW_RIGHT);
            } else {
                slider.sendKeys(Keys.ARROW_LEFT);
            }
        } while (getSliderValue() != value);

        return this;
    }

    @Step("Getting current slider value")
    public double getSliderValue() {
        return Double.parseDouble(sliderValue.getText());
    }
}
