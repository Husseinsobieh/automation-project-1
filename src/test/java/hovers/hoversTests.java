package hovers;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HoversPage;

public class hoversTests extends BaseTests {
    @Test
    public void testsHoverUser1(){
        HoversPage hoversPage = homepage.clickHovers();
        HoversPage.FigureCaption caption = hoversPage.hoverOverFigure(1);
        Assert.assertTrue(caption.isCaptionDisplayed(), "Caption not displayed");
        Assert.assertEquals(caption.getTitle(), "name: user1", "Name is incorrect");
        Assert.assertEquals(caption.getLinkText(), "View profile", "Caption link text incorrect");
        Assert.assertTrue(caption.getLink().endsWith("/users/1"), "Caption link incorrect");
    }
}
