package loading;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicLoadingExample1Page;
import pages.DynamicLoadingExample2Page;

public class loadingTests extends BaseTests {
    @Test
    public void testWaitUntilHidden(){
        DynamicLoadingExample1Page loadingPage = homepage.clickDynamicLoading().clickExample1();
        loadingPage.clickStart();
        Assert.assertEquals(loadingPage.getLoadedText(), "Hello World!", "loaded message incorrect");
    }
    @Test
    public void testWaitUntilVisible(){
        DynamicLoadingExample2Page loadingPage = homepage.clickDynamicLoading().clickExample2();
        loadingPage.clickStart();
        Assert.assertEquals(loadingPage.getLoadedText(), "Hello World!", "loaded message incorrect");
    }
}
