package tests;

import Utils.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

    String os = System.getProperty("os.name").toLowerCase();

    public WebDriver driver;

    private void makeChromeDriver(){
        //Create a Chrome driver. All test classes use this.
       if(os.contains("windows")) {
           System.setProperty("webdriver.chrome.driver", Properties.seleniumDriversPath + "chromedriver.exe");
           driver = new ChromeDriver();
       }else if(os.contains("mac")){
           System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
           driver = new ChromeDriver();
       }else{
           System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");

       }
    }

    private void makeFirefoxDriver(){
        //Create a Chrome driver. All test classes use this.
        System.setProperty("webdriver.gecko.driver", Properties.seleniumDriversPath + "geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @BeforeClass
    public void setup () {
        makeChromeDriver();
        //Maximize Window
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown () {
        driver.quit();
    }
}
