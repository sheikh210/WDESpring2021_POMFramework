package pandoraLoginPageTest;

import common.BaseAPI;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PandoraLoginPageTest extends BaseAPI {

    PandoraLoginPage pandoraLoginPage;

    @Test (dataProviderClass = PandoraLoginPage.class, dataProvider = "getInvalidLoginTestData")
    public void testDoInvalidLogin(String email, String password) {
        pandoraLoginPage = new PandoraLoginPage();
        pandoraLoginPage.doLogin(email, password);

        String actualText = getTextFromElement(pandoraLoginPage.textErrorMessage);
        String expectedText = "Incorrect Email or Password";

        Assert.assertEquals(actualText, expectedText, "INVALID LOGIN TEXT DOES NOT MATCH");
    }



}
