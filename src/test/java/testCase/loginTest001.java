package testCase;

import Utilities.XLutils;
import org.junit.internal.runners.statements.Fail;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class loginTest001 extends basic{
    @Test(dataProvider = "logindata")
    public void login(String username,String password)throws IOException,InterruptedException
    {
        driver.get(URL);
        logger.info("into the Website");
        pageObject.loginTest lt=new pageObject.loginTest(driver);

        lt.setUserName(username);
        Thread.sleep(1000L);
        logger.info("set username");

        lt.setPassword(password);
        Thread.sleep(1000L);
        logger.info("set password");

        lt.click_Login();
        Thread.sleep(2000L);
        logger.info("logged in");
        Thread.sleep(2000L);

        if (is_alartPresent())
        {
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
            System.out.println("alart accept for incorrect pass");
            logger.warn("username or password is incorrect");
            Assert.assertTrue(false);

        }
        else
        {
            Assert.assertTrue(true);
            Assert.assertEquals(" Guru99 Bank Manager HomePage "," Guru99 Bank Manager HomePage ");
            logger.info("into the loin page");
            lt.logout();
            Thread.sleep(2000L);
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
            logger.info("logout successfully");
        }

    }
    public boolean is_alartPresent()
    {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
           return false;
        }


    }


    @DataProvider(name="logindata")
    String [][]getdata() throws IOException {
        String path="C:\\Users\\Administrator\\IdeaProjects\\eBankingProject\\src\\test\\java\\testData\\loginData.xlsx";
        int rownum= XLutils.rowCount(path,"Sheet1");
        int cellnum= XLutils.cellCount(path,"Sheet1",1);

        String Data[][]=new String[rownum][cellnum];

        for (int i=1;i<=rownum;i++)
        {
            for (int j=0;j<cellnum;j++)
            {
                Data[i-1][j]=XLutils.getCelData(path,"Sheet1",i,j);
            }
        }
        return Data;
    }
}
