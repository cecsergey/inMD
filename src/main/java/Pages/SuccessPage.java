package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessPage extends BasePage {

    //*********Constructor*********
    public SuccessPage(WebDriver driver) {
        super(driver);
    }

    //*********Page Variables*********


    //*********Web Elements*********
    final By successMessageBy= By.xpath("//h1[text()='Success']");

    //Verify Username Condition
    public SuccessPage verifySuccessMessage(String successMessage) {
        assertEquals(successMessageBy,successMessage);
            return this;
        }

}
