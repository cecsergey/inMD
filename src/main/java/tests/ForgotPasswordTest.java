package tests;

import Pages.ForgotPassword.ForgotPasswordPage;
import Pages.HomePage;
import Pages.RegistrationPage;
import Pages.SuccessPage;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends BaseTest{

    private String successMessage="Success";

    /*
    @Test(priority = 1)
    public void NavigatetoRegistrationPageTest() {

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        homePage.goToinMD()
                .goToSignUpPage();
    }*/

    @Test (priority = 1)
    public void Invalid () throws InterruptedException {
        //*************PAGE INSTANTIATIONS*************
        ForgotPasswordPage forgotPasswordPage  = new ForgotPasswordPage(driver);

        //*************PAGE METHODS********************
        forgotPasswordPage.emptyUsername();
//        forgotPasswordPage.invalidUsername();
    }

}
