package navigation;

import base.BaseTests;
import org.testng.annotations.Test;

public class navigationTests extends BaseTests {
    @Test
    public void testNavigator(){
        homepage.clickDynamicLoading().clickExample1();
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goTo("http://google.com");
    }
    @Test
    public void testSwitchTab(){
        homepage.clickMultipleWindows().clickNewWindow();
        getWindowManager().switchToTab("New Window");
    }
}
