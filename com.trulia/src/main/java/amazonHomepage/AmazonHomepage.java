package amazonHomepage;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import todaysDealsPage.TodaysDealsPage;

import static amazonHomepage.AmazonHomepageLocators.*;

public class AmazonHomepage extends BaseAPI {

    @FindBy (css = WEB_ELEMENT_BUTTON_TODAYS_DEALS)
    public WebElement buttonTodaysDeals;

    public AmazonHomepage() {
        PageFactory.initElements(driver, this);
    }

    public TodaysDealsPage navigateToTodaysDealsPage() {
        clickElement(buttonTodaysDeals);

        return new TodaysDealsPage();
    }

}
