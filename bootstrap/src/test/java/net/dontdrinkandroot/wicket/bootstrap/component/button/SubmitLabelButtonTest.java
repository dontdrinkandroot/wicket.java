package net.dontdrinkandroot.wicket.bootstrap.component.button;

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class SubmitLabelButtonTest extends AbstractWicketTest
{
    @Test
    public void testDefaultMarkup()
    {
        SubmitLabelButton component = new SubmitLabelButton("id");
        String componentMarkup = ComponentRenderer.renderComponent(component).toString();

        TagTester componentTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "id");
        Assert.assertTrue(componentTester.getAttributeIs("type", "submit"));
        Assert.assertTrue(componentTester.getAttributeIs("class", "btn btn-primary"));
        Assert.assertEquals("button", componentTester.getName());
    }
}
