package ZoomInfo.ChatBotTesting;


import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ZoomInfoChatHomePOM {

	 
	public static void main(String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Raj\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		ChatPOM objectForPOM= new ChatPOM(driver); 
		objectForPOM.goTo();
		//driver.get("https://insent-staging10.firebaseapp.com/fe-assignment");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.findElement(By.xpath("//a[@id='hs-eu-confirmation-button']")).click();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("insent-iframe"));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='insent-popup-content']")));
		System.out.println(driver.findElement(By.xpath("//div[@id='insent-popup-content']")).getText());
		driver.findElement(By.xpath("//div[@id='insent-popup-content']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sc-qrIAp dfnBSA']")));
		System.out.println(driver.findElement(By.xpath("//div[@class='sc-qrIAp dfnBSA']")).getText());
		System.out.println(driver.findElement(By.xpath("//div[@class='sc-ipZHIp gthmea']")).getText());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Please enter your email address to assist you further!')]")));
		System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Please enter your email address to assist you further!')]")).getText());
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']")));
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("");
		driver.findElement(By.xpath("//button[@class='sc-ckVGcZ gRuMQg']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='sc-kEYyzF faNzMh']")).getText());
		
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("pethu");
		driver.findElement(By.xpath("//button[@class='sc-ckVGcZ gRuMQg']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='sc-kEYyzF faNzMh']")).getText());
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("pethu@gmail.com");
		driver.findElement(By.xpath("//button[@class='sc-ckVGcZ gRuMQg']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='sc-kEYyzF faNzMh']")).getText());
		
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("pethu.s@zoomin.com");
		driver.findElement(By.xpath("//button[@class='sc-ckVGcZ gRuMQg']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Thanks for providing your email address.')]")));
		System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Thanks for providing your email address.')]")).getText());
		

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Now give us your First name please')]")));
		System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Now give us your First name please')]")).getText());
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='plain']")));
		driver.findElement(By.xpath("//input[@name='plain']")).sendKeys("pethu");
		driver.findElement(By.xpath("//button[@class='sc-ckVGcZ gRuMQg']")).click();
		

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Please select your country')]")));
		System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Please select your country')]")).getText());
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'India')]")));
		driver.findElement(By.xpath("//div[contains(text(),'India')]")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Thank you for sharing the details')]")));
		System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Thank you for sharing the details')]")).getText());
		
		Thread.sleep(1000);
		//restart
		driver.findElement(By.xpath("//button[@class='sc-iSDuPN ilRLvK']")).click(); 
		
		//minimize
		driver.findElement(By.xpath("//div[@id='insent-card-close']")).click();
		//max
		driver.findElement(By.xpath("//div[@id='insent-launcher-icon']")).click();
		
		
		driver.switchTo().defaultContent();
		String parentWindow = driver.getWindowHandle();
		driver. switchTo(). newWindow(WindowType. TAB);
		driver.get("https://www.google.com/");
		Thread.sleep(10000);
		driver.switchTo().window(parentWindow);
		driver.switchTo().frame("insent-iframe");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("pethu.s2@zoomin.com");
		//back button
		driver.findElement(By.xpath("//div[@class='sc-fONwsr bOivmR']")).click();
		//history page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Hi')]")));
		System.out.println(driver.findElement(By.xpath("//h4[contains(text(),'Hi')]")).getText());
		System.out.println(driver.findElement(By.xpath("//p[contains(text(),'How can we test')]")).getText());
		System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Your Conversations')]")).getText());
		//3dot
		driver.findElement(By.xpath("//div[@class='sc-itybZL fskPuO']")).click();
		//allfiles
		driver.findElement(By.xpath("//div[@class='sc-eInJlc lmmwpR']")).click();
		//allfiles text
	
		System.out.println(driver.findElement(By.xpath("//div[@class='sc-fjmCvl jNyCzg']")).getText());
		
		//back button
		driver.findElement(By.xpath("//div[@class='sc-fONwsr bOivmR']")).click();
		driver.findElement(By.xpath("//div/div[1]//div[@id='insent-agent-card-agent-sender']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sc-qrIAp dfnBSA']")));
		System.out.println(driver.findElement(By.xpath("//div[@class='sc-ipZHIp gthmea']")).getText());
		driver.quit();
	}}
	
