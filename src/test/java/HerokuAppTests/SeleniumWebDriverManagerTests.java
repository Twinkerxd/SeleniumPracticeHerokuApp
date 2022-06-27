package HerokuAppTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumWebDriverManagerTests {
    private static final String URL = "https://the-internet.herokuapp.com/";
    private static final String LOGIN = "tomsmith";
    private static final String PASSWORD = "SuperSecretPassword!";

    WebDriver driver;

    @BeforeEach
    public void preparingTests() {
        WebDriverManager.chromedriver().setup(); // installing WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS); // Added timeouts for all tests
    }

    @Test
    @DisplayName("Checking current URL")
    public void urlCheck() {
        Assertions.assertEquals("https://the-internet.herokuapp.com/", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Checking title of the page")
    public void titleCheck() {
        Assertions.assertEquals("The Internet", driver.getTitle());
    }

    @Test
    @DisplayName("Checking successful login message")
    public void successfulLoginCheck() {
        driver.findElement(By.xpath("//a[text()='Form Authentication']")).click();
        driver.findElement(By.id("username")).sendKeys(LOGIN);
        driver.findElement(By.id("password")).sendKeys(PASSWORD);
        driver.findElement(By.className("radius")).click();

        String successfulLoginMessage = driver.findElement(By.id("flash")).getText();
        Assertions.assertTrue(successfulLoginMessage.contains("You logged into a secure area!"));
    }

    @Test
    @DisplayName("Checking successful logout")
    public void successfulLogoutCheck() {
        driver.findElement(By.xpath("//a[text()='Form Authentication']")).click();
        driver.findElement(By.id("username")).sendKeys(LOGIN);
        driver.findElement(By.id("password")).sendKeys(PASSWORD);
        driver.findElement(By.className("radius")).click();
        driver.findElement(By.xpath("//i[@class='icon-2x icon-signout']")).click();

        String successfulLogoutMessage = driver.findElement(By.id("flash")).getText();
        Assertions.assertTrue(successfulLogoutMessage.contains("You logged out of the secure area!"));
    }

    @Test
    @DisplayName("Checking adding elements")
    public void addingElements() {
        driver.findElement(By.xpath("//a[text()='Add/Remove Elements']")).click();
        // need to check that we dont have elements before adding a new one
        Assertions.assertTrue(driver.findElements(By.className("added-manually")).isEmpty());

        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        Assertions.assertEquals(1, driver.findElements(By.className("added-manually")).size());

    }

    @Test
    @DisplayName("Checking deleting elements")
    public void deletingElements() {
        driver.findElement(By.xpath("//a[text()='Add/Remove Elements']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();

        // deleting one element
        driver.findElement(By.className("added-manually")).click();

        Assertions.assertEquals(1, driver.findElements(By.className("added-manually")).size());
    }

    @Test
    @DisplayName("Checking checkboxes")
    public void selectingCheckboxes() {
        driver.findElement(By.xpath("//a[text()='Checkboxes']")).click();
        String checkboxPath = "//input[@type='checkbox']";
        List<WebElement> checkboxes = driver.findElements(By.xpath(checkboxPath));

        Assertions.assertFalse(checkboxes.get(0).isSelected());
        Assertions.assertTrue(checkboxes.get(1).isSelected());

        driver.findElement(By.xpath(checkboxPath)).click();
        Assertions.assertTrue(checkboxes.get(0).isSelected());
        Assertions.assertTrue(checkboxes.get(1).isSelected());

        driver.findElement(By.xpath(checkboxPath)).click();
        Assertions.assertFalse(checkboxes.get(0).isSelected());
        Assertions.assertTrue(checkboxes.get(1).isSelected());
    }

    @Test
    @DisplayName("Checking dropdown")
    public void selectElementDropdown() {
        driver.findElement(By.xpath("//a[text()='Dropdown']")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//option[text()='Please select an option']")).isSelected());
        driver.findElement(By.id("dropdown")).click();
        driver.findElement(By.xpath("//option[text()='Option 1']")).click();

        Assertions.assertTrue(driver.findElement(By.xpath("//option[text()='Option 1']")).isSelected());
    }

    @Test
    public void headingCheck() {
        // explicit wait example
        WebDriverWait expWait = new WebDriverWait(driver, 4, 500);
        expWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".heading")));

        Assertions.assertEquals("Welcome to the-internet", driver.findElement(By.cssSelector(".heading")).getText());
        //driver.findElement(By.cssSelector(".heading")).getText().equals("Welcome to the-internet")
    }

    @Test
    public void fileUploadCheck() {
        File file = new File("src/horus logo.jpg");
        driver.findElement(By.xpath("//a[text()='File Upload']")).click();
        driver.findElement(By.id("file-upload")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.className("button")).click();

        Assertions.assertTrue(driver.findElement(By.xpath("//h3[text()='File Uploaded!']")).isDisplayed());
    }

    @AfterEach
    public void closingBrowser() {
        driver.quit();
    }
}
