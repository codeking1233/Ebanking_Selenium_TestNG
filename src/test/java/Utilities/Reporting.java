package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import testCase.basic;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class Reporting extends TestListenerAdapter implements ITestListener {

    public ExtentTest logger;

    public ExtentSparkReporter Extentspark;
    public ExtentReports Extent;
    WebDriver driver=null;
    String filePath="C:\\Users\\Administrator\\IdeaProjects\\eBankingProject\\screenshots";

    public void onStart(ITestContext testContext){
        String reportname=testContext.getName()+"-Extent-report.html";
        Extentspark=new ExtentSparkReporter("C:\\Users\\Administrator\\IdeaProjects\\eBankingProject\\screenshots\\"+reportname);

        try {
            Extentspark.loadXMLConfig("C:\\Users\\Administrator\\IdeaProjects\\eBankingProject\\extent-report.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Extent=new ExtentReports();

        Extent.attachReporter(Extentspark);
        Extent.setSystemInfo("Host name","localhost");
        Extent.setSystemInfo("Environment","QA");
        Extent.setSystemInfo("User","sauryadeep");

        Extentspark.config().setReportName("testBanking");
        Extentspark.config().setDocumentTitle("extentReport");
        Extentspark.config().setTheme(Theme.DARK);

    }
    public void onTestSuccess(ITestResult testResult){

        logger=Extent.createTest(testResult.getName());
        logger.log(Status.PASS, MarkupHelper.createLabel(testResult.getName(), ExtentColor.GREEN));


    }
    public void onTestFailure(ITestResult tr){
        logger=Extent.createTest(tr.getName());
        logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
        logger.log(Status.FAIL,"TEXT CASE FAILED -- "+ tr.getThrowable());
    }

    public void onTestSkipped(ITestResult tr){
        logger=Extent.createTest(tr.getName());
        logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.YELLOW));
    }
    public void onFinish(ITestContext tr){
        Extent.flush();
    }

}

