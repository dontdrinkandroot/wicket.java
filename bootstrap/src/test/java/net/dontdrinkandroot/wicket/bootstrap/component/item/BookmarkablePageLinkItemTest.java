package net.dontdrinkandroot.wicket.bootstrap.component.item;

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import net.dontdrinkandroot.wicket.bootstrap.test.TestHomePage;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.model.Model;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class BookmarkablePageLinkItemTest extends AbstractWicketTest
{
    @Test
    public void testMarkup()
    {
        BookmarkablePageLinkItem component = new BookmarkablePageLinkItem("id", Model.of("Label"), TestHomePage.class);
        CharSequence componentMarkup = ComponentRenderer.renderComponent(component);
        Assert.assertEquals("<wicket:container wicket:id=\"id\"><wicket:panel>\n" +
                "    <a href=\"./\" wicket:id=\"link\">Label</a>\n" +
                "    <wicket:child/>\n" +
                "</wicket:panel></wicket:container>", componentMarkup.toString());
    }
}
