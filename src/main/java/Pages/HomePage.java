package Pages;

import Pages.ForgotPassword.ForgotPasswordPage;
import Utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    //*********Constructor*********
    public HomePage (WebDriver driver) {
        super(driver);
    }

    //*********Page Variables*********

    //*********Web Elements*********
    private final By signInButtonBy = By.id("btn-signin");
    private final By signUpButtonBy = By.id("btn-signup");
    private final By usernameBy = By.id("popup-user_name");
    private final By passwordBy = By.id("popup-password");
    private final By loginButtonBy = By.xpath("//button[text()='GO']");
    private final By forgotPasswordLinkBy = By.cssSelector("a.forgot-link");


    //*********Page Methods*********
    //Go to Homepage
    public HomePage goToinMD (){
        driver.get(Properties.baseURL);
        return this;
    }

    public ForgotPasswordPage goToForgotPasswordPage() {
        click(signInButtonBy); // Click on "Sign In" button - will appear sign in dropdown form
        click(forgotPasswordLinkBy); // Click on "Forgot password" link - will open "Forgot password" page
        return new ForgotPasswordPage(driver);
    }


    public HomePage loginToinMD(String username, String password){
        click(signInButtonBy);
        //Enter Username(Email)
        writeText(usernameBy,username);
        //Enter Password
        writeText(passwordBy, password);
        //Click Login Button
        click(loginButtonBy);
        return this;
    }

    //Go to SignUp page
    public RegistrationPage goToSignUpPage (){
        click(signUpButtonBy);
        return new RegistrationPage(driver);
    }
}
