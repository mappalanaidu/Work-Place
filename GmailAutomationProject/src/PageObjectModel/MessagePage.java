package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessagePage 
{
	public WebDriver driver;
	@FindBy(name="to")
	public WebElement to;
	@FindBy(name="subjectbox")
	public WebElement subject;
	@FindBy(xpath="(//*[@aria-label='Message Body'])[2]")
	public WebElement body;
	@FindBy(xpath="//*[text()='Send']")
	public WebElement send;
	
	
	public MessagePage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	public void fillTo(String x)
	{
	to.sendKeys(x);
	}
	public void fillSubject(String x)
	{
	subject.sendKeys(x);
	}
	public void fillBody(String x)
	{
	body.sendKeys(x);
	}

	public void clickSend()
	{
	send.click();
	}
		
}
