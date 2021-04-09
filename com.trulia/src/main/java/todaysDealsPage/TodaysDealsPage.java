package todaysDealsPage;

import amazonHomepage.AmazonHomepage;
import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import renewedDealsPage.RenewedDealsPage;

import static todaysDealsPage.TodaysDealsPageLocators.*;

public class TodaysDealsPage extends BaseAPI {

    @FindBy (css = WEB_ELEMENT_BUTTON_RENEWED_DEALS)
    public WebElement buttonRenewedDeals;

    public TodaysDealsPage() {
        new AmazonHomepage().navigateToTodaysDealsPage();
        PageFactory.initElements(driver, this);
    }

    public RenewedDealsPage navigateToRenewedDealsPage() {
        clickElement(buttonRenewedDeals);

        return new RenewedDealsPage();
    }


}
