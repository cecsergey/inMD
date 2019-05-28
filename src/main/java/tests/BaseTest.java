package tests;

import Utils.Properties;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;





public abstract class BaseTest {

    static String os = System.getProperty("os.name").toLowerCase();

    public static WebDriver driver;

    //public ExtentTest logger;


    public static ExtentReports extent;
    private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();




    @BeforeSuite
    public void beforeSuite() {
        extent = ExtentManager.createInstance("extent.html");
        //ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
        //extent.attachReporter(htmlReporter);
        System.out.println(("Starting test Suite"));
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println(("Starting test"));
    }

    @BeforeClass
    public synchronized void beforeClass() {
        System.out.println(("Open chrome browser"));
        ExtentTest parent = extent.createTest(getClass().getName());
        parentTest.set(parent);
    }

    @BeforeMethod
    public synchronized void beforeMethod(Method method) {
        System.out.println(("Starting method without login"));
        makeChromeDriver();
        //Maximize Window
        driver.manage().window().maximize();
        ExtentTest child = parentTest.get().createNode(method.getName());
        test.set(child);
    }

    @AfterMethod
    public synchronized void afterMethod(ITestResult result)  throws Exception {
       if (result.getStatus() == ITestResult.FAILURE){
            test.get().fail(result.getThrowable());
            String screenshotPath = ExtentManager.getScreenShot(driver, result.getName());
            test.get().fail("Test Case Failed Snapshot is below " + test.get().addScreenCaptureFromPath(screenshotPath));

       }
       else if (result.getStatus() == ITestResult.SKIP){
            test.get().skip(result.getThrowable());
            //String screenshotPath = ExtentManager.getScreenShot(driver, result.getName());
       }
       else{
            test.get().pass("Test passed");
            //String screenshotPath = ExtentManager.getScreenShot(driver, result.getName());
       }

        extent.flush();
        driver.quit();
    }

    @AfterClass
    public void teardown() {
        System.out.println(("Close chrome browser"));
        if (driver != null)
            driver.quit();
    }

    @AfterTest
    public void afterTest() {
        System.out.println(("Finishing test"));
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println(("Finishing test Suite"));
    }



    public static class ExtentManager {

        private  static ExtentReports extent;

        public  ExtentReports getInstance() {
            if (extent == null)
                createInstance("extent.html");

            return extent;
        }

        public static ExtentReports createInstance(String fileName) {
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/inMDExtentReport.html");
            extent = new ExtentReports();
            extent.setSystemInfo("Host Name", "inMD stage");
            extent.setSystemInfo("Environment", "Stage");
            extent.setSystemInfo("User Name", "QA team");
            htmlReporter.config().setDocumentTitle("Report file for inMD regression testing ");
            // Name of the report
            htmlReporter.config().setReportName(fileName);
            // Dark Theme
            htmlReporter.config().setTheme(Theme.DARK);
            htmlReporter.config().setChartVisibilityOnOpen(true);
            htmlReporter.config().setEncoding("utf-8");

            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);

            return extent;
        }

        //This method is to capture the screenshot and return the path of the screenshot.
        public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
            String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            // after execution, you could see a folder "FailedTestsScreenshots" under src folder
            String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
            File finalDestination = new File(destination);
            FileUtils.copyFile(source, finalDestination);
            return destination;
    }
    }


    public static void makeChromeDriver() {
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
