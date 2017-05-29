package net.dontdrinkandroot.wicket.bootstrap.component.nav;

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class NavPillsTest extends AbstractWicketTest
{
    @Test
    public void testDefaultMarkup()
    {
        RepeatingNavPills component = new RepeatingNavPills("id");
        String markup = ComponentRenderer.renderComponent(component).toString();
        TagTester tagTester = TagTester.createTagByAttribute(markup, "wicket:id", "id");
        Assert.assertEquals("nav nav-pills", tagTester.getAttribute("class"));
    }

    @Test
    public void testStackedMarkup()
    {
        RepeatingNavPills component = new RepeatingNavPills("id");
        component.setStacked(true);
        String markup = ComponentRenderer.renderComponent(component).toString();
        TagTester tagTester = TagTester.createTagByAttribute(markup, "wicket:id", "id");
        Assert.assertEquals("nav nav-pills nav-stacked", tagTester.getAttribute("class"));
    }

    @Test
    public void testJustifiedMarkup()
    {
        RepeatingNavPills component = new RepeatingNavPills("id");
        component.setJustified(true);
        String markup = ComponentRenderer.renderComponent(component).toString();
        TagTester tagTester = TagTester.createTagByAttribute(markup, "wicket:id", "id");
        Assert.assertEquals("nav nav-pills nav-justified", tagTester.getAttribute("class"));
    }
}
