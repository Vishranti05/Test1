package Module1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Adactin_Login 
{
	//POM class-I
	
	//1. Data members/Global Variables should be declared globally with access level private by using @Findby Annotation
		@FindBy(xpath="//input[@name='username']") private WebElement UN;
		@FindBy(xpath="//input[@name='password']")private WebElement PSW;
		@FindBy(xpath="//input[@name='login']") private WebElement Loginbtn;
		
	//2. Initialize within a constructor with access level public using PageFactory Class
		public Adactin_Login(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
	//3:Utilize within method with access level public	
		public void enterUsername(String user)
		{
			UN.sendKeys( user);
		}
		public void enterPassword(String password)
		{
			PSW.sendKeys( password);
		}
        public void clickLoginbutton()
        {
        	Loginbtn.click();
        }
}
