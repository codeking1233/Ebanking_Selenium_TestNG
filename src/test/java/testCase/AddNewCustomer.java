package testCase;

import Utilities.XLutils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.*;

import java.io.IOException;
import java.util.random.RandomGenerator;

public class AddNewCustomer extends basic{


    @Test
    public void newcustomer() throws InterruptedException {
        driver.get(URL);

        loginTest lt=new loginTest(driver);

        // LOG IN TO THE APPLICATION
        lt.setUserName(userName);
        logger.info("give user name");
        Thread.sleep(2000L);
        lt.setPassword(password);
        logger.info("give password");
        Thread.sleep(1000L);

        lt.click_Login();
        logger.info("logged in");
        Thread.sleep(2000L);

        //CREATING NEW CUSTOMER
        ADDcustomerObject addcust= new ADDcustomerObject(driver);
        addcust.Newcus_btn();
        Thread.sleep(2000L);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='3rd party ad content']")));
        Thread.sleep(1000L);
        WebElement btn_cross= driver.findElement(By.id("dismiss-button"));
        WebElement btn_close=driver.findElement(By.xpath("//div[@id='dismiss-button']"));
        if(btn_cross.isDisplayed())
        {
            btn_cross.click();
        }
        else if(btn_close.isDisplayed())
        {
            btn_close.click();
        }
        driver.switchTo().defaultContent();
        logger.info("click to create new customer");

        addcust.cusname("Test");
        Thread.sleep(1000L);
        addcust.gender_rad_male();
        Thread.sleep(1000L);
        addcust.dob("22","09","1998");
        Thread.sleep(1000L);
        addcust.address("123 down street");
        Thread.sleep(1000L);
        addcust.City_name("Kolkata");
        Thread.sleep(1000L);
        addcust.state_name("WestBengal");
        Thread.sleep(1000L);
        addcust.pincode(700048);
        Thread.sleep(1000L);
        addcust.Mobile_number(987065467);
        Thread.sleep(1000L);
        addcust.Email("test123@gmail.com");
        Thread.sleep(1000L);

        logger.info("customer created");

        addcust.submit_btn();

    }
    public String randomString()
    {
        String genaratedString=RandomStringUtils.randomAlphabetic(8);
        return genaratedString;

    }


}
