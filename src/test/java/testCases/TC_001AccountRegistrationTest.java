package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001AccountRegistrationTest extends BaseClass {

    // ========== TEST CASE ==========
    @Test(groups = {"Regression","Master"})
    public void accountVerification() {

        logger.info("===== Starting Account Registration Test =====");
        try {

        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        logger.info("Clicking on My Account");
        hp.clickRegister();
        logger.info("Clicking on Register");

        AccountRegistrationPage arp = new AccountRegistrationPage(driver);

        logger.info("Entering user data");
        arp.setFirstName(randomString().toUpperCase());
        arp.setLastName(randomString().toUpperCase());
        arp.setEmail(randomString() + "@gmail.com");
        arp.setTelephone(randomNumber());

        String password = randomAlphaNumeric();

        arp.setPassword(password);
        arp.setConfirmPassword(password);

        arp.selectNewsletter();
        arp.checkPrivacyPolicy();
        arp.clickContinue();

        String confirmationMsg = arp.getConfirmationMessage();
        logger.info("Confirmation message received: " + confirmationMsg);

        if (confirmationMsg.equals("Your Account Has Been Created!")){
            Assert.assertTrue(true);
            logger.info("Test Passed ");
        }
        else {
            logger.error("Test Failed-");
            logger.info("Debug logs...");
            Assert.assertTrue(false);
        }
        //   Assert.assertEquals(confirmationMsg, "Your Account Has Been Created!");

        } catch (AssertionError e) {
            logger.info("Test Failed - " + e.getMessage());
            Assert.fail();
        }

        logger.info("===== Account Registration Test Completed =====");
    }

}
