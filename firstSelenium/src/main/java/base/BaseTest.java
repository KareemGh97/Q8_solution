package base;

import org.checkerframework.checker.units.qual.Time;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeClass
    public static void setUp() {

        driver = new ChromeDriver();
        driver.get("https://webook.com/en/login?redirect=/en");
        driver.manage().window().maximize();
    }

  //  @AfterClass
    public void tearDwn() {
        driver.quit();
    }


}
