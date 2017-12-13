package scripts;

import org.testng.annotations.Test;

import generic.ExcelReader;
import pages.EnterTimeTrackPage;
import pages.LoginPage;

public class CheckProductVersion extends BaseTest 
{
	@Test(priority=3,groups="version")
	public void testCheckProductVersion() 
	{
		String sheet="CheckProductVersion";
		String username=ExcelReader.getCellValue(EXCEL_PATH, sheet, 1, 0);
		String password=ExcelReader.getCellValue(EXCEL_PATH, sheet, 1, 1);
		String eVersion=ExcelReader.getCellValue(EXCEL_PATH, sheet, 1, 2);
		
		LoginPage l=new LoginPage(driver);
		//Enter the valid UserName
		l.setUserName(username);
		//Enter the valid Password
		l.setPassword(password);
		//Click on LoginButton
		l.clickOnLogin();
		
		EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
		// Click on Help
		e.clickHelp();
		//Click on About your actiTIME
		e.clickAboutActiTIME();
		//Verify product version
		e.verifyVersion(eVersion);
		//Click on Close Button
		e.clickClose();
		//Click on Logout button
		e.clickLogout();
		
	}

}
