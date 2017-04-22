package net.dontdrinkandroot.wicket.bootstrap.component.button;

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.model.Model;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class AjaxSubmitButtonTest extends AbstractWicketTest
{
    @Test
    public void testIButton()
    {
        AjaxSubmitButton component = new AjaxSubmitButton("id", Model.of("Label"));
        this.testIButton(component);
    }

    @Test
    public void testMarkup()
    {
        AjaxSubmitButton component = new AjaxSubmitButton("id", Model.of("Label"));

        String componentMarkup = ComponentRenderer.renderComponent(component).toString();
        Assert.assertEquals(
                "<wicket:container wicket:id=\"id\" id=\"id1\" class=\"btn btn-primary\">Label</wicket:container>",
                componentMarkup
        );
    }
}
