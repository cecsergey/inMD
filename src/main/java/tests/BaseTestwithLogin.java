package tests;

import Pages.HomePage;
import Pages.UserActivityDDL;
import Utils.Properties;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseTestwithLogin {
    String os = System.getProperty("os.name").toLowerCase();

    public WebDriver driver;
    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest logger;

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

    @BeforeSuite
    public void beforeSuite () {
        System.out.println(("Starting test Suite"));
    }

    @BeforeTest
    public void startReportSecond() {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/inMDExtentReport.html");
        // Create an object of Extent Reports
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "inMD stage");
        extent.setSystemInfo("Environment", "Stage");
        extent.setSystemInfo("User Name", "QA team");
        System.out.println(("Starting test"));
        htmlReporter.config().setDocumentTitle("Report file for inMD regression testing ");
        // Name of the report
        htmlReporter.config().setReportName("Regression test report ");
        // Dark Theme
        htmlReporter.config().setTheme(Theme.DARK);
    }

    @BeforeClass
    public void setup () {
        System.out.println(("Open chrome browser"));
        makeChromeDriver();
        //Maximize Window
        driver.manage().window().maximize();
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
    public void getResultSecond(ITestResult result) throws NullPointerException{
//        if(result.getStatus() == ITestResult.FAILURE){
//            //MarkupHelper is used to display the output in different colors
//            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
//            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
//            //To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
//            //We do pass the path captured by this method in to the extent reports using "logger.addScreenCapture" method.
//            //String Scrnshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");
//            //String screenshotPath = getScreenShot(driver, result.getName());
//            //To add it in the extent report
//            //logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));
//        }
//        else if(result.getStatus() == ITestResult.SKIP){
//            logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
//        }
//        else if(result.getStatus() == ITestResult.SUCCESS)
//        {
//            logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
//        }

        driver.quit();
        System.out.println(("Finishing method"));
    }

    @AfterClass
    public void teardown () {
        System.out.println(("Close chrome browser"));
        driver.quit();
    }

    @AfterTest
    public void endReport() {
      extent.flush();
        System.out.println(("Finishing test"));
    }

    @AfterSuite
    public void afterSuite () {
        System.out.println(("Finishing test Suite"));
    }


    }


