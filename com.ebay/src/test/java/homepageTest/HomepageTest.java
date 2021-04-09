package homepageTest;

import common.BaseAPI;
import homepage.Homepage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class HomepageTest extends BaseAPI {

    Homepage homepage;

    @Test (groups = "smoke", priority = 1)
    public void testDoSearch() {
        homepage = new Homepage();
        String searchKeys = "headphones";
        homepage.doSearch(searchKeys);

        String actualText = getTextFromElement(homepage.expectedTextSearchResult);

        Assert.assertTrue(compareStrings(actualText, searchKeys));
    }

    @Test (groups = {"smoke", "regression"}, priority = 2)
    public void testSelectByIndex() throws Exception {
        homepage = new Homepage();
        homepage.selectCategoryFromSearchBarUsingIndex(2);

        String actualText = getTextFromElement(homepage.selectCategorySearchBar);
        String expectedText = "art";

        Assert.assertEquals(actualText, expectedText, "DOES NOT MATCH");
    }

    @Test (groups = "sanity", priority = 3)
    public void testSelectByValue() throws Exception{
        homepage = new Homepage();
        String value = "12576";
        homepage.selectCategoryFromSearchBarUsingValue(value);
    }

    @Test (groups = "smoke", priority = 4)
    public void testSelectByVisText() throws Exception{
        homepage = new Homepage();
        String visibleText = "DVDs & Movies";
        homepage.selectCategoryFromSearchBarUsingVisibleText(visibleText);
    }

    @Test (groups = "sanity", priority = 5)
    public void testCountOfCategoryDropdownOptions() {
        homepage = new Homepage();

        List<WebElement> elementList = homepage.expectedCategoriesSelectCategoryDropdownSearchBar;
//                getListOfWebElements(By.cssSelector(homepage.GET_WEB_ELEMENTS_EXPECTED_CATEGORIES_SELECT_CATEGORY_DROPDOWN_SEARCH_BAR()));

        int actualCount = elementList.size();
        int expectedCount = 36;

        Assert.assertEquals(actualCount, expectedCount, "COUNT OF CATEGORIES DOES NOT MATCH");
    }

    @Test (groups = "smoke", priority = 6)
    public void testNamesOfCategoriesDropdownOptions() throws Exception {
        homepage = new Homepage();

        String sheetPath = System.getProperty("user.dir") + "/src/test/resources/test_data/EbayTestData.xlsx";

        Assert.assertTrue(compareAttributeListToExpectedStringArray(By.cssSelector(homepage.GET_WEB_ELEMENTS_EXPECTED_CATEGORIES_SELECT_CATEGORY_DROPDOWN_SEARCH_BAR()),
                "innerHTML", sheetPath, "Categories"));
    }

    @Test (groups = "regression", priority = 7)
    public void testNamesOfCategoriesDropdownOptionsSoft() throws Exception {
        homepage = new Homepage();

        String sheetPath = System.getProperty("user.dir") + "/src/test/resources/test_data/EbayTestData.xlsx";

        String[] expectedResults = dataReader.fileReaderStringXSSF(sheetPath, "Categories");
        List<WebElement> elements = homepage.expectedCategoriesSelectCategoryDropdownSearchBar;

        SoftAssert softAssert = new SoftAssert();

        for (int i = 0; i < elements.size(); i++) {
            System.out.println("EXPECTED: " + expectedResults[i]);
            System.out.println("ACTUAL: " + getTextFromElement(elements.get(i)));
            System.out.println();

            softAssert.assertEquals(getTextFromElement(elements.get(i)), expectedResults[i], "ELEMENT " + i + " DOES NOT MATCH");
        }

        softAssert.assertAll();
    }

    @Test (priority = 8)
    public void testHover() throws Exception {
        homepage = new Homepage();
        homepage.hoverOverButtonCovidReadMore();

        String actualAttributeValue = homepage.buttonCovidReadMore.getAttribute("style");
        String expectedAttributeValue = "color: rgb(1, 113, 143); border-color: rgb(255, 255, 255); box-shadow: rgb(255, 255, 255) 0px 0px 0px 70px inset;";

        System.out.println(actualAttributeValue);
        System.out.println(expectedAttributeValue);

        Assert.assertEquals(actualAttributeValue, expectedAttributeValue, "COLOR DOES NOT MATCH");
    }




}
