package Utilities;

import com.google.common.util.concurrent.Uninterruptibles;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class CommonOps extends Base {

    public static String getData(String nodeName) {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("Configuration/DataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        } catch (Exception e) {
            System.out.println("Execption in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver initIEDriver() {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    public static void
    initBrowser(String browserType) throws Exception {
        switch (browserType) {
            case "chrome":
                driver = initChromeDriver();
                break;

            case "firefox":
                driver = initFirefoxDriver();
                break;

            case "ie":
                driver = initIEDriver();
                break;

            default:
                throw new RuntimeException("invalid");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        actions = new Actions(driver);
    }


    public static void initMobile() throws Exception {
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("AppPackage"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("AppActivity"));
        try {
            mobileDriver = new AndroidDriver(new URL(getData("AppiumServer")), dc);
        } catch (Exception e) {
            System.out.println("Cen not connect to appium server, see details:" + e);
        }
        manegePages.initMortgage();
        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver, Long.parseLong(getData("Timeout")));
    }

    public static void initAPI() {
        RestAssured.baseURI = getData("urlAPI");
        httpRequest = RestAssured.given().auth().preemptive()
                .basic(getData("UserName"), getData("Password"));

    }

    public static void initElectron() {
        System.setProperty("webdriver.chrome.driver", getData("ElectronDriverPath"));
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(getData("ElectronAppPath"));
        DesiredCapabilities   dc = new DesiredCapabilities();
        dc.setCapability("chromeOptions", opt);
        dc.setBrowserName("chrome");
        driver = new ChromeDriver(dc);
        manegePages.InitToDo();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
    }
    public static void initDesktop() {
        dc.setCapability("app", getData("CalculatorApp"));
        try {
            driver = new WindowsDriver(new URL("AppiumServerDesktop"), dc);
        } catch (MalformedURLException e) {
            System.out.println("Can not connect to Appium Server, see details : " + e);
        }
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        manegePages.InitCalculator();
    }

    @BeforeClass
    @Parameters({"PlatformName"})
    public void startSession(String PlatformName) throws Exception {
         Platform = PlatformName;

        if (PlatformName.equalsIgnoreCase("web")) {
            initBrowser(getData("BrowserName"));
            actions = new Actions(driver);
            driver.get(getData("Url"));
            manegePages.initGrafana();
        }

        if (Platform.equalsIgnoreCase("mobile")) {
            initMobile();
        }
        if (Platform.equalsIgnoreCase("API")) {
            initAPI();
        }
        if (Platform.equalsIgnoreCase("electron")) {
            initElectron();

        if (Platform.equalsIgnoreCase("Desktop"))
            initDesktop();
        } else
          //to run Web need to stop//  throw new RuntimeException("Invalid platform name");
        softAssert = new SoftAssert();
        screen = new Screen();
        ManegeDB.StatConnection(getData("DBURL"), getData("DBUserName"), getData("DBPassword"));
    }

    @AfterClass
    public void stopSession() throws Exception {
        ManegeDB.CloseConnection();
        if (!Platform.equalsIgnoreCase("api")) {
            if (!Platform.equalsIgnoreCase("web"))
                Thread.sleep(5000);
            else
                driver.quit();
            if (Platform.equalsIgnoreCase("mobile")) {
                mobileDriver.quit();
            }
            if (Platform.equalsIgnoreCase("electron")) {
                driver.quit();
            }
        }

    }

    @AfterMethod
    public void afterTest() throws Exception {
        if (Platform.equalsIgnoreCase("web")) {
            Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
            driver.get("http://localhost:3000/");
        }
    }

    @BeforeMethod
    public void BeforeMethod(Method method) {
        if (!Platform.equalsIgnoreCase("api")) {
            try {
                MonteScreenRecorder.startRecord(method.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}




