package net.dontdrinkandroot.wicket.bootstrap.component.button;

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.model.Model;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class ButtonTest extends AbstractWicketTest
{
    @Test
    public void testIButton()
    {
        Button component = new Button("id")
        {
            @Override
            public void onClick()
            {
                /* Noop */
            }
        };
        component.setBody(Model.of("Label"));
        this.testIButton(component);
    }

    @Test
    public void testMarkup()
    {
        Button component = new Button("id")
        {

            @Override
            public void onClick()
            {
                /* Noop */
            }
        };
        component.setBody(Model.of("Label"));

        String componentMarkup = ComponentRenderer.renderComponent(component).toString();
        Assert.assertEquals(
                "<wicket:container wicket:id=\"id\" onclick=\"var win = this.ownerDocument.defaultView || this.ownerDocument.parentWindow; if (win == window) { window.location.href=&#039;./wicket/page?0-0.ILinkListener-id&#039;; } ;return false\" class=\"btn btn-default\">Label</wicket:container>",
                componentMarkup
        );
    }
}
