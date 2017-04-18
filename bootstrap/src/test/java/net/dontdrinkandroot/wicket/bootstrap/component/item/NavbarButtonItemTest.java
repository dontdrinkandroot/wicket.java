package net.dontdrinkandroot.wicket.bootstrap.component.item;

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import net.dontdrinkandroot.wicket.bootstrap.test.TestHomePage;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class NavbarButtonItemTest extends AbstractWicketTest
{
    @Test
    public void testMarkup()
    {
        NavbarButtonItem component = new NavbarButtonItem("id")
        {
            @Override
            protected AbstractLink createLink(String id)
            {
                return new BookmarkablePageLink<>(id, TestHomePage.class);
            }
        };
        CharSequence componentMarkup = ComponentRenderer.renderComponent(component);
        Assert.assertEquals(
                "<wicket:container wicket:id=\"id\"><wicket:panel>\n" +
                        "\t\t<button wicket:id=\"button\" onclick=\"var win = this.ownerDocument.defaultView || this.ownerDocument.parentWindow; if (win == window) { window.location.href=&#039;./&#039;; } ;return false\" class=\"btn btn-default navbar-btn\" type=\"button\"></button>\n" +
                        "\t\t<wicket:child/>\n" +
                        "</wicket:panel></wicket:container>",
                componentMarkup.toString()
        );
    }
}
