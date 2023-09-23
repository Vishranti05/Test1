package Library_files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class UtilityClass 
{
	@Test
	public static String getDataFromPF(String Key) throws IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\SELENIUM_Maven_project1\\Property.properties");
		
		Properties prop=new Properties();
		prop.load(file);
		
		String Value=prop.getProperty(Key);
		return Value;
		
	}
	@Test
	public static String getDataFromExcelSheet(int Rowindex,int Cellindex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\SELENIUM_Maven_project1\\TestData\\Worksheet.xlsx");
		String Value1=WorkbookFactory.create(file).getSheet( "Sheet8").getRow(Rowindex).getCell(Cellindex).getStringCellValue();
		return Value1;
	}
	@Test
	public static void captureScreenShot(WebDriver driver,String TestcaseID) throws IOException
	{
        File Source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File Destination=new File("C:\\Users\\admin\\eclipse-workspace\\SELENIUM_Maven_project1\\Screenshot\\"+TestcaseID+".jpg");
		
		FileHandler.copy(Source, Destination);
	}
	

}
