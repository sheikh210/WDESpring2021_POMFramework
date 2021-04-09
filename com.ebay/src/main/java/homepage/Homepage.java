package homepage;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import signInPage.SignInPage;

import java.util.List;

import static homepage.HomepageLocators.*;

public class Homepage extends BaseAPI {

    @FindBy (xpath = WEB_ELEMENT_INPUT_SEARCH_BAR)
    WebElement inputSearchBar;

    @FindBy (xpath = WEB_ELEMENT_BUTTON_SEARCH_SEARCH_BAR)
    WebElement buttonSearchBar;

    @FindBy (css = WEB_ELEMENT_EXPECTED_TEXT_SEARCH_RESULT)
    public WebElement expectedTextSearchResult;

    @FindBy (xpath = WEB_ELEMENT_SELECT_CATEGORY_SEARCH_BAR)
    public WebElement selectCategorySearchBar;

    @FindBy (css = WEB_ELEMENTS_EXPECTED_CATEGORIES_SELECT_CATEGORY_DROPDOWN_SEARCH_BAR)
    public List<WebElement> expectedCategoriesSelectCategoryDropdownSearchBar;

    @FindBy (css = WEB_ELEMENT_BUTTON_COVID_READ_MORE)
    public WebElement buttonCovidReadMore;

    @FindBy (id = WEB_ELEMENT_DIV_ADVERTISEMENT_1)
    WebElement divAdvertisement1;

    @FindBy (xpath = WEB_ELEMENT_BUTTON_SIGN_IN)
    public WebElement buttonSignIn;

    public String GET_WEB_ELEMENTS_EXPECTED_CATEGORIES_SELECT_CATEGORY_DROPDOWN_SEARCH_BAR() {
        return WEB_ELEMENTS_EXPECTED_CATEGORIES_SELECT_CATEGORY_DROPDOWN_SEARCH_BAR;
    }

    // Initialize all the web elements on this page, using PageFactory
    public Homepage() {
        PageFactory.initElements(driver, this);
    }

    public void sendKeysToSearchBar(String searchKeys) {
        sendKeysToElement(inputSearchBar, searchKeys);
    }

    public void clickSearchButton() {
        clickElement(buttonSearchBar);
    }

    public void doSearch(String searchKeys) {
        sendKeysToSearchBar(searchKeys);
        clickSearchButton();
    }

    public void selectCategoryFromSearchBarUsingIndex(int index) {
        selectOptionByIndex(selectCategorySearchBar, index);
    }

    public void selectCategoryFromSearchBarUsingValue(String value) {
        selectOptionByValue(selectCategorySearchBar, value);
    }

    public void selectCategoryFromSearchBarUsingVisibleText(String visibleText) {
        selectOptionByVisibleText(selectCategorySearchBar, visibleText);
    }

    public void hoverOverButtonCovidReadMore() throws Exception {
        waitForVisibilityOfElement(divAdvertisement1);
        hoverOverElement(buttonCovidReadMore);
    }

    public SignInPage navigateToSignInPage() {
        clickElement(buttonSignIn);

        return new SignInPage();
    }





}
