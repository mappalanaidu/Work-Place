package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	public WebDriver driver;
	
	@FindBy(name="mobileNo")
	public WebElement mbno;
	
	@FindBy(name="password")
	public WebElement pwd;
	
	@FindBy(xpath="(//button[contains(text(),'Login')]) [1]")
	public WebElement signin;
	
	@FindBy(xpath="//*[text()='Enter your mobile number']")
	public WebElement mbno_blank_err;
	
	@FindBy(xpath="(//*[text()='Enter password'])[1]")
	public WebElement pwd_blank_err;
	
	@FindBy(xpath="//*[text()='Your mobile number is not register with us.']")
	public WebElement mbno_invalid_err;
	
	@FindBy(xpath="//*[text()='Incorrect number or password! Try Again.']")
	public WebElement pwd_invalid_err;
	
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void fillmbno(String x)
	{
		mbno.sendKeys(x);
	}
	public void fillpwd(String x)
	{
		pwd.sendKeys(x);
	}
	public void clicksignin()
	{
		signin.click();
	}
}
