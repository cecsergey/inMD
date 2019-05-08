package Pages.ForgotPassword;

import Pages.BasePage;
import Utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends BasePage {
    //*********Constructor*********
    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
        driver.get(Properties.baseURL + "auth/forgot-password/");
    }


    //*********Page Variables*********


    //*********Web Elements*********
    final By emailBy= By.id("email");
    final By submitButtonBy= By.cssSelector("button[type=\"submit\"]");
    final By errorBy= By.cssSelector("div[role=\"alert\"]"); // Error message if invalid username/email specified

    public ForgotPasswordPage invalidUsername(){
        click(emailBy);
        writeText(emailBy, "Garbage");
        click(submitButtonBy);
        assertVisible(errorBy);
        return this;
    }

    public ForgotPasswordPage emptyUsername(){
        driver.get(Properties.baseURL + "auth/forgot-password/");
        click(submitButtonBy);
        assertVisible(errorBy);
        return this;
    }

    public CheckYourEmailPage validUsername(final String username){
        driver.get(Properties.baseURL + "auth/forgot-password/");
        click(emailBy);
        writeText(emailBy, username);
        click(submitButtonBy);
        assertInvisible(errorBy);
        return new CheckYourEmailPage(driver);
    }
}
