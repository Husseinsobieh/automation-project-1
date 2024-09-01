package horizontalslider;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HorizontalSliderPage;

public class HorizontalSliderTests extends BaseTests {
    @Test
    public void TestSliderEqualsNumber(){
        String value = "4";
        HorizontalSliderPage horizontalSliderPage = homepage.clickHorizontalSlider();
        horizontalSliderPage.moveSlider(value);
        Assert.assertTrue(horizontalSliderPage.getSliderValue().equals(value), "Slider value is incorrect");
    }
}
