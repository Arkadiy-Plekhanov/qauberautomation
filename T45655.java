import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class T45655 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
//Verify that the user can send a message - Chrome 
		Properties property = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\sujai\\Documents\\Portnov\\Vladimir - Selenium\\Eclipse workspace\\BidQA\\src\\BidQAData.properties");
		property.load(file);
		
		System.setProperty("webdriver.chrome.driver", property.getProperty("SystemSetPropertyChrome"));
		WebDriver driver = new ChromeDriver();
		
		driver.get(property.getProperty("url"));
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[8]/a")).click();
				driver.findElement(By.xpath(".//*[@name='log']")).sendKeys(property.getProperty("QAEnggUserName"));
				driver.findElement(By.xpath(".//*[@id='login_password']")).sendKeys(property.getProperty("QAEnggPassword"));
				driver.findElement(By.xpath(".//*[@id='submits']")).click();
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				//Moving mouse to My Account
				Actions xyz= new Actions(driver);
				WebElement MyAccount = driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[7]/a"));
				xyz.moveToElement(MyAccount).build().perform();
				
				//Click on Private Message
				driver.findElement(By.partialLinkText("Private Messages")).click();
				
				//Click on Send new message
				driver.findElement(By.partialLinkText("Send New Message")).click();
				
				driver.findElement(By.xpath(".//*[@id='to_as']")).sendKeys("Su");
				
				//Enter Subject
				driver.findElement(By.id("subject_a")).sendKeys(property.getProperty("T45655SubjectPvtMsg"));
				
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				//driver.findElement(By.className("mce-content-body ")).sendKeys("Testing Private messaging..... text");
				//Enter message
								
				WebElement Tab = driver.findElement(By.id("subject_a"));
				Tab.sendKeys(Keys.TAB);
				Thread.sleep(1000);
				
				driver.switchTo().activeElement().sendKeys(property.getProperty("T45655PvtMsgBody"));
								
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//input[@value='Send Message']")).sendKeys(Keys.ENTER);
				
				//Logout
				driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[7]/a")).click();
								
				driver.quit();
		
	}

}
