package tests;

import Utils.Properties;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;





public abstract class BaseTest {

    String os = System.getProperty("os.name").toLowerCase();

    public WebDriver driver;

    public ExtentTest logger;


    public static ExtentReports extent;
    private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();




    @BeforeSuite
    public void beforeSuite() {
        extent = ExtentManager.createInstance("extent.html");
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
        extent.attachReporter(htmlReporter);
        System.out.println(("Starting test Suite"));
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println(("Starting test"));
    }

    @BeforeClass
    public synchronized void beforeClass() {
        System.out.println(("Open chrome browser"));
        //ExtentTest parent = extent.createTest(getClass().getName());
        //parentTest.set(parent);
    }

    @BeforeMethod
    public synchronized void beforeMethod(Method method) {
        System.out.println(("Starting method without login"));
        makeChromeDriver();
        //Maximize Window
        driver.manage().window().maximize();
        //ExtentTest child = parentTest.get().createNode(method.getName());
        //test.set(child);
    }

    @AfterMethod
    public synchronized void afterMethod(ITestResult result) {
//       if (result.getStatus() == ITestResult.FAILURE)
//            test.get().fail(result.getThrowable());
//        else if (result.getStatus() == ITestResult.SKIP)
//            test.get().skip(result.getThrowable());
//        else
//            test.get().pass("Test passed");

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

//Extent report manager
//
//    public class ReportManager {
//
//        private ExtentReports extent;
//        public ExtentHtmlReporter htmlReporter;
//
//        public ExtentReports getInstance(){
//            if (extent == null) {
//                System.out.println("i am creating instance again");
//                createInstance();
//            }
//            System.out.println("i am updating instance");
//            return extent;
//        }
//
//        public  ExtentReports createInstance() {
//                System.out.println("i am creating instance");
//                extent = new ExtentReports();
//                htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/inMDExtentReport.html");
//                extent.setSystemInfo("Host Name", "inMD stage");
//                extent.setSystemInfo("Environment", "Stage");
//                extent.setSystemInfo("User Name", "QA team");
//                htmlReporter.config().setDocumentTitle("Report file for inMD regression testing ");
//                // Name of the report
//                htmlReporter.config().setReportName("reportName");
//                // Dark Theme
//                htmlReporter.config().setTheme(Theme.DARK);
//                extent.attachReporter(htmlReporter);
//                htmlReporter.setAppendExisting(true);
//            return extent;
//        }
//    }


    public static class ExtentManager {

        private  static ExtentReports extent;

        public  ExtentReports getInstance() {
            if (extent == null)
                createInstance("test-output/extent.html");

            return extent;
        }

        public static ExtentReports createInstance(String fileName) {
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
            htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
            htmlReporter.config().setChartVisibilityOnOpen(true);
            htmlReporter.config().setTheme(Theme.STANDARD);
            htmlReporter.config().setDocumentTitle(fileName);
            htmlReporter.config().setEncoding("utf-8");
            htmlReporter.config().setReportName(fileName);

            extent = new ExtentReports();
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
