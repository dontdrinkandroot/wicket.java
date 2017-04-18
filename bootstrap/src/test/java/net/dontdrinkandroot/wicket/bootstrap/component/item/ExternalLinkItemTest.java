package net.dontdrinkandroot.wicket.bootstrap.component.item;

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.model.Model;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class ExternalLinkItemTest extends AbstractWicketTest
{
    @Test
    public void testMarkup()
    {
        ExternalLinkItem component = new ExternalLinkItem("id", Model.of("Label"), Model.of("http://example.com"));
        CharSequence componentMarkup = ComponentRenderer.renderComponent(component);
        Assert.assertEquals("<wicket:container wicket:id=\"id\"><wicket:panel>\n" +
                "    <a href=\"http://example.com\" wicket:id=\"link\" rel=\"external\">Label</a>\n" +
                "    <wicket:child/>\n" +
                "</wicket:panel></wicket:container>", componentMarkup.toString());
    }
}
