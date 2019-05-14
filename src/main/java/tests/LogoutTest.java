package tests;

import Pages.HomePage;
import Pages.UserActivityDDL;
import org.testng.annotations.Test;


public class LogoutTest extends BaseTestwithLogin{
    @Test(priority = 0)
    public void LogoutTest() {

//        //*************PAGE INSTANTIATIONS*************
//        HomePage homePage = new HomePage(driver);
        UserActivityDDL userActivityDDL = new UserActivityDDL(driver);
//
//        //*************PAGE METHODS********************
//        homePage.goToinMD()
//                .loginToinMD("sergey","123456");
        userActivityDDL.logoutFrominMD();


    }
}
