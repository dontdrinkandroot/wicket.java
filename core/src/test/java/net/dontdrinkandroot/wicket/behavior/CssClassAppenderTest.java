package net.dontdrinkandroot.wicket.behavior;

import net.dontdrinkandroot.wicket.css.CssClass;
import net.dontdrinkandroot.wicket.css.StringCssClass;
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
public class CssClassAppenderTest extends AbstractWicketTest
{
    @Test
    public void testStringConstructor()
    {
        WebMarkupContainer container = new WebMarkupContainer("id");
        container.add(new CssClassAppender("testone"));
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
        container.add(new CssClassAppender(new StringCssClass("testone")));
        CharSequence componentMarkup = ComponentRenderer.renderComponent(container);

        Assert.assertEquals(
                "<wicket:container wicket:id=\"id\" class=\"testone\"></wicket:container>",
                componentMarkup.toString()
        );
    }

    @Test
    public void testModelConstructor()
    {
        IModel<CssClass> classModel = Model.of(new StringCssClass("testone"));
        WebMarkupContainer container = new WebMarkupContainer("id");
        container.add(new CssClassAppender(classModel));
        CharSequence componentMarkup = ComponentRenderer.renderComponent(container);

        Assert.assertEquals(
                "<wicket:container wicket:id=\"id\" class=\"testone\"></wicket:container>",
                componentMarkup.toString()
        );

        classModel.setObject(new StringCssClass("testtwo"));

        componentMarkup = ComponentRenderer.renderComponent(container);

        Assert.assertEquals(
                "<wicket:container wicket:id=\"id\" class=\"testtwo\"></wicket:container>",
                componentMarkup.toString()
        );
    }
}
