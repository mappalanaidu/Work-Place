package TestNGWithPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComposePage 
{
	public WebDriver driver;
	@FindBy(xpath="//*[@class='T-I J-J5-Ji T-I-KE L3']")
	public WebElement compose;
	
	@FindBy(xpath="//a[contains(@aria-label, 'Google Account')]/span")
	public WebElement profile;
	
	@FindBy(linkText="Sign out")
	public WebElement signout;
	
	public ComposePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void clickCompose()
	{
		compose.click();
	}
	
	public void clickProfile()
	{
		profile.click();
	}
	public void clickSignOut()
	{
		signout.click();
	}


}
