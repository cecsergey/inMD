package tests;

import Pages.HomePage;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest{

    @Test(priority = 1)
    public void NavigatetoRegistrationPageTest() {

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        homePage.goToinMD()
                .goToSignUpPage();
    }

    @Test (priority = 1)
    public void StudentRegistration () {
        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        homePage.goToinMD()
                .goToSignUpPage()
                .selectRegistrationUser("student");
    }


}
