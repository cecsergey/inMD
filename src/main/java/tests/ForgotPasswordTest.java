package tests;

import Pages.ForgotPassword.CheckYourEmailPage;
import Pages.ForgotPassword.ForgotPasswordPage;
import Pages.HomePage;
import Pages.RegistrationPage;
import Pages.SuccessPage;
import Utils.Properties;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends BaseTest{


    @Test (priority = 1)
    public void Invalid_EmptyUsername () {
        ForgotPasswordPage forgotPasswordPage  = goToForgotPasswordPage();

        forgotPasswordPage.invalidUsername("");
        forgotPasswordPage.VerifyErrorMessage();
    }

    @Test (priority = 1)
    public void Invalid_NonExistUsername () {
        ForgotPasswordPage forgotPasswordPage  = goToForgotPasswordPage();

        forgotPasswordPage.invalidUsername("tralala");
        forgotPasswordPage.VerifyErrorMessage();
    }

    @Test (priority = 1)
    public void Invalid_NonExistEmail () {
        ForgotPasswordPage forgotPasswordPage  = goToForgotPasswordPage();

        forgotPasswordPage.invalidUsername("tralala@gmail.com");
        forgotPasswordPage.VerifyErrorMessage();
    }

    @Test (priority = 1)
    public void Valid_ClickDone () {
        ForgotPasswordPage forgotPasswordPage  = goToForgotPasswordPage();

        CheckYourEmailPage check = forgotPasswordPage.validUsername("student2@mailinator.com");
        check.clickDoneButton();
    }

    @Test (priority = 1)
    public void Valid_ClickStartOver () {
        ForgotPasswordPage forgotPasswordPage  = goToForgotPasswordPage();

        CheckYourEmailPage check = forgotPasswordPage.validUsername("student2@mailinator.com");
        check.clickStartOverButton();
    }

    @Test (priority = 0)
    public void NavigateToForgotPasswordPage() {
        goToForgotPasswordPage();
    }

    // Private function which will be used to navigate to "Forgot Password" page from Home page
    private ForgotPasswordPage goToForgotPasswordPage(){
        HomePage homePage = new HomePage(driver).goToinMD();
        return homePage.goToForgotPasswordPage();
    }
}
