package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountRegistrationPage extends BasePage {

    // ========== PARAMETRIZED CONSTRUCTOR ==========

    public AccountRegistrationPage(WebDriver driver){
        super(driver);
    }

    // ========== LOCATORS ==========

    @FindBy( xpath = "//input[@id='input-firstname']")
    WebElement txt_firstName ;

    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement txt_lastName ;

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txt_email ;

    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement txt_tel;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txt_password;

    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement txt_confirmPass;

    @FindBy(xpath = "//label[normalize-space()='Yes']")
    WebElement txt_newsletter;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement radio_newsletter;

    @FindBy(xpath = "//label[normalize-space()='Yes']")
    WebElement cBox_ppolicy;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement btn_continue;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement txt_confirmationMsg;

    // ========== ACTION METHODS ==========

    public void setFirstName(String fname) {
        txt_firstName.clear();
        txt_firstName.sendKeys(fname);
    }

    public void setLastName(String lname) {
        txt_lastName.clear();
        txt_lastName.sendKeys(lname);
    }

    public void setEmail(String email) {
        txt_email.clear();
        txt_email.sendKeys(email);
    }

    public void setTelephone(String tel) {
        txt_tel.clear();
        txt_tel.sendKeys(tel);
    }

    public void setPassword(String pwd) {
        txt_password.clear();
        txt_password.sendKeys(pwd);
    }

    public void setConfirmPassword(String pwd) {
        txt_confirmPass.clear();
        txt_confirmPass.sendKeys(pwd);
    }

    public void selectNewsletter() {
        txt_newsletter.click();
    }

    public void checkPrivacyPolicy() {
        radio_newsletter.click();
    }

    public void clickContinue() {
        btn_continue.click();

        //   btn_continue.submit();

        //   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //   wait.until(ExpectedConditions.elementToBeClickable(btn_continue)).click();

        //   JavascriptExecutor js = (JavascriptExecutor) driver;
        //   js.executeScript("arguments[0].click();", btn_continue);

        //   JavascriptExecutor js = (JavascriptExecutor) driver;
        //   js.executeScript("arguments[0].scrollIntoView(true);", btn_continue);
        //   btn_continue.click();

        //   Actions actions = new Actions(driver);
        //   actions.moveToElement(btn_continue).click().build().perform();
    }

    public String getConfirmationMessage() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement confirmation = wait.until(ExpectedConditions.visibilityOf(txt_confirmationMsg));
            return confirmation.getText();
        } catch (Exception e) {
            System.out.println("Error fetching confirmation message: " + e.getMessage());
            return null;
        }
    }


}
