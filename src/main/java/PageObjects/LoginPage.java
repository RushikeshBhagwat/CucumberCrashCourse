package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.*;

public class LoginPage {
 
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	private By username= By.xpath("//input[@id='input-email']");
	private By pass=By.xpath("//input[@id='input-password']");
	private By Loginbtn= By.xpath("//input[@value='Login']");
	
    private By forgotpasswordlink=By.xpath("(//a[contains(.,'Forgotten Password')])[1]");
    private By warningmsg=By.xpath("//div[@class='alert alert-danger alert-dismissible']");
    private By logoutlink=By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']");
    
    public void enterEmail(String email) {
    	
    	driver.findElement(username).sendKeys(email);
    }
    
    public void enterPassword(String password) {
    	
    	driver.findElement(pass).sendKeys(password);
    }
    
    public void clickLogin() {
    	
    	WebElement lgbtn=driver.findElement(Loginbtn);
    	lgbtn.click();
    }
    
    public void clickForgotpasslink() {
    	
    	WebElement flink=driver.findElement(forgotpasswordlink);
    	flink.click();
    }
    
    public boolean checkForgotPassPage() {
    	
    	return driver.findElement(forgotpasswordlink).isDisplayed();
    }
    
    public boolean successfullLogin() {
    
    	return driver.findElement(logoutlink).isDisplayed();
    }
    
    public String checkErrorMsgDisplayed() {
    	
    	
    	String actualerrormsg=driver.findElement(warningmsg).getText();
    	return actualerrormsg;
    }
}
