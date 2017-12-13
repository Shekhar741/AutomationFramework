package scripts;

import org.testng.annotations.Test;

import generic.ExcelReader;
import pages.LoginPage;

public class InvalidLogin extends BaseTest {
	
	@Test(priority=2,groups="login")
	public void testInvalidLogin() 
	{
		String sheet="InvalidLogin";
		String username=ExcelReader.getCellValue(SETTING_PATH, sheet, 1, 0);
		String password=ExcelReader.getCellValue(SETTING_PATH, sheet, 1, 1);
		
		LoginPage l=new LoginPage(driver);
		l.setUserName(username);
		//Enter the valid Password
		l.setPassword(password);
		//Click on LoginButton
		l.clickOnLogin();
		
		l.verifyErrMsgIsDisplayed(driver);
	}

}
