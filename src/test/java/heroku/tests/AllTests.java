package heroku.tests;

import core.BaseSeleniumTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.TestWatcher;
import pages.*;

public class AllTests extends BaseSeleniumTests implements TestWatcher {
    private FileUploadPage fileUploadPage;
    private LoginPage loginPage;
    private AddElementsPage addElementsPage;
    private CheckboxesPage checkboxesPage;
    private DropDownPage dropDownPage;

    private static final String LOGIN = "tomsmith";
    private static final String PASSWORD = "SuperSecretPassword!";

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
    public void checkFileUpload() {
        fileUploadPage = new MainPage().getFileUploadPage();
        fileUploadPage.uploadFile("src/horus logo.jpg");
        Assertions.assertEquals("File Uploaded!", fileUploadPage.getTitle());
    }
}
