package net.dontdrinkandroot.wicket.bootstrap.behavior;

import net.dontdrinkandroot.wicket.bootstrap.AbstractWicketTest;
import net.dontdrinkandroot.wicket.bootstrap.component.modal.ModalPage;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class ModalRequestBehaviorTest extends AbstractWicketTest
{
    @Test
    public void testOpenModalRequest()
    {
        ModalPage modalPage = this.tester.startPage(new ModalPage());
        String pageResponse = this.tester.getLastResponseAsString();

        this.tester.clickLink("openModalLink", true);

        TagTester tagTester;

        CharSequence componentMarkup = ComponentRenderer.renderComponent(modalPage);
        tagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "modal");
        Assert.assertTrue(tagTester.getAttributeContains("class", "modal"));
        Assert.assertTrue(tagTester.getAttributeContains("class", "fade"));

        tagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "heading");
        Assert.assertEquals("Modal Heading", tagTester.getValue());
    }

    @Test
    public void testCreateAndOpenModalRequest()
    {
        ModalPage modalPage = this.tester.startPage(new ModalPage());
        String pageResponse = this.tester.getLastResponseAsString();

        this.tester.clickLink("createAndOpenModalLink", true);

        TagTester tagTester;

        CharSequence componentMarkup = ComponentRenderer.renderComponent(modalPage);
        tagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "modal");
        Assert.assertTrue(tagTester.getAttributeContains("class", "modal"));
        Assert.assertTrue(tagTester.getAttributeContains("class", "fade"));

        tagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "heading");
        Assert.assertEquals("Modal Heading", tagTester.getValue());
    }
}
