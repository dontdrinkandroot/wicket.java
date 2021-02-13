package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import net.dontdrinkandroot.wicket.bootstrap.behavior.form.FormStyleBehavior;
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSizeStack;
import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import net.dontdrinkandroot.wicket.bootstrap.test.TestFormPanel;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.TagTester;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FormGroupInputTextTest extends AbstractWicketTest
{
    @Test
    public void testDefault()
    {
        TestFormPanel formPanel = new TestFormPanel("id");

        FormGroupInputText formGroupInputText =
                new FormGroupInputText("formGroup", new Model<>("Label"), Model.of("Value"));
        formPanel.getForm().add(formGroupInputText);

        CharSequence componentMarkup = ComponentRenderer.renderComponent(formPanel);

        TagTester formGroupTester =
                TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "formGroup");
        Assertions.assertTrue(formGroupTester.getAttributeContains("class", "form-group"));

        TagTester labelTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "label");
        Assertions.assertTrue(labelTester.getAttributeContains("class", "form-label"));

        TagTester formComponentTester =
                TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "formComponent");
        Assertions.assertTrue(formComponentTester.getAttributeContains("class", "form-control"));
        Assertions.assertTrue(formComponentTester.getAttributeContains("type", "text"));
        Assertions.assertTrue(formComponentTester.getAttributeContains("value", "Value"));
        Assertions.assertTrue(formComponentTester.getAttributeContains("placeholder", "Label"));

        TagTester helpBlockTester =
                TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "helpBlock");
        Assertions.assertNull(helpBlockTester);
    }

    @Test
    public void testValidationError()
    {
        TestFormPanel formPanel = new TestFormPanel("id");

        FormGroupInputText formGroupInputText =
                new FormGroupInputText("formGroup", new Model<>("Label"), new Model<String>());
        formGroupInputText.setRequired(true);
        formGroupInputText.getFormComponent().validate();
        formPanel.getForm().add(formGroupInputText);

        CharSequence componentMarkup = ComponentRenderer.renderComponent(formPanel);

        TagTester formGroupTester =
                TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "formGroup");

        TagTester formComponentTester =
                TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "formComponent");
        Assertions.assertTrue(formComponentTester.getAttributeContains("required", "required"));
        Assertions.assertTrue(formComponentTester.getAttributeContains("class", "is-invalid"));

        TagTester helpBlockTester =
                TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "helpBlock");
        Assertions.assertNotNull(helpBlockTester);

        List<TagTester> messagesTesters =
                TagTester.createTagsByAttribute(componentMarkup.toString(), "wicket:id", "messages", false);
        Assertions.assertEquals(1, messagesTesters.size());

        TagTester messageTester = messagesTesters.get(0);
        Assertions.assertTrue(messageTester.getAttributeContains("class", "invalid-feedback"));
        Assertions.assertEquals("&#039;Label&#039; is required.", messageTester.getChild("container").getValue());
    }

    @Test
    public void testHorizontalStyle()
    {
        TestFormPanel formPanel = new TestFormPanel("id");
        formPanel.getForm().add(new FormStyleBehavior().setHorizontal(ColumnSizeStack.FORM_DEFAULT));

        FormGroupInputText formGroupInputText =
                new FormGroupInputText("formGroup", new Model<>("Label"), Model.of("Value"));
        formPanel.getForm().add(formGroupInputText);

        CharSequence componentMarkup = ComponentRenderer.renderComponent(formPanel);

        TagTester labelTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "label");
        Assertions.assertTrue(labelTester.getAttributeContains("class", "col-sm-5"));
        Assertions.assertTrue(labelTester.getAttributeContains("class", "col-md-4"));
        Assertions.assertTrue(labelTester.getAttributeContains("class", "col-lg-3"));

        TagTester containerTester =
                TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "container");
        Assertions.assertTrue(containerTester.getAttributeContains("class", "col-sm-7"));
        Assertions.assertTrue(containerTester.getAttributeContains("class", "col-md-8"));
        Assertions.assertTrue(containerTester.getAttributeContains("class", "col-lg-9"));
    }
}
