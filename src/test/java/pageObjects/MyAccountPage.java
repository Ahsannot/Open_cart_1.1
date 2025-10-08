package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyAccountPage  extends BasePage{

    // ========== PARAMETRIZED CONSTRUCTOR ==========

    public MyAccountPage (WebDriver driver){
        super(driver);

    }

    // ========== LOCATORS ==========

    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement txt_confirmationMsg;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement btn_logout;

    // ========== ACTION METHODS ==========

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
    public void clickBtnLogout() {

        btn_logout.click();
    }
}
