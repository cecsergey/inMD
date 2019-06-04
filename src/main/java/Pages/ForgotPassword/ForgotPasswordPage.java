package Pages.ForgotPassword;

import Pages.BasePage;
import Utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends BasePage {
    //*********Constructor*********
    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }


    //*********Page Variables*********


    //*********Web Elements*********
    // "Forgor password" form's email field
    private final By emailBy= By.id("email");
    // "Forgor password" form's submit button
    private final By submitButtonBy= By.cssSelector("div[class=\"login-content\"] button[type=\"submit\"]");
    // Error message if invalid username/email specified
    private final By errorBy= By.cssSelector("div[role=\"alert\"]");

    public CheckYourEmailPage validUsername(final String username){
        click(emailBy);
        writeText(emailBy, username);
        click(submitButtonBy);
        return new CheckYourEmailPage(driver);
    }

    public ForgotPasswordPage invalidUsername(final String invalidUsername) {
        click(emailBy);
        writeText(emailBy, invalidUsername);
        click(submitButtonBy);
        return this;
    }

    public ForgotPasswordPage VerifyErrorMessage() {
        assertVisible(errorBy);
        return this;
    }
}
