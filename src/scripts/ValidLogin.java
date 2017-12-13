package scripts;

import org.testng.annotations.Test;

import generic.ExcelReader;
import pages.EnterTimeTrackPage;
import pages.LoginPage;

public class ValidLogin extends BaseTest {
	
	@Test(priority=1,groups="smoke")
	public void testValidLogin() 
	{
		String username=ExcelReader.getCellValue(EXCEL_PATH, "ValidLogin", 1, 0);
		String password=ExcelReader.getCellValue(EXCEL_PATH, "ValidLogin", 1, 1);
		String eTitle=ExcelReader.getCellValue(EXCEL_PATH, "ValidLogin", 1, 2);
		
		LoginPage l=new LoginPage(driver);
		//Enter the valid UserName
		l.setUserName(username);
		//Enter the valid Password
		l.setPassword(password);
		//Click on LoginButton
		l.clickOnLogin();
		
		//Verify Home Page is displayed
		EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
		e.verifyTitle(driver, eTitle);
		
	}

}
