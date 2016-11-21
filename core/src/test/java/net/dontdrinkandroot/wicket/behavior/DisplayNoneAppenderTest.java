package net.dontdrinkandroot.wicket.behavior;

import net.dontdrinkandroot.wicket.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class DisplayNoneAppenderTest extends AbstractWicketTest
{
    @Test
    public void testModelConstructor()
    {
        WebMarkupContainer container = new WebMarkupContainer("id");
        container.add(new DisplayNoneAppender());
        CharSequence componentMarkup = ComponentRenderer.renderComponent(container);

        Assert.assertEquals(
                "<wicket:container wicket:id=\"id\" style=\"display: none\"></wicket:container>",
                componentMarkup.toString()
        );
    }
}
