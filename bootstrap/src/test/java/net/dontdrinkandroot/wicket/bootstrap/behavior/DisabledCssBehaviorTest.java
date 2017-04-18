package net.dontdrinkandroot.wicket.bootstrap.behavior;

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class DisabledCssBehaviorTest extends AbstractWicketTest
{
    @Test
    public void testEnabledMarkup()
    {
        WebMarkupContainer component = new WebMarkupContainer("id");
        component.add(new DisabledCssBehavior());
        CharSequence componentMarkup = ComponentRenderer.renderComponent(component);

        TagTester tagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id");
        Assert.assertFalse(tagTester.getAttributeContains("class", "disabled"));
    }

    @Test
    public void testDisabledMarkup()
    {
        WebMarkupContainer component = new WebMarkupContainer("id");
        component.add(new DisabledCssBehavior());
        component.setEnabled(false);
        CharSequence componentMarkup = ComponentRenderer.renderComponent(component);

        TagTester tagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id");
        Assert.assertTrue(tagTester.getAttributeContains("class", "disabled"));
    }
}
