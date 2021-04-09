package homepageTest;

import common.BaseAPI;
import homepage.Homepage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomepageTest extends BaseAPI {

    Homepage homepage;

    @Test ()
    public void testSelectBMW() {
        homepage = new Homepage();
        homepage.selectBMWRadioOption();

        Assert.assertTrue(isElementSelected(homepage.radioOptionBMW));
    }

    @Test ()
    public void testSelectBenz() {
        homepage = new Homepage();
        homepage.selectBenzRadioOption();

        Assert.assertTrue(isElementSelected(homepage.radioOptionBenz));
    }

    @Test ()
    public void testSelectHonda() {
        homepage = new Homepage();
        homepage.selectHondaRadioOption();

        Assert.assertTrue(isElementSelected(homepage.radioOptionHonda));
    }

    @Test ()
    public void testSelectMultiSelectApple() {
        homepage = new Homepage();
        homepage.selectMultiSelectOptionApple();

        Assert.assertTrue(isElementSelected(homepage.multiSelectOptionApple));
    }

    @Test ()
    public void testSelectMultiSelectOrange() {
        homepage = new Homepage();
        homepage.selectMultiSelectOptionOrange();

        Assert.assertTrue(isElementSelected(homepage.multiSelectOptionOrange));
    }

    @Test ()
    public void testSelectMultiSelectPeach() {
        homepage = new Homepage();
        homepage.selectMultiSelectOptionPeach();

        Assert.assertTrue(isElementSelected(homepage.multiSelectOptionPeach));
    }

    @Test ()
    public void testSelectMultipleOptions() throws Exception {
        homepage = new Homepage();
        homepage.selectTwoOptionsInMultiSelect();


        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(isElementSelected(homepage.multiSelectOptionApple));
        softAssert.assertTrue(isElementSelected(homepage.multiSelectOptionPeach));

        softAssert.assertAll();
    }

    @Test ()
    public void testOpenAndSwitchToNewWindow() {
        homepage = new Homepage();
        homepage.openNewWindowAndSwitchToIt();

        Assert.assertTrue(isElementDisplayed(homepage.imageNewWindowCourse1));
    }

    @Test ()
    public void testOpenAndSwitchToNewTab() {
        homepage = new Homepage();
        homepage.openNewTabAndSwitchToIt();

        Assert.assertTrue(isElementDisplayed(homepage.imageNewTabHeader));
    }

    @Test
    public void testClickOnSeleniumPythonCourse() {
        homepage = new Homepage();
        homepage.switchToCoursesIFrame();
        clickElement(homepage.linkSelPythonCourse);

        waitForVisibilityOfElement(homepage.headerSelPythonCourse);

        Assert.assertEquals(getTextFromElement(homepage.headerSelPythonCourse), "Selenium WebDriver With Python 3.x");
    }

}
