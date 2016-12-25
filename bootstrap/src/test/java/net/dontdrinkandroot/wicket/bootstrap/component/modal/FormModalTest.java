package net.dontdrinkandroot.wicket.bootstrap.component.modal;

import net.dontdrinkandroot.wicket.bootstrap.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class FormModalTest extends AbstractWicketTest
{
    @Test
    public void testDefaultMarkup()
    {
        FormModal<String> component = new FormModal<String>("modalId")
        {
            @Override
            protected IModel<String> createHeadingModel()
            {
                return Model.of("Modal Heading");
            }
        };
        String componentMarkup = ComponentRenderer.renderComponent(component).toString();

        TagTester tester;

        tester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "modalId");
        Assert.assertTrue(tester.getAttributeContains("class", "modal"));
        Assert.assertTrue(tester.getAttributeContains("class", "fade"));

        tester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "heading");
        Assert.assertEquals("Modal Heading", tester.getValue());
    }
}
