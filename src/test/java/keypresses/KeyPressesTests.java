package keypresses;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KeyPressesPage;

public class KeyPressesTests extends BaseTests {
    @Test
    public void testsBackspace(){
        KeyPressesPage keyPressesPage = homepage.clickKeyPresses();
        keyPressesPage.enterText("r" + Keys.BACK_SPACE);
        Assert.assertEquals(keyPressesPage.enteredText(), "You entered: BACK_SPACE", "incorrect entered text");
    }
    @Test
    public void testsPi(){
//        KeyPressesPage keyPressesPage = homepage.clickKeyPresses();
//        keyPressesPage.enterPi();
    }
}
