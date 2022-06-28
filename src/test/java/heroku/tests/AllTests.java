package heroku.tests;

import heroku.pages.FileUploadPage;
import heroku.pages.HerokuAppSite;
import heroku.pages.LoginPage;
import org.apache.commons.logging.Log;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@ExtendWith(TestListener.class)
public class AllTests extends BaseTests {
    private FileUploadPage fileUploadPage;
    private HerokuAppSite herokuAppSite;
    private LoginPage loginPage;

    private static final String LOGIN = "tomsmith";
    private static final String PASSWORD = "SuperSecretPassword!";

    @Test
    @DisplayName("Current URL")
    public void urlCheck() {
        Assertions.assertEquals("https://the-internet.herokuapp.com/", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Title of the page")
    public void titleCheck() {
        Assertions.assertEquals("The Internet", driver.getTitle());
    }

    @Test
    @DisplayName("Successful login")
    public void successfulLoginCheck() {
        loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login(LOGIN, PASSWORD);

        Assertions.assertTrue(loginPage.getFlashMessage().contains("You logged into a secure area!"));
    }

    @Test
    @DisplayName("Successful logout")
    public void successfulLogoutCheck() {
        loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login(LOGIN, PASSWORD);
        loginPage.logout();

        Assertions.assertTrue(loginPage.getFlashMessage().contains("You logged out of the secure area!"));
    }

    @Test
    @DisplayName("Adding elements")
    public void addingElements() {
        driver.findElement(By.xpath("//a[text()='Add/Remove Elements']")).click();
        // need to check that we dont have elements before adding a new one
        Assertions.assertTrue(driver.findElements(By.className("added-manually")).isEmpty());

        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        Assertions.assertEquals(1, driver.findElements(By.className("added-manually")).size());

    }

    @Test
    @DisplayName("Deleting elements")
    public void deletingElements() {
        driver.findElement(By.xpath("//a[text()='Add/Remove Elements']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();

        // deleting one element
        driver.findElement(By.className("added-manually")).click();

        Assertions.assertEquals(1, driver.findElements(By.className("added-manually")).size());
    }

    @Test
    @DisplayName("Checkboxes")
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
    @DisplayName("Dropdown")
    public void selectElementDropdown() {
        driver.findElement(By.xpath("//a[text()='Dropdown']")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//option[text()='Please select an option']")).isSelected());
        driver.findElement(By.id("dropdown")).click();
        driver.findElement(By.xpath("//option[text()='Option 1']")).click();

        Assertions.assertTrue(driver.findElement(By.xpath("//option[text()='Option 1']")).isSelected());
    }

    @Test
    @DisplayName("Heading")
    public void headingCheck() {
        // explicit wait example
        WebDriverWait expWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        expWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".heading")));

        Assertions.assertEquals("Welcome to the-internet", driver.findElement(By.cssSelector(".heading")).getText());
        //driver.findElement(By.cssSelector(".heading")).getText().equals("Welcome to the-internet")
    }

    @Test
    @DisplayName("File upload")
    public void checkFileUpload() {
        fileUploadPage = new FileUploadPage(driver);
        fileUploadPage.open();
        fileUploadPage.uploadFile("src/horus logo.jpg");

        Assertions.assertEquals("File Uploaded!", fileUploadPage.getTitle());
    }
}
