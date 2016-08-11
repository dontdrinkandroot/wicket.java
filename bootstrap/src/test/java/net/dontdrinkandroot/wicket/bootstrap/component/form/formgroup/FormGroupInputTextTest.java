package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import java.util.List;

import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

import net.dontdrinkandroot.wicket.bootstrap.AbstractWicketTest;
import net.dontdrinkandroot.wicket.bootstrap.TestFormPanel;
import net.dontdrinkandroot.wicket.bootstrap.behavior.form.FormStyleBehavior;
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSizeStack;


public class FormGroupInputTextTest extends AbstractWicketTest
{

	@Test
	public void testDefault()
	{
		TestFormPanel formPanel = new TestFormPanel("id");

		FormGroupInputText formGroupInputText =
				new FormGroupInputText("formGroup", Model.of("Label"), Model.of("Value"));
		formPanel.getForm().add(formGroupInputText);

		CharSequence componentMarkup = ComponentRenderer.renderComponent(formPanel);

		TagTester formGroupTester =
				TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "formGroup");
		Assert.assertTrue(formGroupTester.getAttributeContains("class", "form-group"));

		TagTester labelTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "label");
		Assert.assertTrue(labelTester.getAttributeContains("class", "control-label"));

		TagTester formComponentTester =
				TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "formComponent");
		Assert.assertTrue(formComponentTester.getAttributeContains("class", "form-control"));
		Assert.assertTrue(formComponentTester.getAttributeContains("type", "text"));
		Assert.assertTrue(formComponentTester.getAttributeContains("value", "Value"));
		Assert.assertTrue(formComponentTester.getAttributeContains("placeholder", "Label"));

		TagTester helpBlockTester =
				TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "helpBlock");
		Assert.assertNull(helpBlockTester);
	}

	@Test
	public void testValidationError()
	{
		TestFormPanel formPanel = new TestFormPanel("id");

		FormGroupInputText formGroupInputText =
				new FormGroupInputText("formGroup", Model.of("Label"), new Model<String>());
		formGroupInputText.setRequired(true);
		formGroupInputText.getFormComponent().validate();
		formPanel.getForm().add(formGroupInputText);

		CharSequence componentMarkup = ComponentRenderer.renderComponent(formPanel);

		TagTester formGroupTester =
				TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "formGroup");
		Assert.assertTrue(formGroupTester.getAttributeContains("class", "has-error"));

		TagTester formComponentTester =
				TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "formComponent");
		Assert.assertTrue(formComponentTester.getAttributeContains("required", "required"));

		TagTester helpBlockTester =
				TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "helpBlock");
		Assert.assertNotNull(helpBlockTester);

		List<TagTester> messagesTesters =
				TagTester.createTagsByAttribute(componentMarkup.toString(), "wicket:id", "messages", false);
		Assert.assertEquals(1, messagesTesters.size());

		TagTester messageTester = messagesTesters.get(0);
		Assert.assertTrue(messageTester.getAttributeContains("class", "error"));
		Assert.assertEquals("&#039;Label&#039; is required.", messageTester.getChild("container").getValue());
	}

	@Test
	public void testHorizontalStyle()
	{
		TestFormPanel formPanel = new TestFormPanel("id");
		formPanel.getForm().add(new FormStyleBehavior().setHorizontal(ColumnSizeStack.FORM_DEFAULT));

		FormGroupInputText formGroupInputText =
				new FormGroupInputText("formGroup", Model.of("Label"), Model.of("Value"));
		formPanel.getForm().add(formGroupInputText);

		CharSequence componentMarkup = ComponentRenderer.renderComponent(formPanel);

		TagTester labelTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "label");
		Assert.assertTrue(labelTester.getAttributeContains("class", "col-sm-5"));
		Assert.assertTrue(labelTester.getAttributeContains("class", "col-md-4"));
		Assert.assertTrue(labelTester.getAttributeContains("class", "col-lg-3"));

		TagTester containerTester =
				TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "container");
		Assert.assertTrue(containerTester.getAttributeContains("class", "col-sm-7"));
		Assert.assertTrue(containerTester.getAttributeContains("class", "col-md-8"));
		Assert.assertTrue(containerTester.getAttributeContains("class", "col-lg-9"));
	}

}
