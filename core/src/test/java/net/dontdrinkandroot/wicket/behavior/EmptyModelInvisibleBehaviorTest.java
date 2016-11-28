package net.dontdrinkandroot.wicket.behavior;

import net.dontdrinkandroot.wicket.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;
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
        IModel<String> model = Model.of("Test");

        WebMarkupContainer container = new WebMarkupContainer("id");
        container.setDefaultModel(model);
        container.add(new EmptyModelInvisibleBehavior());
        CharSequence componentMarkup = ComponentRenderer.renderComponent(container);

        Assert.assertEquals(
                "<wicket:container wicket:id=\"id\"></wicket:container>",
                componentMarkup.toString()
        );

        model.setObject(null);

        componentMarkup = ComponentRenderer.renderComponent(container);
        Assert.assertNull(componentMarkup);
    }
}
