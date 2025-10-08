package testCases;

import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_003AccountLogoutTest  extends BaseClass {

    @Test
    public void accountLogout(){
        MyAccountPage MAP = new MyAccountPage(driver);
        MAP.clickBtnLogout();
    }
}
