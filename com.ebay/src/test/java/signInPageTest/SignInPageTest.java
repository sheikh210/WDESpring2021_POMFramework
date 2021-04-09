package signInPageTest;

import common.BaseAPI;
import homepage.Homepage;
import org.testng.annotations.Test;
import signInPage.SignInPage;

public class SignInPageTest extends BaseAPI {

    Homepage homepage;
    SignInPage signInPage;

    @Test
    public void testDoInvalidLogin() {
        homepage = new Homepage();
        homepage.navigateToSignInPage().doLoginUsername();
    }

}
