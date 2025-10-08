package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.ExcelUtils;
import utilities.LoginDataProvider;

public class TC_004AccountLoginTestDDT extends BaseClass {

    String excelPath = "testData/open_cart_loginData.xlsx";
    String sheetName = "Sheet1";

    @Test(dataProvider = "LoginData", dataProviderClass = LoginDataProvider.class)
    public void accountLoginDDT(String username, String password, String expectedResult, int rowIndex) throws Exception {

        logger.info("===== Starting Account Login DDT Test for: " + username + " =====");

        // Excel utility initialized once
        ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

        String actualResult;

        try {
            // Navigate to Login Page
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();

            // Perform Login
            LoginPage lp = new LoginPage(driver);
            lp.setEmail(username);
            lp.setPassword(password);
            lp.clickBtnLogin();

            // Check Confirmation Message
            MyAccountPage macp = new MyAccountPage(driver);
            String confirmationMsg = macp.getConfirmationMessage();

            if (confirmationMsg.equals("My Account")) {
                actualResult = "Pass";
            } else {
                actualResult = "Fail";
            }

            // Write ActualResult to Excel
            excel.setCellData(actualResult, rowIndex, 3); // Column 3 = ActualResult

            if (actualResult.equalsIgnoreCase(expectedResult)) {
                logger.info("✅ Test Passed for: " + username);
                excel.setCellData("Test Passed", rowIndex, 4); // Column 4 = TestStatus

                // Logout only if login successful
                if (actualResult.equals("Pass")) {
                    macp.clickBtnLogout();
                    logger.info("Logged out successfully for user: " + username);
                }

            } else {
                logger.error("❌ Test Failed for: " + username + " | Expected: " + expectedResult + ", Got: " + actualResult);
                excel.setCellData("Test Failed", rowIndex, 4);
                // ✅ Do not call Assert.fail before Excel write
                Assert.assertEquals(actualResult, expectedResult, "Login result mismatch");
            }

        } catch (Exception e) {
            logger.error("🚨 Exception during test for user: " + username + " - " + e.getMessage());
            excel.setCellData("Fail", rowIndex, 3);
            excel.setCellData("Test Failed", rowIndex, 4);
            throw e; // Rethrow so test still fails
        } finally {
            excel.closeWorkbook();
        }

        logger.info("===== Finished Account Login DDT Test for: " + username + " =====");
    }
}
