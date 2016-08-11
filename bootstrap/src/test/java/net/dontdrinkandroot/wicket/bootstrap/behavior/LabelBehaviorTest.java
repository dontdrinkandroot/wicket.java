package net.dontdrinkandroot.wicket.bootstrap.behavior;

import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

import net.dontdrinkandroot.wicket.bootstrap.AbstractWicketTest;


public class LabelBehaviorTest extends AbstractWicketTest
{

	@Test
	public void testDefault()
	{
		WebMarkupContainer comopnent = new WebMarkupContainer("id");
		comopnent.add(new LabelBehavior());
		CharSequence componentMarkup = ComponentRenderer.renderComponent(comopnent);

		TagTester tagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id");
		Assert.assertTrue(tagTester.getAttributeContains("class", "label"));
		Assert.assertTrue(tagTester.getAttributeContains("class", "label-default"));
	}
}
