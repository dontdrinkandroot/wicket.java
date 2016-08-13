package net.dontdrinkandroot.wicket.bootstrap.behavior;

import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

import net.dontdrinkandroot.wicket.bootstrap.AbstractWicketTest;
import net.dontdrinkandroot.wicket.css.SimpleCssClass;


public class IconBehaviorTest extends AbstractWicketTest
{

	@Test
	public void testEmptyIconBehavior()
	{
		WebMarkupContainer component = new WebMarkupContainer("id");
		component.add(new IconBehavior());
		CharSequence componentMarkup = ComponentRenderer.renderComponent(component);

		TagTester componentTagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id");
		Assert.assertNotNull(componentTagTester);
		Assert.assertEquals("", componentTagTester.getValue());
	}

	@Test
	public void testIconOnly()
	{
		WebMarkupContainer component = new WebMarkupContainer("id");
		component.add(new IconBehavior().setPrependIcon(new SimpleCssClass("prependIconClass")));
		CharSequence componentMarkup = ComponentRenderer.renderComponent(component);

		TagTester componentTagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id");
		Assert.assertNotNull(componentTagTester);
		Assert.assertEquals("<span class=\"prependIconClass\"></span>", componentTagTester.getValue());
	}

	@Test
	public void testPrependIcon()
	{
		Label component = new Label("id", Model.of("body"));
		IconBehavior iconBehavior = new IconBehavior().setPrependIcon(new SimpleCssClass("prependIconClass"));
		component.add(iconBehavior);

		Assert.assertEquals("prependIconClass", iconBehavior.getPrependIcon().getClassString());
		Assert.assertNull(iconBehavior.getAppendIcon());

		CharSequence componentMarkup = ComponentRenderer.renderComponent(component);

		TagTester componentTagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id");
		Assert.assertNotNull(componentTagTester);
		Assert.assertEquals("<span class=\"prependIconClass\"></span>&nbsp;&nbsp;body", componentTagTester.getValue());

		iconBehavior.setPrependIcon(new SimpleCssClass("prependIconClass2"));

		Assert.assertEquals("prependIconClass2", iconBehavior.getPrependIcon().getClassString());
		Assert.assertNull(iconBehavior.getAppendIcon());
	}

	@Test
	public void testAppendIcon()
	{
		Label component = new Label("id", Model.of("body"));
		IconBehavior iconBehavior = new IconBehavior().setAppendIcon(new SimpleCssClass("appendIconClass"));
		component.add(iconBehavior);

		Assert.assertEquals("appendIconClass", iconBehavior.getAppendIcon().getClassString());
		Assert.assertNull(iconBehavior.getPrependIcon());

		CharSequence componentMarkup = ComponentRenderer.renderComponent(component);

		TagTester componentTagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id");
		Assert.assertNotNull(componentTagTester);
		Assert.assertEquals("body&nbsp;&nbsp;<span class=\"appendIconClass\"></span>", componentTagTester.getValue());

		iconBehavior.setAppendIcon(new SimpleCssClass("appendIconClass2"));

		Assert.assertEquals("appendIconClass2", iconBehavior.getAppendIcon().getClassString());
		Assert.assertNull(iconBehavior.getPrependIcon());
	}

}
