package net.dontdrinkandroot.wicket.bootstrap.component.item;

import net.dontdrinkandroot.wicket.bootstrap.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class SeparatorItemTest extends AbstractWicketTest
{
    @Test
    public void testMarkup()
    {
        SeparatorItem component = new SeparatorItem("id");
        CharSequence componentMarkup = ComponentRenderer.renderComponent(component);
        Assert.assertEquals(
                "<wicket:container wicket:id=\"id\" class=\"divider\" role=\"separator\"></wicket:container>",
                componentMarkup.toString()
        );
    }
}
