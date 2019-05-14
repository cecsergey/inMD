package tests;

import Pages.HomePage;
import Pages.UserActivityDDL;
import Utils.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class BaseTestwithLogin {
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
        System.out.println(("Open chrome browser"));
        makeChromeDriver();
        //Maximize Window
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown () {
        System.out.println(("Close chrome browser"));
        driver.quit();
    }

    @BeforeSuite
    public void beforeSuite () {
        System.out.println(("Starting test Suite"));
    }

    @AfterSuite
    public void afterSuite () {
        System.out.println(("Finishing test Suite"));
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println(("Starting test"));
    }

    @AfterTest
    public void afterTest() {
        System.out.println(("Finishing test"));
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println(("Starting method with login"));
        HomePage homePage = new HomePage(driver);
        //*************PAGE METHODS********************
        homePage.goToinMD()
                .loginToinMD("sergey","123456");

    }

    @AfterMethod
    public void afterMethod() {
        System.out.println(("Finishing method"));
    }
}

