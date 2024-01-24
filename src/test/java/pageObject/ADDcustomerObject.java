package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ADDcustomerObject {
    WebDriver ldriver;

    public ADDcustomerObject(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @FindBy(how = How.XPATH, using = "//a[text()='New Customer']")
    WebElement btn_newCus;

    @FindBy(how = How.NAME,using = "name")
    WebElement txt_name;

    @FindBy(how = How.XPATH,using = "(//input[@type='radio'])[1]")
    WebElement rad_male;
    @FindBy(how = How.NAME,using = "f")
    WebElement rad_female;

    @FindBy(how = How.ID_OR_NAME,using = "dob")
    WebElement cal_Date;

    @FindBy(how = How.NAME,using = "addr")
    WebElement txt_Add;

    @FindBy(how = How.NAME,using = "city")
    WebElement txt_city;

    @FindBy(how = How.NAME,using = "state")
    WebElement txt_state;

    @FindBy(how = How.NAME,using = "pinno")
    WebElement txt_pin;

    @FindBy(how = How.NAME,using = "telephoneno")
    WebElement txt_mobno;

    @FindBy(how = How.NAME,using = "emailid")
    WebElement txt_email;

    @FindBy(how = How.NAME,using = "password")
    WebElement txt_pass;

    @FindBy(how = How.XPATH,using = "//input[@type='submit']")
    WebElement btn_submit;
    @FindBy(how = How.XPATH,using = "//input[@type='Reset']")
    WebElement btn_Reset;

    public void Newcus_btn()
    {
        btn_newCus.click();
    }
    public void submit_btn()
    {
        btn_submit.click();
    }
    public void reset_btn()
    {
        btn_Reset.click();
    }

    public void cusname(String cust_name)
    {
        txt_name.sendKeys(cust_name);
    }

    public void gender_rad_male()
    {
        rad_male.click();
    }

    public void gender_rad_female()
    {
        rad_female.click();
    }
    public void dob(String day,String  month, String year)
    {
        cal_Date.sendKeys(day);
        cal_Date.sendKeys(month);
        cal_Date.sendKeys(year);
    }

    public void address(String address)
    {
        txt_Add.sendKeys(address);
    }

    public void City_name(String city)
    {
        txt_city.sendKeys(city);
    }

    public void state_name(String state)
    {
        txt_state.sendKeys(state);
    }

    public void pincode(int pin)
    {
        txt_pin.sendKeys(String.valueOf(pin));
    }

    public void Mobile_number(int mob)
    {
        txt_mobno.sendKeys(String.valueOf(mob));
    }

    public void Email(String email)
    {
        txt_email.sendKeys(email);
    }

    public void password(String Pass)
    {
        txt_pass.sendKeys(Pass);
    }



}
