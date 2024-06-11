import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.LoginPage;

public class WeBookAutomation extends BaseTest {

    @Test(priority = 1)
    public static void register() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.registUser();
    }

    @Test(priority = 2)
    public static void searchAndFilter() {

        // Perform search and filter functionality
        LoginPage loginPage = new LoginPage(driver);
        loginPage.VerifySearchFunctionality();
    }
}
