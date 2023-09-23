package Module1_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Library_files.BaseClass;
import Library_files.UtilityClass;
import Module1.Adactin_HomePage;
import Module1.Adactin_Login;

public class Adactin_Testclass extends BaseClass
{
	Adactin_Login Login;
	Adactin_HomePage Home;
	String TestcaseID;
	@BeforeClass
	public void OpenBrowser()
	{
		initializeBrowser();
		//create object of POM class-I
		 Login=new Adactin_Login(driver);
		 //create object of POM-II
		  Home=new Adactin_HomePage(driver);
	}
	@BeforeMethod
	public void LoginToApp() throws IOException
	{
		Login.enterUsername( UtilityClass.getDataFromPF( "Username"));
		Login.enterPassword(UtilityClass.getDataFromPF("Password"));
		Login.clickLoginbutton();
	}
	@Test(priority=1)
	public void VerifyUN() throws EncryptedDocumentException, IOException
	{
		TestcaseID="TC100";
	   String ActualUsername=Home.getUsername();
	   String ExpectedUsername=UtilityClass.getDataFromExcelSheet(0, 0);
	   
	   Assert.assertEquals( ActualUsername,ExpectedUsername );
	}
	
	@Test(priority=2)
	public void getTitleOfApp() throws EncryptedDocumentException, IOException
	{
		TestcaseID="TC101";
		String ActualTitle=driver.getTitle();
		String ExpectedTitle=UtilityClass.getDataFromExcelSheet(1, 0);
		Assert.assertEquals( ActualTitle,ExpectedTitle );
	}
	
	@Test(priority=3)
	public void BookHotel() throws EncryptedDocumentException, IOException
	{
		TestcaseID="TC102";
		Home.SelectLocation(UtilityClass.getDataFromExcelSheet(2, 0)); 
		Home.SelectHotels(UtilityClass.getDataFromExcelSheet(3, 0)); 
		Home.SelectRoomType(UtilityClass.getDataFromExcelSheet(4, 0)); 
		Home.SelectNumberofRooms(UtilityClass.getDataFromExcelSheet(5, 0)); 
		Home.EnterCheckInDate(UtilityClass.getDataFromExcelSheet(6, 0)); 
		Home.EnterCheckOutDate(UtilityClass.getDataFromExcelSheet(7, 0)); 
		Home.SelectAdultsperRoom(UtilityClass.getDataFromExcelSheet(8, 0));  
		Home.SelectChildrenperRoom(UtilityClass.getDataFromExcelSheet(9, 0));
		Home.ClickSearchButton();
		Home.SelectRadioButton();
		Home.ClickContinueButton();
		Home.EnterFirstName(UtilityClass.getDataFromExcelSheet(0, 1)); 
		Home.EnterLastName(UtilityClass.getDataFromExcelSheet(1, 1)); 
		Home.EnterBillingAddress(UtilityClass.getDataFromExcelSheet(2, 1)); 
		Home.EnterCreditCardNo(UtilityClass.getDataFromExcelSheet(3, 1)); 
		Home.SelectCreditCardType(UtilityClass.getDataFromExcelSheet(4, 1));
		Home.SelectEDMonth(UtilityClass.getDataFromExcelSheet(5, 1));
		Home.SelectEDYear(UtilityClass.getDataFromExcelSheet(6, 1)); 
		Home.EnterCVVNumber(UtilityClass.getDataFromExcelSheet(7, 1));
		Home.ClickBookNowButton();
			}


	@AfterMethod()
	public void logOutfromApp(ITestResult Result) throws IOException
	{
		
		if(Result.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.captureScreenShot(driver, TestcaseID);
		}
		Home.clickLogoutButton();
		Home.clickReLoginButton();
	}
	@AfterClass()
	public void closeBrowser()
	{
		driver.quit();
	}
	
	
	
	
}
