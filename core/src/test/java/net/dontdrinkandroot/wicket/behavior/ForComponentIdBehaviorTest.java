package net.dontdrinkandroot.wicket.behavior;

import net.dontdrinkandroot.wicket.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class ForComponentIdBehaviorTest extends AbstractWicketTest
{
    @Test
    public void testDefaultBehavior()
    {
        WebMarkupContainer component1 = new WebMarkupContainer("id");
        component1.setMarkupId("testid");
        WebMarkupContainer component2 = new WebMarkupContainer("id");
        component2.add(new ForComponentIdBehavior(component1));

        CharSequence componentMarkup = ComponentRenderer.renderComponent(component2);

        Assert.assertEquals(
                "<wicket:container wicket:id=\"id\" for=\"testid\"></wicket:container>",
                componentMarkup.toString()
        );
    }
}
