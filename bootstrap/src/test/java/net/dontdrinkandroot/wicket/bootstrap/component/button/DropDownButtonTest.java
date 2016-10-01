package net.dontdrinkandroot.wicket.bootstrap.component.button;

import net.dontdrinkandroot.wicket.bootstrap.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class DropDownButtonTest extends AbstractWicketTest
{
    @Test
    public void testDefault()
    {
        DropDownButton<Void> component = new DropDownButton<Void>("id", null, Model.of("LabelText"))
        {
            @Override
            protected void populateItems(RepeatingView itemView)
            {

            }
        };
        CharSequence componentMarkup = ComponentRenderer.renderComponent(component);
        System.out.println(componentMarkup);
        TagTester componentTester =
                TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id");
        Assert.assertTrue(componentTester.getAttributeContains("class", "btn-group"));

        TagTester toggleTester =
                TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "toggle");
        Assert.assertEquals(
                "<button wicket:id=\"toggle\" type=\"button\" class=\"dropdown-toggle btn btn-default\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">LabelText&nbsp;&nbsp;<span class=\"caret\"></span></button>",
                toggleTester.getMarkup()
        );
        TagTester menuTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "menu");
        Assert.assertEquals("<ul wicket:id=\"menu\" class=\"dropdown-menu\" role=\"menu\"><wicket:panel>\n" +
                "\t\t\n" +
                "\t</wicket:panel></ul>", menuTester.getMarkup());
    }
}
