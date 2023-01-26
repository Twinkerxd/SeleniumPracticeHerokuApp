package heroku.tests;

import core.BaseTests;
import io.qameta.allure.Epic;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Epic("Other")
@DisplayName("All tests suit")
public class AllTests extends BaseTests implements TestWatcher {
    private AddElementsPage addElementsPage;
    private CheckboxesPage checkboxesPage;
    private AlertsPage alertsPage;

    private static final String LOGIN = "tomsmith";
    private static final String PASSWORD = "SuperSecretPassword!";

    /**
     * All tests description
     */

    @Test
    @DisplayName("Successful login")
    public void successfulLogin() {
        assertThat(new MainPage()
                .getLoginPage()
                .login(LOGIN, PASSWORD)
                .getFlashMessage()
                .contains("You logged into a secure area!"));
    }

    @Test
    @DisplayName("Successful logout")
    public void successfulLogout() {
        assertThat(new MainPage()
                .getLoginPage()
                .login(LOGIN, PASSWORD)
                .logout()
                .getFlashMessage()
                .contains("You logged out of the secure area!"));
    }

    @Test
    @DisplayName("Not successful login")
    public void notSuccessfulLogin() {
        assertThat(new MainPage()
                .getLoginPage()
                .login("InvalidUsername", "InvalidPassword")
                .getFlashMessage()
                .contains("Your username is invalid!"));
    }

    @Test
    @DisplayName("Adding elements")
    public void addingElements() {
        addElementsPage = new MainPage().getAddElementsPage();

        assertThat(addElementsPage
                .getCountOfDeletedButtons())
                .isEqualTo(0);

        assertThat(addElementsPage
                .addElement()
                .getCountOfDeletedButtons())
                .isEqualTo(1);
    }

    @Test
    @DisplayName("Deleting elements")
    public void deletingElements() {
        addElementsPage = new MainPage()
                .getAddElementsPage();

        assertThat(addElementsPage
                .getCountOfDeletedButtons())
                .isEqualTo(0);

        assertThat(addElementsPage
                .addElement()
                .addElement()
                .addElement()
                .deleteElement()
                .getCountOfDeletedButtons())
                .isEqualTo(2);
    }

    @Test
    @DisplayName("Checkboxes")
    public void selectingCheckboxes() {
        checkboxesPage = new MainPage().getCheckBoxesPage();
        assertAll(
                () -> assertFalse(checkboxesPage.isCheckboxChecked(1)),
                () -> assertTrue(checkboxesPage.isCheckboxChecked(2)));

        checkboxesPage.clickCheckbox(1);
        assertAll(
                () -> assertTrue(checkboxesPage.isCheckboxChecked(1)),
                () -> assertTrue(checkboxesPage.isCheckboxChecked(2)));

        checkboxesPage.clickCheckbox(2);
        assertAll(
                () -> assertTrue(checkboxesPage.isCheckboxChecked(1)),
                () -> assertFalse(checkboxesPage.isCheckboxChecked(2)));
    }

    @Test
    @DisplayName("Dropdown")
    public void selectElementDropdown() {
        assertTrue(new MainPage()
                .getDropDownPage()
                .setDropdownValue(1)
                .isOptionSelected(1));
    }

    @Test
    @DisplayName("File upload")
    public void FileUpload() {
        assertEquals("File Uploaded!",
                new MainPage()
                .getFileUploadPage()
                .uploadFile("src/test/resources/horus logo.jpg")
                .getTitle());
    }

    @Test
    @DisplayName("Broken images")
    public void brokenImages() {
        BrokenImagesPage brokenImagesPage = new MainPage().getBrokenImagesPage();
        SoftAssertions softAssertions = new SoftAssertions();

        for (String src : brokenImagesPage.getAllSrcImg()) {
            softAssertions.assertThat(brokenImagesPage.isImageHere(src)).isTrue();
            saveScreenshot(src);
        }
        softAssertions.assertAll();
    }

    @Test
    @DisplayName("Entry Ad")
    public void closeAds() throws InterruptedException {
        EntryAdPage entryAdPage = new MainPage().getEntryAdPage();

        do {
            entryAdPage.clickHereButtonClick();
            entryAdPage.refreshPage();
            Thread.sleep(1000);
        } while (!entryAdPage.isModalWindowUp());

        entryAdPage.closeButtonClick();

        assertFalse(entryAdPage.isModalWindowUp());
    }

    @Test
    @DisplayName("Floating Menu")
    public void floatingMenu() {
        FloatingMenuPage floatingMenuPage = new MainPage().getFloatingMenuPage();
        floatingMenuPage.scrollPageFirst();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0, 4275)");

        assertEquals("top: 4237.61px;", floatingMenuPage.getMenuCoordinates());
    }

    @Test
    @DisplayName("Horizontal Slider")
    public void horizontalSlider() {
        HorizontalSliderPage horizontalSliderPage = new MainPage()
                .getHorizontalSliderPage()
                .setSliderValue("right", 5);

        assertEquals(5, horizontalSliderPage.getSliderValue());

        horizontalSliderPage.setSliderValue("left", 0);

        assertEquals(0, horizontalSliderPage.getSliderValue());

//        Another way to slide with mouse click
//        WebElement e = driver.findElement(By.className("Class name of Dragger"));
//        Actions move = new Actions(driver);
//        move.moveToElement(e).clickAndHold().moveByOffset(0,250).release().perform();
    }

    @Test
    @DisplayName("Hover")
    public void hoverAndClick() {
        assertEquals("Not Found",
                new MainPage()
                .getHoversPage()
                .mouseOverFirstAvatar()
                .viewProfileClick().getTitle());
    }

    @Test
    @DisplayName("Infinite Scroll")
    public void infiniteScroll() throws InterruptedException {
        InfiniteScrollPage infiniteScrollPage = new MainPage().getInfiniteScrollPage();

        Thread.sleep(500); // no-one will see that (need to complete rendering page)

        assertEquals(2, infiniteScrollPage.getCountOfParagraphs());

        infiniteScrollPage.scrollToLastParagraph();

        assertEquals(3, infiniteScrollPage.getCountOfParagraphs());
    }

    @Test
    @DisplayName("Query Menu Page")
    public void queryMenu() {
        new MainPage()
                .getQueryMenuPage()
                .mouseoverEnabledElement()
                .mouseoverDownloadsElement()
                .pdfButtonClick();
    }

    @Test
    @DisplayName("Simple alert")
    public void alertCheck() {
        alertsPage = new MainPage().getAlertsPage();
        alertsPage
                .clickAlertButton()
                .waitForAlertReady()
                .accept();

        assertEquals("You successfully clicked an alert", alertsPage.getResult());
    }

    @Test
    @DisplayName("Confirm box")
    public void confirmCheck() {
        alertsPage = new MainPage()
                .getAlertsPage()
                .clickConfirmButton();

        alertsPage.clickAlertAccept();

        assertEquals("You clicked: Ok", alertsPage.getResult());

        alertsPage.clickConfirmButton();
        alertsPage.clickAlertDismiss();

        assertEquals("You clicked: Cancel", alertsPage.getResult());
    }

    @Test
    @DisplayName("Prompt alert")
    public void promptCheck() {
        alertsPage = new MainPage()
                .getAlertsPage()
                .clickPromptButton();

        alertsPage.setAlertValue("Horus1613");
        alertsPage.clickAlertAccept();

        assertEquals("You entered: Horus1613", alertsPage.getResult());
    }

    @Test
    @DisplayName("Open new tab")
    public void newTab() {
        MultipleWindowsPage multipleWindowsPage = new MainPage()
                .getMultipleWindowsPage()
                .clickClickHereButton();

        assertEquals(2, multipleWindowsPage.getAllTabs().size());

        multipleWindowsPage.switchToNewWindow();

        assertEquals("New Window", multipleWindowsPage.getHeader());

        multipleWindowsPage
                .closeTab()
                .switchToDefaultWindow();

        assertEquals(1, multipleWindowsPage.getAllTabs().size());
    }

    @ParameterizedTest(name = "iFrame => entering text={0}{1}")
    @MethodSource("dataProvider")
    @DisplayName("iFrame")
    public void iFrame(String text, int number) {
        assertEquals(text + number,
                new MainPage()
                .getiFramePage()
                .iFrameClick()
                .sendMessage(text + number)
                .getText());
    }

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of("Kappa", 1),
                Arguments.of("4Head", 2),
                Arguments.of("WutFace", 3)
        );
    }

    @ParameterizedTest(name = "iframe: {0}")
    @ValueSource(strings = { "qwe", "rty" })
    @DisplayName("iFrame2")
    public void iFrame2(String text) {
        assertEquals(text,
                new MainPage()
                .getiFramePage()
                .iFrameClick()
                .sendMessage(text).getText());
    }

    @Test
    @DisplayName("Element on page that is hidden")
    public void hiddenElement() {
        assertThat(new MainPage()
                .getDynamicLoadingPage()
                .clickExampleOneLink()
                .clickStartButton()
                .getHiddenText())
                .isEqualTo("Hello World!");
    }

    @Test
    @DisplayName("Element rendered after the fact")
    public void hiddenElement2() {
        assertThat(new MainPage()
                .getDynamicLoadingPage()
                .clickExampleTwoLink()
                .clickStartButton()
                .getHiddenText())
                .isEqualTo("Hello World!");
    }

    @Test
    @DisplayName("Shadow dom")
    public void shadowDom() {
        assertThat(new MainPage()
                .getShadowDomPage()
                .getHiddenText())
                .isEqualTo("My default text");
    }

    @Test
    @DisplayName("Nested frames")
    public void nestedFrames() {
        assertThat(new MainPage()
                .getNestedFramesPage()
                .iframeText(NestedFramesPage.frame.middle))
                .isEqualTo("MIDDLE");
    }
}
