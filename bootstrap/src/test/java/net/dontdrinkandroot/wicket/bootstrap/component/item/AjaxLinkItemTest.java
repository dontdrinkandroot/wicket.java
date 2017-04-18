package net.dontdrinkandroot.wicket.bootstrap.component.item;

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.model.Model;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class AjaxLinkItemTest extends AbstractWicketTest
{
    @Test
    public void testMarkup()
    {
        AjaxLinkItem component = new AjaxLinkItem("id", Model.of("Label"))
        {
            @Override
            protected void onClick(AjaxRequestTarget target)
            {
                /* Noop */
            }
        };
        CharSequence componentMarkup = ComponentRenderer.renderComponent(component);
        Assert.assertEquals("<wicket:container wicket:id=\"id\"><wicket:panel>\n" +
                "    <a href=\"javascript:;\" wicket:id=\"link\" id=\"link1\">Label</a>\n" +
                "    <wicket:child/>\n" +
                "</wicket:panel></wicket:container>", componentMarkup.toString());
    }
}
