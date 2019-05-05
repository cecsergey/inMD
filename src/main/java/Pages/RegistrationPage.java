package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class RegistrationPage extends BasePage{
    //*********Constructor*********
    public RegistrationPage (WebDriver driver) {
        super(driver);
    }

    //*********Web Elements*********
    final By registerStudetnButtonBy = By.xpath("//a[text()='Register as student*']");
    final By registerCompanyButtonBy = By.xpath("//a[text()='Register as company*']");
    final By firstNameBy = By.id("first_name");
    final By lastNameBy = By.id("last_name");
    final By emailBy = By.id("email");
    final By userNameBy = By.id("user_name");
    final By passwordBy = By.id("password");
    final By addressBy = By.id("address");
    final By cityBy = By.id("city");
    final By selectStateDDLBy = By.id("select2-state-container");
    final By stateMarylandBy = By.xpath("//li[text()='Maryland']");
    final By zipCodeBy = By.id("zip_code");
    final By passwordConfirmationBy = By.id("password_confirmation");
    final By createAccountButtonBy = By.xpath("//button[text()='Create Account']");

    //*********Page Methods*********
    public RegistrationPage selectRegistrationUser(String usertype){
        if(usertype.equals("student")){
            click(registerStudetnButtonBy );
        }else if (usertype.equals("company")){
            click(registerCompanyButtonBy );
        }
        return this;
    }

    public SuccessPage submitStudentRegistrationForm(String userType) {
        Random rand = new Random();
        int n = rand.nextInt(500);

        UserRegistrationData regData = new UserRegistrationData(n,userType);
        if(userType.equals("student")){
            writeText(firstNameBy, regData.firstName);
            writeText(lastNameBy, regData.lastName);
            writeText(emailBy, regData.emailAddress);
            writeText(userNameBy, regData.userName);
            writeText(passwordBy, regData.password);
            writeText(passwordConfirmationBy, regData.password);
            click(createAccountButtonBy);
        }else if(userType.equals("company")){
            writeText(firstNameBy, regData.firstName);
            writeText(emailBy, regData.emailAddress);
            writeText(userNameBy, regData.userName);
            writeText(passwordBy, regData.password);
            writeText(passwordConfirmationBy, regData.password);
            writeText(addressBy, regData.address);
            writeText(cityBy, regData.city);
            writeText(zipCodeBy, regData.zipCode);
            regData.UserSelectDropdown();
            click(createAccountButtonBy);
        }else{
            System.out.println("wrong user type");
        }


        return new SuccessPage(driver);
    }

    class UserRegistrationData{

        String firstName;
        String lastName;
        String emailAddress;
        String userName;
        String password;
        String address;
        String city;
        String zipCode;


        private UserRegistrationData(final int extension,final String user) {
            this.firstName = user + extension + "F";
            this.lastName = user + extension + "L";
            this.emailAddress = user + extension + "@mailinator.com";
            this.userName = user + extension;
            this.password = "123456";
            this.address = "2400 Sixth St NW";
            this.city = "Washington";
            this.zipCode = "20059";
        }

        private void UserSelectDropdown(){
            click(selectStateDDLBy);
            click(stateMarylandBy);
        }
    }


}
