package Pages;

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
    final By signInButtonBy = By.id("btn-signin");
    final By signUpButtonBy = By.id("btn-signup");
    final By usernameBy = By.id("popup-user_name");
    final By passwordBy = By.id("popup-password");
    final By loginButtonBy = By.xpath("//button[text()='GO']");


    //*********Page Methods*********
    //Go to Homepage
    public HomePage goToinMD (){
        driver.get(Properties.baseURL);
        return this;
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
