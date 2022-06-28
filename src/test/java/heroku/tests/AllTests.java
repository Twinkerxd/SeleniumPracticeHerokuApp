package heroku.tests;

import core.BaseSeleniumTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AddElementsPage;
import pages.FileUploadPage;
import pages.LoginPage;
import pages.MainPage;

import java.time.Duration;
import java.util.List;

public class AllTests extends BaseSeleniumTests implements TestWatcher {
    private FileUploadPage fileUploadPage;
    private LoginPage loginPage;
    private AddElementsPage addElementsPage;

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
        loginPage = new MainPage().getLoginPage().login(LOGIN,PASSWORD);
        Assertions.assertTrue(loginPage.getFlashMessage().contains("You logged into a secure area!"));
    }

    @Test
    @DisplayName("Successful logout")
    public void successfulLogoutCheck() {
        loginPage = new MainPage().getLoginPage().login(LOGIN,PASSWORD).logout();
        Assertions.assertTrue(loginPage.getFlashMessage().contains("You logged out of the secure area!"));
    }

    @Test
    @DisplayName("Adding elements")
    public void addingElements() {
        addElementsPage = new MainPage().getAddElementsPage();
        Assertions.assertEquals(0, addElementsPage.deleteButtonsList().size());
        addElementsPage.addElement();
        Assertions.assertEquals(1, addElementsPage.deleteButtonsList().size());
    }

    @Test
    @DisplayName("Deleting elements")
    public void deletingElements() {
        addElementsPage = new MainPage().getAddElementsPage();
        Assertions.assertEquals(0, addElementsPage.deleteButtonsList().size());
        addElementsPage.addElement();
        addElementsPage.addElement();
        addElementsPage.addElement();
        addElementsPage.deleteElement();
        Assertions.assertEquals(2, addElementsPage.deleteButtonsList().size());
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
        fileUploadPage = new MainPage().getFileUploadPage();
        fileUploadPage.uploadFile("src/horus logo.jpg");
        Assertions.assertEquals("File Uploaded!", fileUploadPage.getTitle());
    }
}
