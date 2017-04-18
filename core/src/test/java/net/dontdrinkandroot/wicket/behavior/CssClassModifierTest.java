package net.dontdrinkandroot.wicket.behavior;

import net.dontdrinkandroot.wicket.css.CssClass;
import net.dontdrinkandroot.wicket.css.SimpleCssClass;
import net.dontdrinkandroot.wicket.test.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class CssClassModifierTest extends AbstractWicketTest
{
    @Test
    public void testStringConstructor()
    {
        WebMarkupContainer container = new WebMarkupContainer("id");
        container.add(new CssClassModifier("testone"));
        CharSequence componentMarkup = ComponentRenderer.renderComponent(container);

        Assert.assertEquals(
                "<wicket:container wicket:id=\"id\" class=\"testone\"></wicket:container>",
                componentMarkup.toString()
        );
    }

    @Test
    public void testCssClassConstructor()
    {
        WebMarkupContainer container = new WebMarkupContainer("id");
        container.add(new CssClassModifier(new SimpleCssClass("testone")));
        CharSequence componentMarkup = ComponentRenderer.renderComponent(container);

        Assert.assertEquals(
                "<wicket:container wicket:id=\"id\" class=\"testone\"></wicket:container>",
                componentMarkup.toString()
        );
    }

    @Test
    public void testModelConstructor()
    {
        IModel<CssClass> classModel = Model.of(new SimpleCssClass("testone"));
        WebMarkupContainer container = new WebMarkupContainer("id");
        container.add(new CssClassModifier(classModel));
        CharSequence componentMarkup = ComponentRenderer.renderComponent(container);

        Assert.assertEquals(
                "<wicket:container wicket:id=\"id\" class=\"testone\"></wicket:container>",
                componentMarkup.toString()
        );

        classModel.setObject(new SimpleCssClass("testtwo"));

        componentMarkup = ComponentRenderer.renderComponent(container);

        Assert.assertEquals(
                "<wicket:container wicket:id=\"id\" class=\"testtwo\"></wicket:container>",
                componentMarkup.toString()
        );
    }
}
