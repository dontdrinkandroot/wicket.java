package net.dontdrinkandroot.wicket.bootstrap.component.item;

import net.dontdrinkandroot.wicket.bootstrap.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.model.Model;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class DropdownHeaderItemTest extends AbstractWicketTest
{
    @Test
    public void testMarkup()
    {
        DropdownHeaderItem component = new DropdownHeaderItem("id", Model.of("Label"));
        CharSequence componentMarkup = ComponentRenderer.renderComponent(component);
        Assert.assertEquals(
                "<wicket:container wicket:id=\"id\" class=\"dropdown-header\">Label</wicket:container>",
                componentMarkup.toString()
        );
    }
}
