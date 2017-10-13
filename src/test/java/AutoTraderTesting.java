import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.base.Function;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.fail;

/**
 * Created by Administrator on 13/10/2017.
 */
public class AutoTraderTesting {

    private WebDriver webDriver;
    private static ExtentReports report;

    @BeforeClass
    public static void init(){
        report = new ExtentReports();
        report.attachReporter(new ExtentHtmlReporter(System.getProperty("user.dir") + File.separatorChar + "AutoTraderReport" + ".html"));
    }

    @Before
    public void setUp(){
        webDriver = new ChromeDriver();
        webDriver.navigate().to("https://www.autotrader.co.uk/");
        webDriver.manage().window().maximize();
    }

    @After
    public void tearDown(){webDriver.quit();}

    @AfterClass
    public static void cleanUp(){report.flush();}

    public String takeScreenshot(WebDriver webDriver, String fileName) throws IOException {
        File scrFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        String pathname = System.getProperty("user.dir") + File.separatorChar + "MyScreenshot" + ".jpg";
        FileUtils.copyFile(scrFile, new File(pathname));
        return pathname;
    }

    @Test
    public void signUp(){
        ExtentTest signuptest = report.createTest("signUpTest");
        HomePage hp = PageFactory.initElements(webDriver, HomePage.class);
        hp.clickSignIn();
        SignInPage sp = PageFactory.initElements(webDriver, SignInPage.class);
        sp.clickSignUp();
        Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver).withTimeout(30, SECONDS).pollingEvery(5, SECONDS).ignoring(NoSuchElementException.class);
        boolean emailTB = wait.until(new Function<WebDriver, Boolean>()
        {
            public Boolean apply(WebDriver driver) {
                return driver.findElement(By.cssSelector("#email")).isDisplayed();
            }
        });
        sp.loginInfo();
        sp.submitSignUp();
        try{
            assertTrue(hp.doesIconExist());
            signuptest.log(Status.PASS, "The user is able to create an account and sign up");
            signuptest.info("Using data from excel spreadsheet for username and password and then altering this data each time " +
                    "as a different email is required each time. Using the sign in icon to check whether login was successful.");
        }catch (AssertionError e){
            fail();
            signuptest.log(Status.FAIL, "The test has failed, maybe because the user is trying to sign up with an account that already exists.");
            String signupFailScreenshot = null;
            try {
                signupFailScreenshot = takeScreenshot(webDriver, "MyScreenshot");
                signuptest.addScreenCaptureFromPath(signupFailScreenshot);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Test
    public void signIn(){
        ExtentTest signintest = report.createTest("signUpTest");
        HomePage hp = PageFactory.initElements(webDriver, HomePage.class);
        hp.clickSignIn();
        SignInPage sp = PageFactory.initElements(webDriver, SignInPage.class);
        sp.enterDetails();
        sp.submitSignIn();
        AddYourCar ac = PageFactory.initElements(webDriver, AddYourCar.class);
        try {
            ac.doesIconExist();
            signintest.log(Status.PASS, "The user is able to sign into to a pre-made account");
            signintest.info("After entering details to an already registered account the user " +
                    "is able to sumbit them and log in is identified by the presence of the log in icon");
        }catch(AssertionError e){
            fail();
            signintest.log(Status.FAIL, "The test has failed, maybe because the user they are trying to logon with" +
                    "does not exist.");
        }
    }

    @Test
    public void buyingSearch(){fail("Not yet implemented");}

    @Test
    public void jobSearch(){
//        HomePage hp = PageFactory.initElements(webDriver, HomePage.class);
//        WebElement careerLink = hp.clickCareers();
//        Actions builder = new Actions(webDriver);
//        builder.moveByOffset(careerLink.getLocation().getX()+100, careerLink.getLocation().getY()+50).click().perform();
    }

    @Test
    public void getEvaulation(){fail("Not yet implemented");}

    @Test
    public void bikeFinance(){fail("Not yet implemented");}

    @Test
    public void localDealers(){fail("Not yet implemented");}

    @Test
    public void editAccount(){fail("Not yet implemented");}

    @Test
    public void readReview(){
        HomePage hp = PageFactory.initElements(webDriver, HomePage.class);
        hp.clickSkoda();
    }

    @Test
    public void searchForVans(){fail("Not yet implemented");}
}
