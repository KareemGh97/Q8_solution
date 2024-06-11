package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;
import java.util.UUID;


public class LoginPage {
    private WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    String uniqueEmail = "test" + UUID.randomUUID().toString().substring(0, 8) + "@gmail.com";

    @FindBy(css = "[data-testid='login-profile']")
    private WebElement loginProfileLink;

    @FindBy(xpath = "//button[text()='Create an account']")
    private WebElement createAccountBtn;

    @FindBy(id = "first_name")
    private WebElement firstName;

    @FindBy(id = "last_name")
    private WebElement lastName;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(xpath = "//*[@id=\"signup-form-info\"]/fieldset[3]/div[1]/div/input")
    private WebElement password;

    @FindBy(id = "confirm_email")
    private WebElement confirmEmail;

    @FindBy(xpath = "//*[@id=\"signup-form-info\"]/fieldset[4]/div/div[2]/div/div/input")
    private WebElement phoneNumberTxtBox;

    @FindBy(xpath = "/html/body/div[1]/main/section/div/div[2]/div/div/div/div[3]/div[2]/button")
    private WebElement submitBtn;

    @FindBy(xpath = "//*[@id=\"signup-wrapper\"]/div[3]/div[1]/label/input")
    private WebElement acknowldgeCheckBox;

    @FindBy(xpath = "//*[@id=\"main\"]/section[1]/form/input")
    private WebElement searchTxtBox;

    @FindBy(xpath = "//*[@id=\"main\"]/section[1]/form/button/img")
    private WebElement searchBtn;


    @FindBy(xpath = "//h1[text()='Search results for \"Events\"']")
    private WebElement searchResult;



    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void checkElementNotVisible(WebElement element) {
        if (!wait.until(ExpectedConditions.invisibilityOf(element))) {
            // Element is still visible on the screen
            System.out.println("Element with locator " + element.toString() + " is visible on the screen");
        } else {
            // Element is not visible on the screen
            System.out.println("Element with locator " + element.toString() + " is not visible on the screen");
        }
    }
    private String generatePhoneNumber() {
        Random random = new Random();
        StringBuilder phoneNumber = new StringBuilder("5");
        for (int i = 0; i < 9; i++) {
            phoneNumber.append(random.nextInt(10)); // Append a random digit (0-9)
        }
        return phoneNumber.toString();
    }

    public void registUser() throws InterruptedException {
        createAccountBtn.click();
        wait.until(ExpectedConditions.visibilityOf(firstName));
        firstName.sendKeys("john");
        lastName.sendKeys("test");
        email.sendKeys(uniqueEmail);
        confirmEmail.sendKeys(uniqueEmail);
        password.sendKeys("123456Ka");
        scrollToElement(phoneNumberTxtBox);
        phoneNumberTxtBox.sendKeys("536516475");
        acknowldgeCheckBox.click();
        submitBtn.click();
    }

    public Void VerifySearchFunctionality()
    {
        wait.until(ExpectedConditions.visibilityOf(searchTxtBox));
        searchTxtBox.sendKeys("Events");
        searchBtn.click();
        searchResult.getText().contains("Events");
        return null;
    }
}