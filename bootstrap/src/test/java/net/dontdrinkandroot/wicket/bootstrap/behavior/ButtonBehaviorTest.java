package net.dontdrinkandroot.wicket.bootstrap.behavior;

import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

import net.dontdrinkandroot.wicket.bootstrap.AbstractWicketTest;


public class ButtonBehaviorTest extends AbstractWicketTest
{

	@Test
	public void testDefault()
	{
		WebMarkupContainer buttonContainer = new WebMarkupContainer("id");
		buttonContainer.add(new ButtonBehavior());
		CharSequence componentMarkup = ComponentRenderer.renderComponent(buttonContainer);

		TagTester tagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id");
		Assert.assertTrue(tagTester.getAttributeContains("class", "btn"));
		Assert.assertTrue(tagTester.getAttributeContains("class", "btn-default"));
		Assert.assertFalse(tagTester.getAttributeContains("class", "disabled"));
	}

	@Test
	public void testDisabled()
	{
		WebMarkupContainer buttonContainer = new WebMarkupContainer("id");
		buttonContainer.setEnabled(false);
		buttonContainer.add(new ButtonBehavior());
		CharSequence componentMarkup = ComponentRenderer.renderComponent(buttonContainer);

		TagTester tagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id");
		Assert.assertTrue(tagTester.getAttributeContains("class", "btn"));
		Assert.assertTrue(tagTester.getAttributeContains("class", "btn-default"));
		Assert.assertTrue(tagTester.getAttributeContains("class", "disabled"));
	}

}
