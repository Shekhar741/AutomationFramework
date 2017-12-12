package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import generic.AUL;
import generic.IAutoConstants;

public class LoginPage implements IAutoConstants{
	
	@FindBy(id="username")
	private WebElement unTB;
	
	@FindBy(name="pwd")
	private WebElement pwTB;
	
	@FindBy(xpath="//div[.='Login ']")
	private WebElement loginBTN;
	
	@FindBy(xpath="//span[contains(.,'invalid')]")
	private WebElement errMsg;
	
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setUserName(String un) 
	{
		unTB.sendKeys(un);
	}
	
	public void setPassword(String pw) 
	{
		pwTB.sendKeys(pw);
	}
	
	public void clickOnLogin()
	{
		loginBTN.click();
	}
	
	String strETO=AUL.getProperty(SETTING_PATH, "ETO");
	Long ETO=Long.parseLong(strETO);
	public void verifyErrMsgIsDisplayed(WebDriver driver) 
	{
		
		WebDriverWait wait=new WebDriverWait(driver,ETO);
		try 
		{
		    wait.until(ExpectedConditions.visibilityOf(errMsg));
		    Reporter.log("ErrMsg is Displayed",true);
		}
		catch(Exception e)
		{
			Reporter.log("ErrMsg is NOT Displayed",true);
			Assert.fail();
		}
	}

}
