package renewedCouponsPage;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static renewedCouponsPage.RenewedCouponsPageLocators.*;

public class RenewedCouponsPage extends BaseAPI {

    @FindBy (css = WEB_ELEMENT_TEXT_PAGE_HEADER)
    public WebElement textPageHeader;

    public RenewedCouponsPage() {
        PageFactory.initElements(driver, this);
    }

    public String returnHeaderText() {
        return getTextFromElement(textPageHeader);
    }


}
