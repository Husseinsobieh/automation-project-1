package javascript;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DropdownPage;
import pages.InfiniteScrollPage;
import pages.LargeAndDeepDOMPage;

import java.util.List;

public class JavascriptTests extends BaseTests {
    @Test
    public void testScrollToTable(){
        LargeAndDeepDOMPage tablePage = homepage.clickLargeAndDeep();
        tablePage.scrollToTable();
    }
    @Test
    public void testScrollToParagraphPresent(){
        InfiniteScrollPage scrollParagraphPage = homepage.clickInfiniteScroll();
        int index = 7;
        scrollParagraphPage.scrollToParagraph(index);
        Assert.assertEquals(scrollParagraphPage.getNumberOfParagraphs(), index, "paragraph not in view");
    }
    @Test
    public void testMultipleSelectedOptions(){
        DropdownPage dropdownPage = homepage.clickDropdown();
        dropdownPage.selectMultipleOptions();

        List<String> optionsToSelect = List.of("Option 1", "Option 2");
        optionsToSelect.forEach(dropdownPage::selectOptionFromDropdown);

        List<String> getOptions = dropdownPage.getSelectedOptions();
        Assert.assertTrue(getOptions.containsAll(optionsToSelect), "incorrect selected options");
        Assert.assertEquals(getOptions.size(), 2, "incorrect number of selected options");
    }
}
