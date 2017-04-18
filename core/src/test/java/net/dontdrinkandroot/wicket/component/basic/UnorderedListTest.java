package net.dontdrinkandroot.wicket.component.basic;

import net.dontdrinkandroot.wicket.test.AbstractWicketTest;
import net.dontdrinkandroot.wicket.test.TestPage;
import org.apache.wicket.Component;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.util.ListModel;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class UnorderedListTest extends AbstractWicketTest
{
    @Test
    public void testDefault()
    {
        TestPage page = new TestPage()
        {
            @Override
            protected void populateComponents(RepeatingView componentView)
            {
                UnorderedList<String> component =
                        new UnorderedList<String>(
                                componentView.newChildId(),
                                new ListModel<String>(Arrays.asList("Alpha", "Beta", "Gamma"))
                        )
                        {
                            @Override
                            protected Component createListComponent(String id, IModel<String> model)
                            {
                                return new Label(id, model);
                            }
                        };
                componentView.add(component);
            }
        };

        CharSequence pageMarkup = ComponentRenderer.renderComponent(page);

        TagTester componentTester = TagTester.createTagByAttribute(pageMarkup.toString(), "wicket:id", "component");
        String componentMarkup = componentTester.getMarkup();
        Assert.assertEquals("<ul wicket:id=\"component\"><wicket:panel>\n" +
                "\t\t<li wicket:id=\"item\">Alpha</li><li wicket:id=\"item\">Beta</li><li wicket:id=\"item\">Gamma</li>\n" +
                "\t</wicket:panel></ul>", componentMarkup);
    }
}
