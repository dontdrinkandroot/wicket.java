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
public class TitleModifierTest extends AbstractWicketTest
{
    @Test
    public void testStringConstructor()
    {
        WebMarkupContainer container = new WebMarkupContainer("id");
        container.add(new TitleModifier("testone"));
        CharSequence componentMarkup = ComponentRenderer.renderComponent(container);

        Assert.assertEquals(
                "<wicket:container wicket:id=\"id\" title=\"testone\"></wicket:container>",
                componentMarkup.toString()
        );
    }

    @Test
    public void testModelConstructor()
    {
        IModel<String> classModel = Model.of("testone");
        WebMarkupContainer container = new WebMarkupContainer("id");
        container.add(new TitleModifier(classModel));
        CharSequence componentMarkup = ComponentRenderer.renderComponent(container);

        Assert.assertEquals(
                "<wicket:container wicket:id=\"id\" title=\"testone\"></wicket:container>",
                componentMarkup.toString()
        );

        classModel.setObject("testtwo");

        componentMarkup = ComponentRenderer.renderComponent(container);

        Assert.assertEquals(
                "<wicket:container wicket:id=\"id\" title=\"testtwo\"></wicket:container>",
                componentMarkup.toString()
        );
    }
}
