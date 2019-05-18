package tests;

import Utils.Properties;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public abstract class BaseTest {

    String os = System.getProperty("os.name").toLowerCase();

    public WebDriver driver;
    public ExtentReports extent;
    public ExtentTest logger;
    public ReportManager manager=new ReportManager();



    @BeforeSuite
    public void beforeSuite() {
        System.out.println(("Starting test Suite"));
    }

    @BeforeTest
    public void beforeTest() {
        extent = manager.createInstance();
        System.out.println(("Starting test"));
    }

    @BeforeClass
    public void setup() {

       extent = manager.getInstance();
        System.out.println(("Open chrome browser"));

    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println(("Starting method without login"));
        makeChromeDriver();
        //Maximize Window
        //driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
        System.out.println(("Finishing method"));
    }

    @AfterClass
    public void teardown() {
        System.out.println(("Close chrome browser"));
        if (driver != null)
            driver.quit();
    }

    @AfterTest
    public void endReport() {
        System.out.println("extent.flush");
        System.out.println(("Finishing test"));
    }

    @AfterSuite
    public void afterSuite() {
        extent.flush();
        System.out.println(("Finishing test Suite"));
    }



    public class ReportManager {

        private ExtentReports extent;
        public ExtentHtmlReporter htmlReporter;

        public ExtentReports getInstance(){
            if (extent == null) {
                createInstance();
            }
            return extent;
        }

        public  ExtentReports createInstance() {

                extent = new ExtentReports();
                htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/inMDExtentReport.html");
                extent.setSystemInfo("Host Name", "inMD stage");
                extent.setSystemInfo("Environment", "Stage");
                extent.setSystemInfo("User Name", "QA team");
                htmlReporter.config().setDocumentTitle("Report file for inMD regression testing ");
                // Name of the report
                htmlReporter.config().setReportName("reportName");
                // Dark Theme
                htmlReporter.config().setTheme(Theme.DARK);
                extent.attachReporter(htmlReporter);
            return extent;
        }
    }


    private void makeChromeDriver() {
        //Create a Chrome driver. All test classes use this.
        if (os.contains("windows")) {
            System.setProperty("webdriver.chrome.driver", Properties.seleniumDriversPath + "chromedriver.exe");
            driver = new ChromeDriver();
        } else if (os.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
            driver = new ChromeDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");

        }
    }

    private void makeFirefoxDriver() {
        //Create a Chrome driver. All test classes use this.
        System.setProperty("webdriver.gecko.driver", Properties.seleniumDriversPath + "geckodriver.exe");
        driver = new FirefoxDriver();
    }


}
