package ZoomInfo.ChatBotTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChatPOM extends BaseFunctions{
	
	WebDriver driver;
	
	public ChatPOM(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@id='hs-eu-confirmation-button']")
	WebElement confirmationButton;
	
	@FindBy(xpath="//div[@id='insent-popup-content']")
	WebElement welcomeText;
	 
	@FindBy(xpath="//div[@class='sc-qrIAp dfnBSA']")
	WebElement headerTitle;
	
	@FindBy(xpath="//div[@class='sc-ipZHIp gthmea']")
	WebElement headerMessage;
	
	@FindBy(xpath="//div[contains(text(),'Please enter')]")
	WebElement emailRequestText;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement emailField;
	
	@FindBy(xpath="//button[@class='sc-ckVGcZ gRuMQg']")
	WebElement sendButtonClick;
	
	@FindBy(xpath="//div[@class='sc-kEYyzF faNzMh']")
	WebElement errorMessage;
	
	@FindBy(xpath="//div[contains(text(),'Thanks for')]")
	WebElement thanksForEmailText;
	
	@FindBy(xpath="//div[contains(text(),'Now give us your First')]")
	WebElement firstNameRequestText;
	
	@FindBy(xpath="//input[@name='plain']")
	WebElement firstNameField;
	
	@FindBy(xpath="//div[contains(text(),'Please select your country')]")
	WebElement countryRequestText;
	
	@FindBy(xpath="//div[contains(text(),'India')]")
	WebElement countryIndia;
	
	@FindBy(xpath="//div[contains(text(),'Thank you for sharing the details')]")
	WebElement detailsSharedText;
	
	@FindBy(xpath="//button[@class='sc-iSDuPN ilRLvK']")
	WebElement restartConversation;
	
	@FindBy(xpath="//div[@id='insent-card-close']")
	WebElement minimizeChat;
	
	@FindBy(xpath="//div[@id='insent-launcher-icon']")
	WebElement maximizeChat;
	
	@FindBy(xpath="//div[@class='sc-fONwsr bOivmR']")
	WebElement backNavigationButton;
	
	@FindBy(xpath="//h4[contains(text(),'Hi')]")
	WebElement historyPageHeadingText;
	
	@FindBy(xpath="//p[contains(text(),'How can we test')]")
	WebElement historyPageParaText;
	
	@FindBy(xpath="//div[contains(text(),'Your Conversations')]")
	WebElement historyPageConversationText;
	
	@FindBy(xpath="//div[@class='sc-itybZL fskPuO']")
	WebElement menuIcon;
	
	@FindBy(xpath="//div[@class='sc-eInJlc lmmwpR']")
	WebElement allFiles;
	
	@FindBy(xpath="//div[@class='sc-fjmCvl jNyCzg']")
	WebElement allFilesPageText;
	
	@FindBy(xpath="//div/div[1]//div[@id='insent-agent-card-agent-sender']")
	WebElement openFirstConversation;
	
	
	
	String webSiteURL = "https://insent-staging10.firebaseapp.com/fe-assignment";
	
	public void goTo()
	{
		driver.get(webSiteURL);
	}
	
	String frameId = "insent-iframe";
	By locator=By.xpath("//div[@id='insent-popup-content']");
	
	public String welcomeTextInChatBot()
	{
		confirmationButton.click();
		visibilityOfFrame(frameId);
		visibilityOfElement(locator);
		return welcomeText.getText();
	}
	
	
	By requestForEmail=By.xpath("//div[contains(text(),'Please enter your email')]");
	public String[] textMessageInInitialScreen()
	{
		welcomeText.click();
		visibilityOfElement(requestForEmail);
		String[] values = new String[3];
		values[0]=headerTitle.getText();
		values[1]=headerMessage.getText();
		values[2]=emailRequestText.getText();
		return values;
	}
	
	By emailInputField=By.xpath("//input[@name='email']");
	public String emailErrorMessage(String email)
	{
		visibilityOfElement(emailInputField);
		emailField.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		emailField.sendKeys(email);
		sendButtonClick.click();
		return errorMessage.getText();
	}
	
	By thanksTextForEmail=By.xpath("//div[contains(text(),'Thanks for providing your email')]");
	public String[] validEmail(String email)
	{
		visibilityOfElement(emailInputField);
		emailField.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		emailField.sendKeys(email);
		sendButtonClick.click();
		visibilityOfElement(thanksTextForEmail);
		String[] values = new String[2];
		values[0]=thanksForEmailText.getText();
		values[1]=firstNameRequestText.getText();
		return values;
	}
	
	By nameInputField = By.xpath("//input[@name='plain']");
	By reuestForCountry = By.xpath("//div[contains(text(),'Please select your country')]");
	public String getTextAfterFirstName(String name)
	{
		visibilityOfElement(nameInputField);
		firstNameField.sendKeys(name);
		sendButtonClick.click();
		visibilityOfElement(reuestForCountry);
		return countryRequestText.getText();
	}
	
	By country = By.xpath("//div[contains(text(),'India')]");
	By afterCountrySubmit = By.xpath("//div[contains(text(),'Thank you for sharing the details')]");
	public String finalTextAfterCountryDetail(String name)
	{
		visibilityOfElement(country);
		countryIndia.click();
		sendButtonClick.click();
		visibilityOfElement(afterCountrySubmit);
		return detailsSharedText.getText();
	}
	
	public void restartConversation()
	{
		restartConversation.click();
	}
	
	public void minimizeChat()
	{
		minimizeChat.click();
	}
	
	public void maximizeChat()
	{
		maximizeChat.click();
	}
	
	String newURL="https://www.google.com/";
	public void launchNewTabAndSwitchToFrame() throws InterruptedException
	{
		driver.switchTo().defaultContent();
		String parentWindow = driver.getWindowHandle();
		driver. switchTo(). newWindow(WindowType. TAB);
		driver.get(newURL);
		Thread.sleep(10000);
		driver.switchTo().window(parentWindow);
		driver.switchTo().frame(frameId);
	}
	
	By headline = By.xpath("//h4[contains(text(),'Hi')]");
	public String[] verifyContentInMainScreen()
	{
		backNavigationButton.click();
		visibilityOfElement(afterCountrySubmit);
		String[] home = new String[3];
		home[0]=historyPageHeadingText.getText();
		home[1]=historyPageParaText.getText();
		home[2]=historyPageConversationText.getText();
		return home;
	}
	
	public String allFilesNavigation()
	{
		menuIcon.click();
		allFiles.click();
		return allFilesPageText.getText();
	}
	
	By headerText = By.xpath("//div[@class='sc-qrIAp dfnBSA']");
	public String openFirstConversation()
	{
		backNavigationButton.click();
		openFirstConversation.click();
		visibilityOfElement(headerText);
		return headerMessage.getText();
	}
	
	public void browserQuit()
	{
		driver.quit();
	}
}
