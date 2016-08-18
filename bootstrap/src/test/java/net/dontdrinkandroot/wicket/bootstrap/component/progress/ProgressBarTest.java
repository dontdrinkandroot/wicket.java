package net.dontdrinkandroot.wicket.bootstrap.component.progress;

import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

import net.dontdrinkandroot.wicket.bootstrap.AbstractWicketTest;


/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class ProgressBarTest extends AbstractWicketTest
{

	@Test
	public void testDefaultMarkup()
	{
		ProgressBar component = new ProgressBar("id", Model.of(33));
		String componentMarkup = ComponentRenderer.renderComponent(component).toString();

		System.out.println(componentMarkup);

		TagTester componentTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "id");
		Assert.assertTrue(componentTester.getAttributeContains("class", "progress"));

		TagTester barTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "bar");
		Assert.assertEquals("progress-bar", barTester.getAttribute("class"));
		Assert.assertEquals("progressbar", barTester.getAttribute("role"));
		Assert.assertEquals("0", barTester.getAttribute("aria-valuemin"));
		Assert.assertEquals("100", barTester.getAttribute("aria-valuemax"));
		Assert.assertEquals("33", barTester.getAttribute("aria-valuenow"));
		Assert.assertEquals("width: 33%;", barTester.getAttribute("style"));
		Assert.assertTrue(barTester.hasAttribute("id"));
	}
}
