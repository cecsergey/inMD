package tests;

import Pages.HomePage;
import Pages.RegistrationPage;
import Pages.SuccessPage;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest{

    private String successMessage="Success";

    @Test(priority = 1)
    public void NavigateToRegistrationPage() {

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);
        logger = extent.createTest("To verify that you can navigate to registration page successfull");
         //extent.createTest("To verify that you can navigate to registration page successfull");
        //*************PAGE METHODS********************
        homePage.goToinMD()
                        .goToSignUpPage();
    }

    @Test (priority = 1)
    public void StudentRegistration () throws InterruptedException {
        logger = extent.createTest("To verify that student registration works successfully");
        //extent.createTest("To verify that student registration works successfully");
        logger.createNode("Registration is Successful");
         RegisterUser("student");

    }

    @Test (priority = 1)
    public void CompanyRegistration () throws InterruptedException {
        logger = extent.createTest("To verify that company registration works successfully");
       // extent.createTest("To verify that company registration works successfully");
        RegisterUser("company");
    }

    private void RegisterUser(final String userType) throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        RegistrationPage registrationPage = homePage.goToinMD()
                .goToSignUpPage();
        SuccessPage successPage =  registrationPage.selectRegistrationUser(userType)
                .submitRegistrationForm(userType);
        //logger.createNode("Registration is Successful");
        successPage.verifySuccessMessage(successMessage);
        //Thread.sleep(2500);
    }
}
