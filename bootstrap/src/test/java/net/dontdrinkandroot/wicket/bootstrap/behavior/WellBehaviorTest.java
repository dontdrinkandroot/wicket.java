package net.dontdrinkandroot.wicket.bootstrap.behavior;

import net.dontdrinkandroot.wicket.bootstrap.css.WellSize;
import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class WellBehaviorTest extends AbstractWicketTest
{
    @Test
    public void testDefault()
    {
        WebMarkupContainer comopnent = new WebMarkupContainer("id");
        comopnent.add(new WellBehavior());
        CharSequence componentMarkup = ComponentRenderer.renderComponent(comopnent);

        TagTester tagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id");
        Assert.assertTrue(tagTester.getAttributeContains("class", "well"));
    }

    @Test
    public void testSize()
    {
        WebMarkupContainer comopnent = new WebMarkupContainer("id");
        comopnent.add(new WellBehavior(WellSize.SMALL));
        CharSequence componentMarkup = ComponentRenderer.renderComponent(comopnent);

        TagTester tagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id");
        Assert.assertTrue(tagTester.getAttributeContains("class", "well"));
        Assert.assertTrue(tagTester.getAttributeContains("class", "well-sm"));
    }

    @Test
    public void testSizeModel()
    {
        WebMarkupContainer comopnent = new WebMarkupContainer("id");
        comopnent.add(new WellBehavior(Model.of(WellSize.LARGE)));
        CharSequence componentMarkup = ComponentRenderer.renderComponent(comopnent);

        TagTester tagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id");
        Assert.assertTrue(tagTester.getAttributeContains("class", "well"));
        Assert.assertTrue(tagTester.getAttributeContains("class", "well-lg"));
    }
}
