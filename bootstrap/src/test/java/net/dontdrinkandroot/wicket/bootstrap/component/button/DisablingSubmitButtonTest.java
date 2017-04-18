package net.dontdrinkandroot.wicket.bootstrap.component.button;

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class DisablingSubmitButtonTest extends AbstractWicketTest
{
    @Test
    public void testMarkup()
    {
        DisablingSubmitButton component = new DisablingSubmitButton("id");
        CharSequence componentMarkup = ComponentRenderer.renderComponent(component);
        Assert.assertEquals(
                "<wicket:container wicket:id=\"id\" id=\"id1\" data-loading-text=\"Submitting...\" class=\"btn btn-default\"></wicket:container>",
                componentMarkup.toString()
        );
    }
}
