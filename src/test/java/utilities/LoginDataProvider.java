package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;

/**
 * Data provider class for supplying login data from an Excel file.
 */
public class LoginDataProvider {

    // Logger instance for logging
    public static final Logger logger = LogManager.getLogger(LoginDataProvider.class);

    /**
     * Provides login test data from Excel.
     *
     * @return 2D Object array with login credentials and expected results
     * @throws Exception if Excel file reading fails
     */
    @DataProvider(name = "LoginData")
    public static Object[][] getLoginData() throws Exception {
        String excelPath = "testData/open_cart_loginData.xlsx";
        String sheetName = "Sheet1";

        System.out.println("Reading login data from Excel: " + excelPath + ", Sheet: " + sheetName);
        logger.info("Reading login data from Excel: {}, Sheet: {}", excelPath, sheetName);

        ExcelUtils excel = null;
        Object[][] data = null;

        try {
            // Load Excel data
            excel = new ExcelUtils(excelPath, sheetName);
            int rowCount = excel.getRowCount();

            data = new Object[rowCount - 1][4]; // Username, Password, ExpectedResult, RowIndex

            // Read data row by row (starting from row 1 to skip header)
            for (int i = 1; i < rowCount; i++) {
                data[i - 1][0] = excel.getCellData(i, 0); // Username
                data[i - 1][1] = excel.getCellData(i, 1); // Password
                data[i - 1][2] = excel.getCellData(i, 2); // ExpectedResult
                data[i - 1][3] = i;                       // RowIndex (optional for tracking)

                System.out.println("Loaded Row " + i + " -> Username: " + data[i - 1][0] + ", ExpectedResult: " + data[i - 1][2]);
                logger.info("Loaded row {} -> Username: {}, ExpectedResult: {}", i, data[i - 1][0], data[i - 1][2]);
            }

        } catch (Exception e) {
            System.out.println("Error reading login data: " + e.getMessage());
            logger.error("Failed to read login data from Excel", e);
            throw e;
        } finally {
            // Close workbook to release file resources
            if (excel != null) {
                excel.closeWorkbook();
                System.out.println("Excel workbook closed.");
                logger.info("Excel workbook closed.");
            }
        }

        return data;
    }
}
