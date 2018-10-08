package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendSMSPage 
{
	public WebDriver driver;
	
	@FindBy(xpath="")
	public WebElement sendsms;
	
	@FindBy(xpath="")
	public WebElement menu;
	
	@FindBy(xpath="")
	public WebElement logout;
	
	public SendSMSPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void logoutclick()
	{
		logout.click();
	}
	
	public void clickmenu()
	{
		menu.click();
	}

}
