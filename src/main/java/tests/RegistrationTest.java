package tests;

import Pages.HomePage;
import Pages.RegistrationPage;
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
    public void StudentRegistration () throws InterruptedException {
        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        homePage.goToinMD()
                .goToSignUpPage();
        RegistrationPage registrationPage = new RegistrationPage(driver)
                .selectRegistrationUser("student");
        registrationPage.fillStudentRegistrationFields();
        Thread.sleep(5000);

    }

}
