package heroku.tests;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;



//public class TestListener {
//    // This is class is not in use. Just for history
////    @Override
////    public void testFailed(ExtensionContext context, Throwable cause) {
////        Allure.getLifecycle().addAttachment("screenshoot", "image/png", "png",
////                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
////        driver.quit();
//    }
//}
