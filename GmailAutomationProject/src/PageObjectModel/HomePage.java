package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	public WebDriver driver;
@FindBy(name="identifier")
public WebElement uid;

@FindBy(xpath="//*[text()='Next']")
public WebElement uidnext;
 
public HomePage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
public void filluid(String x)
{
	uid.sendKeys(x);
}

public void uidnext()
{
	uidnext.click();
}

}