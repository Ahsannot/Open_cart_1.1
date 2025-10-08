package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002AccountLoginTest extends BaseClass {

    @Test(groups = {"Sanity","Master"})
    public void accountLogin(){

        logger.info("===== Starting Account Login Test =====");
        try{

        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        logger.info("Clicking on My Account");
        hp.clickLogin();
        logger.info("Clicking on Login");

        LoginPage lp = new LoginPage(driver);

        logger.info("Entering user data");

        lp.setEmail(prop.getProperty("username"));
        lp.setPassword(prop.getProperty("password"));
        lp.clickBtnLogin();

            String confirmationMsg = lp.getConfirmationMessage();
            logger.info("Confirmation message received: " + confirmationMsg);

            if (confirmationMsg.equals("My Account")){
                Assert.assertTrue(true);
                logger.info("Test Passed ");
            }
            else {
                logger.error("Test Failed-");
                logger.info("Debug logs...");
                Assert.assertTrue(false);
            }
            //   Assert.assertEquals(confirmationMsg, "My Account");

        } catch (AssertionError e) {
            logger.info("Test Failed - " + e.getMessage());
            Assert.fail();
        }

        logger.info("===== Account Login Test Completed =====");

    }
}
