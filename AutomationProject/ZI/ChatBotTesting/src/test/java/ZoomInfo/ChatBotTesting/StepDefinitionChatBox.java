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

    @Given("^Chat bot is available$")
    public void chat_bot_is_opened() throws Throwable {
    	String welcometxt=chatPOM.welcomeTextInChatBot();
    	Assert.assertEquals(welcometxt, "jnj");
    }

    @When("^All the text in chat bot frame is displayed$")
    public void all_the_text_in_chat_bot_frame_is_displayed() throws Throwable {
        throw new PendingException();
    }

    @Then("^verify the reply (.+)$")
    public void verify_the_reply(String text) throws Throwable {
        throw new PendingException();
    }


    @And("^I enter user data like (.+), (.+) and (.+) $")
    public void i_enter_user_data_like_and(String email, String firstname, String location) throws Throwable {
        throw new PendingException();
    }

}
