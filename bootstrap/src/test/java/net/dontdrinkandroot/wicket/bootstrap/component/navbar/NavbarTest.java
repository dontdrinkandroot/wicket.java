package net.dontdrinkandroot.wicket.bootstrap.component.navbar;

import net.dontdrinkandroot.wicket.bootstrap.css.NavbarPosition;
import net.dontdrinkandroot.wicket.bootstrap.css.NavbarStyle;
import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class NavbarTest extends AbstractWicketTest
{
    @Test
    public void testDefaultMarkup()
    {
        Navbar component = new Navbar("id");
        CharSequence componentMarkup = ComponentRenderer.renderComponent(component);

        TagTester tagTester;

        tagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id");
        Assert.assertTrue(tagTester.getAttributeContains("class", "navbar"));
        Assert.assertTrue(tagTester.getAttributeContains("class", "navbar-default"));

        tagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "container");
        Assert.assertTrue(tagTester.getAttributeContains("class", "container-fluid"));
    }

    @Test
    public void testPositioningAndStyle()
    {
        Navbar component = new Navbar("id");
        component.setPosition(NavbarPosition.FIXED_TOP);
        component.setStyle(NavbarStyle.INVERSE);
        CharSequence componentMarkup = ComponentRenderer.renderComponent(component);

        TagTester tagTester;

        tagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id");
        Assert.assertTrue(tagTester.getAttributeContains("class", "navbar"));
        Assert.assertTrue(tagTester.getAttributeContains("class", "navbar-inverse"));
        Assert.assertTrue(tagTester.getAttributeContains("class", "navbar-fixed-top"));

        tagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "container");
        Assert.assertTrue(tagTester.getAttributeContains("class", "container"));
    }
}
