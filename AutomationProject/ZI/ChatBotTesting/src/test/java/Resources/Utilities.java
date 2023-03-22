package Resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Utilities 

{
	public WebDriver driver;
	public void initializaBrowser() throws FileNotFoundException {
		
	Properties prop = new Properties();
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Resources\\GlobalData.properties");
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
	}
	driver.manage().window().maximize();
	}
}
