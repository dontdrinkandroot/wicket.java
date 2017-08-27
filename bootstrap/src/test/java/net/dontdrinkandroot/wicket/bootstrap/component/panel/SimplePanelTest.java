package net.dontdrinkandroot.wicket.bootstrap.component.panel;

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class SimplePanelTest extends AbstractWicketTest
{
    @Test
    public void testDefaultMarkup()
    {
        SimplePanel<String> component = new SimplePanel<String>("id", Model.of("Nothing"), Model.of("title"));
        String componentMarkup = ComponentRenderer.renderComponent(component).toString();

        TagTester componentTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "id");
        Assert.assertTrue(componentTester.getAttributeIs("class", "panel panel-default"));

        TagTester headingTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "heading");
        Assert.assertTrue(headingTester.getAttributeIs("class", "panel-heading"));

        TagTester titleTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "title");
        Assert.assertTrue(titleTester.getAttributeIs("class", "panel-title"));
    }
}
