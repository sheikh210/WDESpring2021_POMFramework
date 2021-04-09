package renewedDealsPage;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import renewedCouponsPage.RenewedCouponsPage;

import static renewedDealsPage.RenewedDealsPageLocators.*;

public class RenewedDealsPage extends BaseAPI {

    @FindBy (xpath = WEB_ELEMENT_BUTTON_SEE_ALL_RENEWED_COUPONS)
    public WebElement buttonSeeAllRenewedCoupons;

    public RenewedDealsPage() {
        PageFactory.initElements(driver, this);
    }

    public RenewedCouponsPage navigateToRenewedCouponsPage() {
        clickJScript(buttonSeeAllRenewedCoupons);

        return new RenewedCouponsPage();
    }



}
