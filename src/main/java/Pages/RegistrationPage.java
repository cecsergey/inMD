package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage{
    //*********Constructor*********
    public RegistrationPage (WebDriver driver) {

        super(driver);
    }

    //*********Web Elements*********
    By registerStudetnButtonBy = By.xpath("//a[text()=\"Register as student*\"]");
    By registerCompanyButtonBy = By.xpath("//a[text()=\"Register as company*\"]");

    //*********Page Methods*********
    public RegistrationPage selectRegistrationUser(String usertype){
        if(usertype.equals("student")){
            click(registerStudetnButtonBy );
        }else if (usertype.equals("company")){
            click(registerCompanyButtonBy );
        }
        return this;
    }





}
