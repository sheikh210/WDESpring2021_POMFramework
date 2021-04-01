package homepage;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static homepage.HomepageLocators.*;

/*
 The reason why I was not able to extend Homepage by BaseAPI, is because BaseAPI was sitting inside Generic module, while
    Homepage is sitting inside com.verizon. When you say com.<insert_module_name_here>, com becomes a package which the
    <insert_module_name_here> sits inside of. In order to extend a class within com. groupId, the other class must also
    be within the com. groupId.

    The solution here was to put the Generic module inside of com. groupId
 */

public class Homepage extends BaseAPI {

    @FindBy (css = webElementInputSearch)
    WebElement inputSearchBox;

    @FindBy (css = webElementButtonSearch)
    WebElement buttonSearch;

    @FindBy (css = webElementDropdownHoverSignIn)
    WebElement dropdownHoverSignIn;

    public Homepage() {
        PageFactory.initElements(driver, this);
    }

    public void sendKeysToSearchBox(String keysToSend) {
        inputSearchBox.sendKeys(keysToSend);
    }

    public void clickSearchButton() {
        buttonSearch.click();
    }

    public void doSearch(String keysToSend) {
        sendKeysToSearchBox(keysToSend);
        clickSearchButton();
    }

}
