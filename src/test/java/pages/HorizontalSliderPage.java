package pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HorizontalSliderPage extends BaseSeleniumPage {
    @FindBy(xpath = "//div[@class='sliderContainer']/input") private WebElement slider;
    @FindBy(xpath = "//div[@class='sliderContainer']/span[@id='range']") private WebElement sliderValue;

    public HorizontalSliderPage() {
        PageFactory.initElements(driver, this);
    }

    public void setSliderValue(String direction, double value) {
        do {
            if (direction.equals("right")) {
                slider.sendKeys(Keys.ARROW_RIGHT);
            } else {
                slider.sendKeys(Keys.ARROW_LEFT);
            }
        } while (getSliderValue() != value);
    }

    public double getSliderValue() {
        return Double.parseDouble(sliderValue.getText());
    }
}
