package net.dontdrinkandroot.wicket.bootstrap.component.button;

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.model.Model;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class LabelButtonTest extends AbstractWicketTest
{
    @Test
    public void testIButton()
    {
        LabelButton component = new LabelButton("id", Model.of("Label"));
        this.testIButton(component);
    }

    @Test
    public void testMarkup()
    {
        LabelButton component = new LabelButton("id", Model.of("Label"));

        String componentMarkup = ComponentRenderer.renderComponent(component).toString();
        Assert.assertEquals(
                "<wicket:container wicket:id=\"id\" class=\"btn btn-default\">Label</wicket:container>",
                componentMarkup
        );
    }
}
