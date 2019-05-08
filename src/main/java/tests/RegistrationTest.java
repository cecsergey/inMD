package tests;

import Pages.HomePage;
import Pages.RegistrationPage;
import Pages.SuccessPage;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest{

    private String successMessage="Success";

    @Test(priority = 1)
    public RegistrationPage NavigateToRegistrationPage() {

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        return homePage.goToinMD()
                        .goToSignUpPage();
    }

    @Test (priority = 1)
    public void StudentRegistration () throws InterruptedException {
        RegisterUser("student");
    }

    @Test (priority = 1)
    public void CompanyRegistration () throws InterruptedException {
        RegisterUser("company");
    }

    private void RegisterUser(final String userType) throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        RegistrationPage registrationPage = homePage.goToinMD()
                .goToSignUpPage();
        SuccessPage successPage =  registrationPage.selectRegistrationUser(userType)
                .submitRegistrationForm(userType);
        successPage.verifySuccessMessage(successMessage);
        Thread.sleep(2500);
    }
}
