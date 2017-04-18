package net.dontdrinkandroot.wicket.bootstrap.component.button;

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import org.apache.wicket.Component;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class SplitDropdownButtonTest extends AbstractWicketTest
{
    @Test
    public void testMarkup()
    {
        SplitDropdownButton<String> component = new SplitDropdownButton<String>("id")
        {
            @Override
            protected Component createAction(String id)
            {
                return new Label(id, "ActionLabel");
            }

            @Override
            protected void populateItems(RepeatingView itemView)
            {

            }
        };
        CharSequence componentMarkup = ComponentRenderer.renderComponent(component);
        Assert.assertEquals(
                "<wicket:container wicket:id=\"id\" class=\"btn-group\"><wicket:panel>\n" +
                        "\t\t<button wicket:id=\"button\" type=\"button\" class=\"btn btn-default\">ActionLabel</button>\n" +
                        "\t\t<button wicket:id=\"toggle\" type=\"button\" class=\"btn btn-default dropdown-toggle\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n" +
                        "\t\t\t<span class=\"sr-only\">Toggle Dropdown</span>\n" +
                        "\t\t<span class=\"caret\"></span></button>\n" +
                        "\t\t<ul wicket:id=\"dropdownMenu\" class=\"dropdown-menu\" role=\"menu\"><wicket:panel>\n" +
                        "    \n" +
                        "</wicket:panel></ul>\n" +
                        "\t</wicket:panel></wicket:container>",
                componentMarkup.toString()
        );
    }
}
