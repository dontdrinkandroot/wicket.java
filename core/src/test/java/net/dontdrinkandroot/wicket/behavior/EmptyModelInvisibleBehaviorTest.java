package net.dontdrinkandroot.wicket.behavior;

import net.dontdrinkandroot.wicket.test.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.Model;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class EmptyModelInvisibleBehaviorTest extends AbstractWicketTest
{
    @Test
    public void testDefaultBehavior()
    {
        CharSequence componentMarkup;
        WebMarkupContainer container = new WebMarkupContainer("id");
        container.add(new EmptyModelInvisibleBehavior());

        componentMarkup = ComponentRenderer.renderComponent(container);
        Assert.assertNull(componentMarkup);

        container.setDefaultModel(new Model<>(null));
        componentMarkup = ComponentRenderer.renderComponent(container);
        Assert.assertNull(componentMarkup);

        container.setDefaultModel(new Model<>(""));
        componentMarkup = ComponentRenderer.renderComponent(container);
        Assert.assertNull(componentMarkup);

        container.setDefaultModel(new Model<>("Test"));
        componentMarkup = ComponentRenderer.renderComponent(container);
        Assert.assertEquals(
                "<wicket:container wicket:id=\"id\"></wicket:container>",
                componentMarkup.toString()
        );
    }
}
