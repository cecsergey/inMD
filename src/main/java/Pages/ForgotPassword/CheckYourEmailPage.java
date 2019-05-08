package Pages.ForgotPassword;

import Pages.BasePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckYourEmailPage extends BasePage {
    //*********Constructor*********
    public CheckYourEmailPage(WebDriver driver) {
        super(driver);
    }


    //*********Page Variables*********


    //*********Web Elements*********
    final By doneButtonBy= By.cssSelector("div[class=\"d-flex\"] a[href=\"https://inmdstage.breezio.com/auth/login\"]");
    final By startOverButtonBy= By.cssSelector("div[class=\"d-flex\"] a[href=\"https://inmdstage.breezio.com/auth/forgot-password\"]");
    final By successTextBy= By.cssSelector("div[class=\"reset-success-content\"]"); // Success message

    public LoginPage clickDoneButton(){
        assertVisible(successTextBy);
        click(doneButtonBy);
        return new LoginPage(driver);
    }

    public ForgotPasswordPage clickStartOverButton(){
        assertVisible(successTextBy);
        click(startOverButtonBy);
        return new ForgotPasswordPage(driver);
    }
}
