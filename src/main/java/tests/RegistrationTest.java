package tests;

import Pages.HomePage;
import Pages.RegistrationPage;
import Pages.SuccessPage;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest{

    private String successMessage="Success";

    @Test(priority = 1)
    public void NavigatetoRegistrationPageTest() {

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        homePage.goToinMD()
                .goToSignUpPage();
    }

    @Test (priority = 1)
    public void StudentRegistration () throws InterruptedException {
        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        homePage.goToinMD()
                .goToSignUpPage();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        SuccessPage successPage = new SuccessPage(driver);

        registrationPage
                .selectRegistrationUser("student")
                .submitStudentRegistrationForm("student");

        successPage.verifySuccessMessage(successMessage);

        Thread.sleep(5000);

    }

}
