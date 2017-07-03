package net.dontdrinkandroot.wicket.component.basic;

import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.WicketTestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class HeadingTest extends WicketTestCase
{
    @Test
    public void testMarkup()
    {
        Heading heading;
        String markup;

        heading = new Heading("id", Heading.Level.H1);
        markup = ComponentRenderer.renderComponent(heading).toString();
        Assert.assertEquals("<wicket:h1 wicket:id=\"id\"></wicket:h1>", markup);

        heading = new Heading("id", "Heading2", Heading.Level.H2);
        markup = ComponentRenderer.renderComponent(heading).toString();
        Assert.assertEquals("<wicket:h2 wicket:id=\"id\">Heading2</wicket:h2>", markup);

        heading = new Heading("id", Model.of("Heading3"), Heading.Level.H3);
        markup = ComponentRenderer.renderComponent(heading).toString();
        Assert.assertEquals("<wicket:h3 wicket:id=\"id\">Heading3</wicket:h3>", markup);
    }
}
