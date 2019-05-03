package tests;

import Utils.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {
    public WebDriver driver;

    private void makeChromeDriver(){
        //Create a Chrome driver. All test classes use this.
        System.setProperty("webdriver.chrome.driver", Properties.seleniumDriversPath + "chromedriver.exe");
        driver = new ChromeDriver();
    }

    private void makeFirefoxDriver(){
        //Create a Chrome driver. All test classes use this.
        System.setProperty("webdriver.gecko.driver", Properties.seleniumDriversPath + "geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @BeforeClass
    public void setup () {
        makeFirefoxDriver();
        //Maximize Window
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown () {
        driver.quit();
    }
}
