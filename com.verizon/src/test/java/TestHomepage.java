import common.BaseAPI;
import homepage.Homepage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHomepage extends BaseAPI {

    Homepage homepage;

    @Test
    public void testDoSearch() {
        homepage = new Homepage();

        homepage.doSearch("facemask");
        String actualTitle = driver.getTitle();

        String expectedTitle = "Amazon.com : facemask";

        Assert.assertEquals(actualTitle, expectedTitle, "TITLE DOES NOT MATCH");
    }

}
