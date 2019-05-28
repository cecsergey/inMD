package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserActivityDDL extends BasePage {

    public UserActivityDDL(WebDriver driver) {
        super(driver);
    }

    //*********Web Elements*********
    final By logoutButtonBy = By.xpath("//ul[@class='dropdown-menu show']//a[text()='Logout']");
    //final By UserProfileLinkBy = By.xpath("//li[@class='nav-item nav-item-profile check_user_activity_header check_user_activity user-online']");
    final By UserProfileLinkBy = By.cssSelector(" li a img");


    public UserActivityDDL logoutFrominMD()throws Exception{
        //Open user Activity drop down list
        click(UserProfileLinkBy);
        //Click Logout Button
        click(logoutButtonBy);
        return this;
    }
}
