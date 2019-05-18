package tests;

import Pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 0)
    public void LoginTest() {

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);
        extent.createTest("To verify that login works successfully")
              .pass("details");;


        //*************PAGE METHODS********************
        homePage.goToinMD()
                .loginToinMD("sergey","123456");



    }
}
