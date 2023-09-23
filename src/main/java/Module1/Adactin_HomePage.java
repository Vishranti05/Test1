package Module1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Adactin_HomePage 
{
	//POM class-II
	
	//1.Data members/Global Variables should be declared globally with access level private by using @Findby Annotation
	@FindBy(xpath="//input[@name='username_show']") private WebElement USerShow;
	@FindBy(xpath="//a[text()='Logout']") private WebElement LogoutBtn;
	@FindBy(xpath="//a[text()='Click here to login again']") private WebElement ReLoginBtn;
	
	@FindBy(xpath="//select[@id='location']") private WebElement Location;
	@FindBy(xpath="//select[@id='hotels']") private WebElement Hotels;
	@FindBy(xpath="//select[@id='room_type']") private WebElement RoomType;
	@FindBy(xpath="//select[@id='room_nos']") private WebElement NumberofRooms;
	@FindBy(xpath="//input[@id='datepick_in']") private WebElement CheckInDate;
	@FindBy(xpath="//input[@id='datepick_out']") private WebElement CheckOutDate;
	@FindBy(xpath="//select[@id='adult_room']") private WebElement AdultsperRoom;
	@FindBy(xpath="//select[@id='child_room']") private WebElement ChildrenperRoom;
	@FindBy(xpath="//input[@id='Submit']") private WebElement Searchbtn;
	@FindBy(xpath="//input[@id='radiobutton_0']") private WebElement Radiobtn;
	@FindBy(xpath="//input[@id='continue']") private WebElement ContinueBtn;
	@FindBy(xpath="//*[@id='first_name']") private WebElement FN;
	@FindBy(xpath="//*[@id='last_name']") private WebElement LN;
	@FindBy(xpath="//*[@id='address']") private WebElement BillingAddress;
	@FindBy(xpath="//*[@id='cc_num']") private WebElement CCN;
	@FindBy(xpath="//*[@id='cc_type']") private WebElement CCT;
	@FindBy(xpath="//*[@id='cc_exp_month']") private WebElement EDMonth;
	@FindBy(xpath="//*[@id='cc_exp_year']") private WebElement EDYear;
	@FindBy(xpath="//*[@id='cc_cvv']") private WebElement CVV;
	@FindBy(xpath="//*[@id='book_now']") private WebElement BookNowBtn;
		

	
	//2.Initialize within a constructor with access level public using PageFactory Class
	public Adactin_HomePage (WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
	//3.Utilize within methods with access level public
	public String getUsername()
	{
		String A=USerShow.getAttribute( "value");
		String[] S=A.split( " ");
		         String S1=S[0];
		         String ActualUsername=S[1];
		         return ActualUsername;
		         
	}
	public void clickLogoutButton()
	{
		LogoutBtn.click();
	}
	public void clickReLoginButton()
	{
		ReLoginBtn.click();
	}
	
	//For a book a hotel
	
	 public void SelectLocation(String LOC) 
	 {
		 Select S1=new Select(Location);
		 S1.selectByVisibleText(LOC);   
	 }
	 
	 public void SelectHotels(String HO) 
	 {
		 Select S1=new Select(Hotels);
		 S1.selectByVisibleText(HO);  
	 }
	 
	 public void SelectRoomType(String RT)  
	 {
		 Select S1=new Select(RoomType);
		 S1.selectByVisibleText(RT);
	 }

	 public void SelectNumberofRooms(String NOR) 
	 {
		 Select S1=new Select(NumberofRooms);
		 S1.selectByVisibleText(NOR);
	 }
	 
	 public void EnterCheckInDate(String CD) 
	 {
		 CheckInDate.sendKeys(CD);
	 }
	 
	 public void EnterCheckOutDate(String CO)
	 {
		 CheckOutDate.sendKeys(CO);
	 }
	 
	 public void SelectAdultsperRoom(String APR) 
	 {
		 Select S1=new Select(AdultsperRoom);
		 S1.selectByVisibleText(APR);
	 }

	 public void SelectChildrenperRoom(String CPR)  
	 {
		 Select S1=new Select(ChildrenperRoom);
		 S1.selectByVisibleText(CPR);
	 }

	 public void ClickSearchButton() 
	 {
		 Searchbtn.click();
	 }
	 
	 public void SelectRadioButton() 
	 {
		 Radiobtn.click();
	 }

	 public void ClickContinueButton() 
	 {
		 ContinueBtn.click();
	 }
	 
	 public void EnterFirstName(String FNM)  
	 {
		FN.sendKeys(FNM); 
	 }



	 public void EnterLastName(String LNM) 
	 {
		LN.sendKeys(LNM); 
	 }

	 public void EnterBillingAddress(String BA) 
	 {
		 BillingAddress.sendKeys(BA);  
	 }

	 public void EnterCreditCardNo(String CCNumber)  
	 {
		 CCN.sendKeys(CCNumber);
	 }

	 public void SelectCreditCardType(String CT) 
	 {
		 Select S1=new Select(CCT);
		 S1.selectByVisibleText(CT);
	 }
	 
	 public void SelectEDMonth(String EDM) 
	 {
		 Select S1=new Select(EDMonth);
		 S1.selectByVisibleText(EDM);
		
	 }

	 public void SelectEDYear(String EDY) 
	 {
		 Select S1=new Select(EDYear);
		 S1.selectByVisibleText(EDY);
	 }

	 public void EnterCVVNumber(String CVVN) 
	 {
		 CVV.sendKeys(CVVN);
	 }

	 public void ClickBookNowButton() 
	 {
		 BookNowBtn.click();
	 }


}
