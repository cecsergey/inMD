package tests;

import Pages.HomePage;
import Pages.UserActivityDDL;
import org.testng.annotations.Test;


public class LogoutTest extends BaseTestwithLogin{
    @Test(priority = 3)
    public void LogoutTest() {

//        //*************PAGE INSTANTIATIONS*************
//        HomePage homePage = new HomePage(driver);
        UserActivityDDL userActivityDDL = new UserActivityDDL(driver);
        logger = extent.createTest("To verify that logout works successfully");

//
//        //*************PAGE METHODS********************
//        homePage.goToinMD()
//                .loginToinMD("sergey","123456");
        userActivityDDL.logoutFrominMD();


    }
}
