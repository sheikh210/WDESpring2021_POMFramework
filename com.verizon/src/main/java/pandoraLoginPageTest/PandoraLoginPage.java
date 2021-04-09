package pandoraLoginPageTest;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import static pandoraLoginPageTest.PandoraLoginPageLocators.*;

public class PandoraLoginPage extends BaseAPI {

    public PandoraLoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = WEB_ELEMENT_INPUT_EMAIL)
    public WebElement inputEmail;

    @FindBy (xpath = WEB_ELEMENT_INPUT_PASSWORD)
    public WebElement inputPassword;

    @FindBy (xpath = WEB_ELEMENT_BUTTON_LOGIN)
    public WebElement buttonLogin;

    @FindBy (xpath = WEB_ELEMENT_TEXT_ERROR_MESSAGE)
    public WebElement textErrorMessage;

    public void doLogin(String email, String password){
        sendKeysToElement(inputEmail, email);
        sendKeysToElement(inputPassword, password);
        clickElement(buttonLogin);
    }

    @DataProvider
    public Object[][] getInvalidLoginTestData() throws Exception {
        String path = System.getProperty("user.dir") + "/src/test/resources/VerizonTestData.xlsx";
        Object[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, "InvalidLogin");

        return testData;
    }


}
