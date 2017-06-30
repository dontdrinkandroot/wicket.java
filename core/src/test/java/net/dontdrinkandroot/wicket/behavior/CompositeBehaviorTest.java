package net.dontdrinkandroot.wicket.behavior;

import net.dontdrinkandroot.wicket.css.StringCssClass;
import net.dontdrinkandroot.wicket.test.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class CompositeBehaviorTest extends AbstractWicketTest
{
    @Test
    public void testMarkup()
    {
        WebMarkupContainer component = new WebMarkupContainer("id");

        CompositeBehavior behavior = new CompositeBehavior();
        behavior.addBehavior(new CssClassAppender(new StringCssClass("cssclass")));
        behavior.addBehavior(new TitleModifier("Title"));

        component.add(behavior);

        CharSequence componentMarkup = ComponentRenderer.renderComponent(component);
        Assert.assertEquals(
                "<wicket:container wicket:id=\"id\" class=\"cssclass\" title=\"Title\"></wicket:container>",
                componentMarkup.toString()
        );
    }
}
