package tests;

import Pages.ForgotPassword.CheckYourEmailPage;
import Pages.ForgotPassword.ForgotPasswordPage;
import Pages.HomePage;
import Pages.RegistrationPage;
import Pages.SuccessPage;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends BaseTest{

    private String successMessage="Success";


    @Test(priority = 2)
    public void Invalid_EmptyUsername () {
        ForgotPasswordPage forgotPasswordPage  = new ForgotPasswordPage(driver);
        //logger = extent.createTest("To verify invalid_emptyUsername");
        forgotPasswordPage.invalidUsername("");
        forgotPasswordPage.VerifyErrorMessage();
    }

    @Test(priority = 2)
    public void Invalid_NonExistUsername () {
        ForgotPasswordPage forgotPasswordPage  = new ForgotPasswordPage(driver);
       // logger = extent.createTest("To verify that non exist user");
        forgotPasswordPage.invalidUsername("tralala");
        forgotPasswordPage.VerifyErrorMessage();
    }

    @Test(priority = 2)
    public void Valid_ClickDone () {
        ForgotPasswordPage forgotPasswordPage  = new ForgotPasswordPage(driver);
        //logger = extent.createTest("To verify that valid click done");
        CheckYourEmailPage check = forgotPasswordPage.validUsername("student2@mailinator.com");
        check.clickDoneButton();
    }

    @Test(priority = 2)
    public void Valid_ClickStartOver () {
        ForgotPasswordPage forgotPasswordPage  = new ForgotPasswordPage(driver);
        //logger = extent.createTest("To verify that valid click start over");
        CheckYourEmailPage check = forgotPasswordPage.validUsername("student2@mailinator.com");
        check.clickStartOverButton();
    }

}
