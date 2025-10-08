package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{

    // ========== PARAMETRIZED CONSTRUCTOR ==========

    public LoginPage (WebDriver driver){
        super(driver);

    }

    // ========== LOCATORS ==========

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txt_email;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txt_password;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement btn_login;

    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement txt_confirmationMsg;

    // ========== ACTION METHODS ==========

    public void setEmail(String email) {
        txt_email.clear();
        txt_email.sendKeys(email);
    }

    public void setPassword(String password) {
        txt_password.clear();
        txt_password.sendKeys(password);
    }

    public void clickBtnLogin() {

        btn_login.click();
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
