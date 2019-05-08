package tests;

import Pages.ForgotPassword.CheckYourEmailPage;
import Pages.ForgotPassword.ForgotPasswordPage;
import Pages.HomePage;
import Pages.RegistrationPage;
import Pages.SuccessPage;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends BaseTest{

    private String successMessage="Success";


    @Test
    public void Invalid_EmptyUsername () {
        ForgotPasswordPage forgotPasswordPage  = new ForgotPasswordPage(driver);

        forgotPasswordPage.invalidUsername("");
        forgotPasswordPage.VerifyErrorMessage();
    }

    @Test
    public void Invalid_NonExistUsername () {
        ForgotPasswordPage forgotPasswordPage  = new ForgotPasswordPage(driver);

        forgotPasswordPage.invalidUsername("tralala");
        forgotPasswordPage.VerifyErrorMessage();
    }

    @Test
    public void Valid_ClickDone () {
        ForgotPasswordPage forgotPasswordPage  = new ForgotPasswordPage(driver);

        CheckYourEmailPage check = forgotPasswordPage.validUsername("student2@mailinator.com");
        check.clickDoneButton();
    }

    @Test
    public void Valid_ClickStartOver () {
        ForgotPasswordPage forgotPasswordPage  = new ForgotPasswordPage(driver);

        CheckYourEmailPage check = forgotPasswordPage.validUsername("student2@mailinator.com");
        check.clickStartOverButton();
    }

}
