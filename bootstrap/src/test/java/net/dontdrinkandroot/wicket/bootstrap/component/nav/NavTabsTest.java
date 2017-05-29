package net.dontdrinkandroot.wicket.bootstrap.component.nav;

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class NavTabsTest extends AbstractWicketTest
{
    @Test
    public void testDefaultMarkup()
    {
        RepeatingNavTabs component = new RepeatingNavTabs("id");
        String markup = ComponentRenderer.renderComponent(component).toString();
        TagTester tagTester = TagTester.createTagByAttribute(markup, "wicket:id", "id");
        Assert.assertEquals("nav nav-tabs", tagTester.getAttribute("class"));
    }

    @Test
    public void testJustifiedMarkup()
    {
        RepeatingNavTabs component = new RepeatingNavTabs("id");
        component.setJustified(true);
        String markup = ComponentRenderer.renderComponent(component).toString();
        TagTester tagTester = TagTester.createTagByAttribute(markup, "wicket:id", "id");
        Assert.assertEquals("nav nav-tabs nav-justified", tagTester.getAttribute("class"));
    }
}
