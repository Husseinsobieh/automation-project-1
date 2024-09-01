package context;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContextMenuPage;

public class ContextMenuTests extends BaseTests {
    @Test
    public void TestContextMenu(){
        ContextMenuPage contextMenuPage = homepage.clickContextMenu();
        contextMenuPage.clickContextBox();
        Assert.assertEquals(contextMenuPage.alert_getMessage(), "You selected a context menu", "alert message incorrect");
        contextMenuPage.alert_clickToAccept();
    }
}
