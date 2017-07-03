package net.dontdrinkandroot.wicket.bootstrap.component.button;

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.model.Model;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class AjaxButtonTest extends AbstractWicketTest
{
    @Test
    public void testIButton()
    {
        AjaxButton component = new AjaxButton("id")
        {
            @Override
            public void onClick(AjaxRequestTarget target)
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
        AjaxButton component = new AjaxButton("id")
        {
            @Override
            public void onClick(AjaxRequestTarget target)
            {
                /* Noop */
            }
        };
        component.setBody(Model.of("Label"));

        String componentMarkup = ComponentRenderer.renderComponent(component).toString();
        Assert.assertEquals(
                "<wicket:container wicket:id=\"id\" id=\"id1\" class=\"btn btn-default\">Label</wicket:container>",
                componentMarkup
        );
    }
}
