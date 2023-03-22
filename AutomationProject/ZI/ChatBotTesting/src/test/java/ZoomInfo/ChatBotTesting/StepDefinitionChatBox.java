package ZoomInfo.ChatBotTesting;

import org.testng.Assert;

import Resources.BaseTest;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionChatBox extends BaseTest
{
	ChatPOM chatPOM;
	@Given("^Browser is launched and website is opened$")
    public void browser_is_launched() throws Throwable {
		chatPOM=initializaBrowser();
    }

	@Given("^Chat bot is available with text (.+)$")
    public void chat_bot_is_available_with_text(String chat) throws Throwable {
    	String welcometxt=chatPOM.welcomeTextInChatBot();
    	Assert.assertEquals(welcometxt, chat);
    }

    @When("^All the text in chat bot frame is displayed$")
    public void all_the_text_in_chat_bot_frame_is_displayed() throws Throwable {
      String[] values=  chatPOM.textMessageInInitialScreen();
      Assert.assertEquals(values[0], chatPOM.headerTextChat);
      Assert.assertEquals(values[1], chatPOM.headerDesc);
      Assert.assertEquals(values[2], chatPOM.displayText);
    }

    @Then("^select location and verify the reply (.+)$")
    public void verify_the_reply(String text) throws Throwable {
    	String name=chatPOM.finalTextAfterCountryDetail();
    	Assert.assertEquals(text, name);
    	
    }
    
    @And("^quit the browser$")
    public void quit_the_browser() throws Throwable {
    	chatPOM.browserQuit();
    }


    @And("^I entered user data like (.+), (.+)$")
    public void i_enter_user_data_like_and(String email, String firstname) throws Throwable {
    	String[] data=chatPOM.validEmail(email);
    	String name=chatPOM.getTextAfterFirstName(firstname);
    	Assert.assertEquals(data[0], chatPOM.textValue);
        Assert.assertEquals(data[1], chatPOM.nameReq);
        Assert.assertEquals(name, chatPOM.countryReq);
    }

    
    @And("^restart conversation$")
    public void restart_conversation() throws Throwable {
    	chatPOM.restartConversation();
    }

    @And("^minimize the chat bot$")
    public void minimize_the_chat_bot() throws Throwable {
    	chatPOM.minimizeChat();
    }

    @And("^maximize the chat bot$")
    public void maximize_the_chat_bot() throws Throwable {
    	chatPOM.maximizeChat();
    }

    @And("^open new tab and switch back to chat bot$")
    public void open_new_tab_and_switch_back_to_chat_bot() throws Throwable {
        chatPOM.launchNewTabAndSwitchToFrame();
    }

    @And("^verify content in home screen$")
    public void verify_content_in_home_screen() throws Throwable {
    	String[] verify=chatPOM.verifyContentInMainScreen();
    	Assert.assertEquals(verify[0],chatPOM.headlineHome);
    	Assert.assertEquals(verify[1],chatPOM.paraText);
    	Assert.assertEquals(verify[2],chatPOM.convText);
        
    }

    @And("^open files window$")
    public void open_files_window() throws Throwable {
    	String allFiles=chatPOM.allFilesNavigation();
    	Assert.assertEquals(allFiles,chatPOM.files1);
    }

    @And("^open the first conversation from the history$")
    public void open_the_first_conversation_from_the_history() throws Throwable {
    	String headingZoom=chatPOM.openFirstConversation();
    	Assert.assertEquals(headingZoom,chatPOM.headerTextZoom);
    }

}
