package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    //*********Constructor*********
    public HomePage (WebDriver driver) {

        super(driver);
    }

    //*********Page Variables*********
    String baseURL = "https://inmdstage.breezio.com/";

    //*********Web Elements*********
    By signInButtonBy = By.id("btn-signin");
    By signUpButtonBy = By.id("btn-signup");
    By usernameBy = By.id("popup-user_name");
    By passwordBy = By.id("popup-password");
    By loginButtonBy = By.xpath("//button[text()='GO']");


    //*********Page Methods*********
    //Go to Homepage
    public HomePage goToinMD (){
        driver.get(baseURL);
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
