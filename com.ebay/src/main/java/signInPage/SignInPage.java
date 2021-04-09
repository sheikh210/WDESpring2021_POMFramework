package signInPage;

import common.BaseAPI;
import homepage.Homepage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static signInPage.SignInPageLocators.*;

public class SignInPage extends BaseAPI {

    @FindBy (xpath = WEB_ELEMENT_INPUT_EMAIL)
    public WebElement inputEmail;

    @FindBy (id = WEB_ELEMENT_BUTTON_CONTINUE)
    public WebElement buttonContinue;

    @FindBy (id = WEB_ELEMENT_TEXT_ERROR_MESSAGE)
    public WebElement textErrorMessage;


    public SignInPage() {
        PageFactory.initElements(driver, this);

        waitForPageLoad(properties.getProperty("URL"));
    }

    public void enterEmailOrUsername() {
        sendKeysToElement(inputEmail, "sami@piit.email.us");
    }

    public void clickContinueButton() {
        clickElement(buttonContinue);
    }

    public void doLoginUsername() {
        enterEmailOrUsername();
        clickContinueButton();
    }



}
