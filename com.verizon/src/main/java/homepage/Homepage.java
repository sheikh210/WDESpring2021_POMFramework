package homepage;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Set;

import static homepage.HomepageLocators.*;

public class Homepage extends BaseAPI {

    public Homepage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = WEB_ELEMENT_RADIO_OPTION_BMW)
    public WebElement radioOptionBMW;

    @FindBy (id = WEB_ELEMENT_RADIO_OPTION_BENZ)
    public WebElement radioOptionBenz;

    @FindBy (id = WEB_ELEMENT_RADIO_OPTION_HONDA)
    public WebElement radioOptionHonda;

    @FindBy (css = WEB_ELEMENT_MULTI_SELECT_OPTION_APPLE)
    public WebElement multiSelectOptionApple;

    @FindBy (css = WEB_ELEMENT_MULTI_SELECT_OPTION_ORANGE)
    public WebElement multiSelectOptionOrange;

    @FindBy (css = WEB_ELEMENT_MULTI_SELECT_OPTION_PEACH)
    public WebElement multiSelectOptionPeach;

    @FindBy (id = WEB_ELEMENT_BUTTON_OPEN_NEW_WINDOW)
    public WebElement buttonOpenNewWindow;

    @FindBy (id = WEB_ELEMENT_BUTTON_OPEN_NEW_TAB)
    public WebElement buttonOpenNewTab;

    @FindBy (css = WEB_ELEMENT_IMAGE_NEW_WINDOW_COURSE_1)
    public WebElement imageNewWindowCourse1;

    @FindBy (xpath = WEB_ELEMENT_IMAGE_NEW_TAB_HEADER)
    public WebElement imageNewTabHeader;

    @FindBy (id = WEB_ELEMENT_I_FRAME_COURSES)
    public WebElement iFrameCourses;

    @FindBy (css = WEB_ELEMENT_LINK_SEL_PYTHON_COURSE)
    public WebElement linkSelPythonCourse;

    @FindBy (css = WEB_ELEMENT_HEADER_SEL_PYTHON_COURSE)
    public WebElement headerSelPythonCourse;

    public void selectBMWRadioOption(){
        selectElement(radioOptionBMW);
    }

    public void selectBenzRadioOption(){
        selectElement(radioOptionBenz);
    }

    public void selectHondaRadioOption(){
        selectElement(radioOptionHonda);
    }

    public void selectMultiSelectOptionApple() {
        selectElement(multiSelectOptionApple);
    }

    public void selectMultiSelectOptionOrange() {
        selectElement(multiSelectOptionOrange);
    }

    public void selectMultiSelectOptionPeach() {
        selectElement(multiSelectOptionPeach);
    }

    public void selectTwoOptionsInMultiSelect() throws Exception {
        selectMultiSelectOptionApple();

        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_CONTROL);
        selectMultiSelectOptionPeach();
        robot.keyRelease(KeyEvent.VK_CONTROL);

        Thread.sleep(4000);
    }

    public void openNewWindowAndSwitchToIt() {
        clickElement(buttonOpenNewWindow);
        switchToNewWindow();
    }

    public void openNewTabAndSwitchToIt() {
        clickElement(buttonOpenNewTab);
        switchToNewTab(1);
    }

    public void switchToCoursesIFrame() {
        switchToIFrameUsingElement(iFrameCourses);
    }


}
