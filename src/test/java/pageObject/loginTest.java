package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginTest {
    WebDriver ldriver;

    public loginTest(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }
    @FindBy(name = "uid")
    WebElement UserId_txt;

    @FindBy(name = "password")
    WebElement Pass_txt;

    @FindBy(name = "btnLogin")
    WebElement login_btn;

    @FindBy(name = "btnReset")
    WebElement reset_btn;

    @FindBy(xpath = "//a[text()='Log out']")
    WebElement logout;

    public void setUserName(String uName)
    {
        UserId_txt.sendKeys(uName);
    }
    public void setPassword(String pass)
    {
        Pass_txt.sendKeys(pass);
    }
    public void click_Login(){
        login_btn.click();
    }
    public void click_Reset()
    {
        reset_btn.click();
    }
    public void logout(){
        logout.click();
    }
}
