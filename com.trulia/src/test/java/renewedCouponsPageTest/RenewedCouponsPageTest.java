package renewedCouponsPageTest;

import amazonHomepage.AmazonHomepage;
import common.BaseAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RenewedCouponsPageTest extends BaseAPI {

    AmazonHomepage amazonHomepage;

    @Test
    public void verifyPageLoad() {
        amazonHomepage = new AmazonHomepage();

        String actualHeaderText = amazonHomepage
                .navigateToTodaysDealsPage()
                .navigateToRenewedDealsPage()
                .navigateToRenewedCouponsPage()
                .returnHeaderText();

        Assert.assertTrue(compareStrings(actualHeaderText, "Amazon Renewed Coupons"));
    }

}
