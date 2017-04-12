package net.dontdrinkandroot.wicket.bootstrap.component.item;

import net.dontdrinkandroot.wicket.bootstrap.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.model.Model;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class NavBarTextItemTest extends AbstractWicketTest
{
    @Test
    public void testMarkup()
    {
        NavBarTextItem component = new NavBarTextItem("id", Model.of("Label"));
        CharSequence componentMarkup = ComponentRenderer.renderComponent(component);
        Assert.assertEquals(
                "<wicket:container wicket:id=\"id\" class=\"navbar-text\">Label</wicket:container>",
                componentMarkup.toString()
        );
    }
}
