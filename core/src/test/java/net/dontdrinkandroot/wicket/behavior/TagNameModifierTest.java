package net.dontdrinkandroot.wicket.behavior;

import net.dontdrinkandroot.wicket.test.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class TagNameModifierTest extends AbstractWicketTest
{
    @Test
    public void testModelConstructor()
    {
        WebMarkupContainer container = new WebMarkupContainer("id");
        container.add(new TagNameModifier("div"));
        CharSequence componentMarkup = ComponentRenderer.renderComponent(container);

        Assert.assertEquals(
                "<wicket:div wicket:id=\"id\"></wicket:div>",
                componentMarkup.toString()
        );
    }
}
