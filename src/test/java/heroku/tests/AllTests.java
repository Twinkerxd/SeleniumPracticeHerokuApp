package heroku.tests;

import core.BaseSeleniumTests;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.JavascriptExecutor;
import pages.*;

public class AllTests extends BaseSeleniumTests implements TestWatcher {
    private FileUploadPage fileUploadPage;
    private LoginPage loginPage;
    private AddElementsPage addElementsPage;
    private CheckboxesPage checkboxesPage;
    private DropDownPage dropDownPage;
    private BrokenImagesPage brokenImagesPage;
    private EntryAdPage entryAdPage;
    private FloatingMenuPage floatingMenuPage;
    private HorizontalSliderPage horizontalSliderPage;
    private HoversPage hoversPage;
    private InfiniteScrollPage infiniteScrollPage;
    private QueryMenuPage queryMenuPage;
    private AlertsPage alertsPage;
    private MultipleWindowsPage multipleWindowsPage;
    private iFramePage iFramePage;

    private static final String LOGIN = "tomsmith";
    private static final String PASSWORD = "SuperSecretPassword!";

    @Test
    @DisplayName("Successful login")
    public void successfulLogin() {
        loginPage = new MainPage().getLoginPage().login(LOGIN, PASSWORD);
        Assertions.assertTrue(loginPage.getFlashMessage().contains("You logged into a secure area!"));
    }

    @Test
    @DisplayName("Successful logout")
    public void successfulLogout() {
        loginPage = new MainPage().getLoginPage().login(LOGIN, PASSWORD).logout();
        Assertions.assertTrue(loginPage.getFlashMessage().contains("You logged out of the secure area!"));
    }

    @Test
    @DisplayName("Not successful login")
    public void notSuccessfulLogin() {
        loginPage = new MainPage().getLoginPage();

        loginPage.login("InvalidUsername", "InvalidPassword");
        Assertions.assertTrue(loginPage.getFlashMessage().contains("Your username is invalid!"));
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
        checkboxesPage = new MainPage().getCheckBoxesPage();
        Assertions.assertFalse(checkboxesPage.isCheckboxChecked(1));
        Assertions.assertTrue(checkboxesPage.isCheckboxChecked(2));

        checkboxesPage.clickCheckbox(1);
        Assertions.assertTrue(checkboxesPage.isCheckboxChecked(1));
        Assertions.assertTrue(checkboxesPage.isCheckboxChecked(2));

        checkboxesPage.clickCheckbox(2);
        Assertions.assertTrue(checkboxesPage.isCheckboxChecked(1));
        Assertions.assertFalse(checkboxesPage.isCheckboxChecked(2));
    }

    @Test
    @DisplayName("Dropdown")
    public void selectElementDropdown() {
        dropDownPage = new MainPage().getDropDownPage();
        dropDownPage.setDropdownValue(1);
        Assertions.assertTrue(dropDownPage.isOptionSelected(1));
    }

    @Test
    @DisplayName("File upload")
    public void FileUpload() {
        fileUploadPage = new MainPage().getFileUploadPage();
        fileUploadPage.uploadFile("src/horus logo.jpg");
        Assertions.assertEquals("File Uploaded!", fileUploadPage.getTitle());
    }

    @Test
    @DisplayName("Broken images")
    public void brokenImages() {
        brokenImagesPage = new MainPage().getBrokenImagesPage();
        SoftAssertions softAssertions = new SoftAssertions();

        for (String src : brokenImagesPage.getAllSrcImg()) {
            softAssertions.assertThat(brokenImagesPage.isImageHere(src))
                    .isTrue();
        }
        softAssertions.assertAll();
    }

    @Test
    @DisplayName("Entry Ad")
    public void closeAds() throws InterruptedException {
        entryAdPage = new MainPage().getEntryAdPage();

        do {
            entryAdPage.clickHereButtonClick();
            entryAdPage.refreshPage();
            Thread.sleep(1000);
        } while (!entryAdPage.isModalWindowUp());

        entryAdPage.closeButtonClick();
        Assertions.assertFalse(entryAdPage.isModalWindowUp());

    }

    @Test
    @DisplayName("Floating Menu")
    public void floatingMenu() {
        floatingMenuPage = new MainPage().getFloatingMenuPage();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 4275)");
        Assertions.assertEquals("top: 4237px;", floatingMenuPage.getCords());
    }

    @Test
    @DisplayName("Horizontal Slider")
    public void horizontalSlider() {
        horizontalSliderPage = new MainPage().getHorizontalSliderPage();

        horizontalSliderPage.setSliderValue("right", 5);
        Assertions.assertEquals(5, horizontalSliderPage.getSliderValue());
        horizontalSliderPage.setSliderValue("left", 0);
        Assertions.assertEquals(0, horizontalSliderPage.getSliderValue());

//        Another way to slide with mouse click
//        WebElement e = driver.findElement(By.className("Class name of Dragger"));
//        Actions move = new Actions(driver);
//        move.moveToElement(e).clickAndHold().moveByOffset(0,250).release().perform();
    }

    @Test
    @DisplayName("Hover")
    public void hoverAndClick() {
        hoversPage = new MainPage().getHoversPage();

        hoversPage.mouseOver();
        hoversPage.viewProfileClick();
        Assertions.assertEquals("Not Found", hoversPage.getTitle());
    }

    @Test
    @DisplayName("Infinite Scroll")
    public void infiniteScroll() throws InterruptedException {
        infiniteScrollPage = new MainPage().getInfiniteScrollPage();

        Thread.sleep(500); // no-one will see that (need to complete rendering page)

        Assertions.assertEquals(2, infiniteScrollPage.getCountOfParagraphs());
        infiniteScrollPage.scrollToLastParagraph();
        Assertions.assertEquals(3, infiniteScrollPage.getCountOfParagraphs());
    }

    @Test
    @DisplayName("Query Menu Page")
    public void queryMenu() {
        queryMenuPage = new MainPage().getQueryMenuPage();
        mouseOverElement(queryMenuPage.getEnabledElement());
        mouseOverElement(queryMenuPage.getDownloadsElement());
        queryMenuPage.pdfButtonClick();
    }

    @Test
    @DisplayName("Simple alert")
    public void alertCheck() {
        alertsPage = new MainPage().getAlertsPage();
        alertsPage.getAlertButton().click();
        waitForAlertReady().accept();
        Assertions.assertEquals("You successfully clicked an alert", alertsPage.getResult());
    }

    @Test
    @DisplayName("Confirm box")
    public void confirmCheck() {
        alertsPage = new MainPage().getAlertsPage();
        alertsPage.getConfirmButton().click();
        waitForAlertReady().accept();
        Assertions.assertEquals("You clicked: Ok", alertsPage.getResult());

        alertsPage.getConfirmButton().click();
        waitForAlertReady().dismiss();
        Assertions.assertEquals("You clicked: Cancel", alertsPage.getResult());
    }

    @Test
    @DisplayName("Prompt alert")
    public void promptCheck() {
        alertsPage = new MainPage().getAlertsPage();
        alertsPage.getPromptButton().click();
        waitForAlertReady().sendKeys("Horus1613");
        waitForAlertReady().accept();
        Assertions.assertEquals("You entered: Horus1613", alertsPage.getResult());
    }

    @Test
    @DisplayName("Open new tab")
    public void newTab() {
        multipleWindowsPage = new MainPage().getMultipleWindowsPage();
        multipleWindowsPage.getClickHereButton().click();
        Assertions.assertEquals(2, multipleWindowsPage.getAllTabs().size());
        multipleWindowsPage.switchToTab(2);
        Assertions.assertEquals("New Window", multipleWindowsPage.getHeader());
        multipleWindowsPage.closeTab();
        multipleWindowsPage.switchToTab(1);
        Assertions.assertEquals(1, multipleWindowsPage.getAllTabs().size());
    }

    @Test
    @DisplayName("iFrame")
    public void iFrame() {
        iFramePage = new MainPage().getiFramePage();
        iFramePage.iFrameClick();
        iFramePage.sendMessage(")))");
        Assertions.assertEquals("Your content goes here.)))", iFramePage.getText());
    }
}
