package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class RegistrationPage extends BasePage{
    //*********Constructor*********
    public RegistrationPage (WebDriver driver) {
        super(driver);
    }

    //*********Web Elements*********
    final By registerStudetnButtonBy = By.xpath("//a[text()=\"Register as student*\"]");
    final By registerCompanyButtonBy = By.xpath("//a[text()=\"Register as company*\"]");
    final By firstNameBy = By.id("first_name");
    final By lastNameBy = By.id("last_name");
    final By emailBy = By.id("email");
    final By userNameBy = By.id("user_name");
    final By passwordBy = By.id("password");
    final By passwordConfirmationBy = By.id("password_confirmation");

    //*********Page Methods*********
    public RegistrationPage selectRegistrationUser(String usertype){
        if(usertype.equals("student")){
            click(registerStudetnButtonBy );
        }else if (usertype.equals("company")){
            click(registerCompanyButtonBy );
        }
        return this;
    }

    public void fillStudentRegistrationFields() {
        Random rand = new Random();
        int n = rand.nextInt(500);
        StudentRegistrationData regData = new StudentRegistrationData(n);

        writeText(firstNameBy, regData.firstName);
        writeText(lastNameBy, regData.lastName);
        writeText(emailBy, regData.emailAddress);
        writeText(userNameBy, regData.userName);
        writeText(passwordBy, regData.password);
        writeText(passwordConfirmationBy, regData.password);
    }

    class StudentRegistrationData{

        String firstName;
        String lastName;
        String emailAddress;
        String userName;
        String password;

        private StudentRegistrationData(final int extension) {
            this.firstName = "Student" + extension + "F";
            this.lastName = "Student" + extension + "L";
            this.emailAddress = "student" + extension + "@mailinator.com";
            this.userName = "student" + extension;
            this.password = "123456";
        }
    }



}
