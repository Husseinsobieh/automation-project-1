package frame;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.NestedFramesPage;
import pages.WysiwygEditorPage;

public class FrameTests extends BaseTests {
    @Test
    public void testWysiwygEditor(){
        WysiwygEditorPage editorPage = homepage.clickWysiwygEditor();
        editorPage.clearTextArea();

        String text1 = "Hello ";
        String text2 = "world";

        editorPage.setTextArea(text1);
        editorPage.increaseIndentation();
        editorPage.setTextArea(text2);

        Assert.assertEquals(editorPage.getTextFromEditor(), text1+text2, "Text from editor incorrect");
    }
    @Test
    public void testLeftAndBottomFrames(){
        NestedFramesPage framesPage = homepage.clickFrames().clickNestedFrames();
        Assert.assertEquals(framesPage.getTextFromLeftFrame(), "LEFT", "Text from left frame incorrect");
        framesPage.switchToMainFrame();
        Assert.assertEquals(framesPage.getTextFromBottomFrame(), "BOTTOM", "Text from bottom frame incorrect");
    }
}
