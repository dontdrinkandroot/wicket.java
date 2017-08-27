package net.dontdrinkandroot.wicket.example.page;

import net.dontdrinkandroot.wicket.example.AbstractWicketTest;
import net.dontdrinkandroot.wicket.example.page.component.ModalPage;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class ModalPageTest extends AbstractWicketTest
{
    @Test
    public void testOpenStandardModal()
    {
        this.tester.startPage(ModalPage.class);
        this.tester.assertRenderedPage(ModalPage.class);

        String response = this.tester.getLastResponseAsString();
        this.tester.clickLink("openStandardModalButton", true);

        TagTester modalTester =
                TagTester.createTagByAttribute(this.tester.getLastResponseAsString(), "wicket:id", "modal");
        Assert.assertTrue(modalTester.getAttributeContains("class", "modal"));
    }

    @Test
    public void testOpenFormModal()
    {
        this.tester.startPage(ModalPage.class);
        this.tester.assertRenderedPage(ModalPage.class);

        String response = this.tester.getLastResponseAsString();
        this.tester.clickLink("openFormModalButton", true);

        TagTester modalTester =
                TagTester.createTagByAttribute(this.tester.getLastResponseAsString(), "wicket:id", "modal");
        Assert.assertTrue(modalTester.getAttributeContains("class", "modal"));
    }

    @Test
    public void testOpenAjaxFormModal()
    {
        this.tester.startPage(ModalPage.class);
        this.tester.assertRenderedPage(ModalPage.class);

        String response = this.tester.getLastResponseAsString();
        this.tester.clickLink("openAjaxFormModalButton", true);

        TagTester modalTester =
                TagTester.createTagByAttribute(this.tester.getLastResponseAsString(), "wicket:id", "modal");
        Assert.assertTrue(modalTester.getAttributeContains("class", "modal"));
    }
}
