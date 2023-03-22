package Resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import ZoomInfo.ChatBotTesting.ChatPOM;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest 

{
	ChatPOM chatPOM;
	public WebDriver driver;
	public ChatPOM initializaBrowser() throws IOException {
	
	Properties prop = new Properties();
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Resources\\GlobalData.properties");
	prop.load(fis);
	String browser = prop.getProperty("browser");
	
	if (browser.equalsIgnoreCase("chrome"))
	{
	System.setProperty("webdriver.http.factory", "jdk-http-client");
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Raj\\Downloads\\chromedriver_win32\\chromedriver.exe");
	//WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	
	}
	else if (browser.equalsIgnoreCase("edge"))
	{
		System.setProperty("webdriver.edge.driver", "edge.exe");
		driver=new EdgeDriver();
	}
	driver.manage().window().maximize();
	
	chatPOM=new ChatPOM(driver);
	chatPOM.goTo();
	return chatPOM;
	
	}
	
	
	
}
