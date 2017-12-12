package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AUL {
	
	public static String getProperty(String path,String key)
	{
		String v="";
		
		try {
			Properties pro=new Properties();
			pro.load(new FileInputStream(path));
			v=pro.getProperty(key);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return v;
		
	}
	
	public static void takePhoto(String folder,String TestName,WebDriver driver) 
	{
		
		String dateTime=new Date().toString().replaceAll(":", "_");
		TakesScreenshot ts=(TakesScreenshot) driver;
		File srcFile=ts.getScreenshotAs(OutputType.FILE);
		
		String destPath=folder+TestName+dateTime+".png";
		try {
			FileUtils.copyFile(srcFile, new File(destPath));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
