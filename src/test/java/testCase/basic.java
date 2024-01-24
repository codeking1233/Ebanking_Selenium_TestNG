package testCase;

import Utilities.readConfig;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Before;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;


public class basic {
    readConfig rc=new readConfig();

    public String URL=rc.url(); //Base url for the project
    public String userName=rc.Uname(); // user name to login
    public String password=rc.psw(); // password to login
    public WebDriver driver;
    public static Logger logger;

    @Parameters("Browser")
    @BeforeClass
    public void setup(String br)
    {

        logger=Logger.getLogger("eBankingProject");
        PropertyConfigurator.configure("log4j.properties");

        if (br.equals("chrome")){
        System.setProperty("webdriver.driver.chromedriver",rc.chrome());
        driver=new ChromeDriver();
       }
        else if (br.equals("gecko")) {
        System.setProperty("webdriver.driver.geckodriver",rc.fireFox());
        driver=new FirefoxDriver();
        }
        else if (br.equals("MsEdge")) {
            System.setProperty("webdriver.driver.msedgedriver",rc.edgeDriver());
            driver=new EdgeDriver();
        }
        driver.manage().window().maximize();

    }
    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

//    public void screenshot(WebDriver driver,String screenshotname) throws IOException {
////        String datename=new SimpleDateFormat("yyyymmddhhmm").format(new Date());
//        TakesScreenshot ts=(TakesScreenshot) driver;
//        File Source=ts.getScreenshotAs(OutputType.FILE);
//        String destination="C:\\Users\\Administrator\\IdeaProjects\\selenium\\Screenshots\\"+screenshotname+".png";
//        File finaldestination=new File(destination);
//        FileUtils.copyFile(Source,finaldestination);
//        System.out.println("screenshot taken");
//    }

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {

        String path="C:\\Users\\Administrator\\IdeaProjects\\eBankingProject\\screenshots\\" + testResult.getName() + "-" +  ".png";
        if (testResult.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(path));
        }
    }


}
