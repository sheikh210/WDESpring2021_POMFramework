package homepage;

import common.BaseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        Select select = new Select(selectCategorySearchBar);

        select.selectByIndex(index);
    }

    public void selectCategoryFromSearchBarUsingValue(String value) {
        Select select = new Select(selectCategorySearchBar);

        select.selectByValue(value);
    }

    public void selectCategoryFromSearchBarUsingVisibleText(String visibleText) {
        Select select = new Select(selectCategorySearchBar);

        select.selectByVisibleText(visibleText);
    }

    public void hoverOverButtonCovidReadMore() throws Exception {
        Actions actions = new Actions(driver);

        driverWait.until(ExpectedConditions.visibilityOf(divAdvertisement1));

        actions.moveToElement(buttonCovidReadMore).build().perform();
    }





}
