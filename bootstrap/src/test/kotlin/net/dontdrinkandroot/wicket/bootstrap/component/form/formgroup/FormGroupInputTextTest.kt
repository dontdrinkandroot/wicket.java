package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup

import net.dontdrinkandroot.wicket.bootstrap.behavior.form.FormStyleBehavior
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSizeStack
import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import net.dontdrinkandroot.wicket.bootstrap.test.TestFormPanel
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.model.Model
import org.apache.wicket.util.tester.TagTester
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class FormGroupInputTextTest : AbstractWicketTest() {

    @Test
    fun testDefault() {
        val formPanel = TestFormPanel("id")
        val formGroupInputText = FormGroupInputText("formGroup", Model("Label"), Model.of("Value"))
        formPanel.form.add(formGroupInputText)
        val componentMarkup = ComponentRenderer.renderComponent(formPanel)
        val formGroupTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "formGroup")
        Assertions.assertTrue(formGroupTester.getAttributeContains("class", "form-group"))
        val labelTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "label")
        Assertions.assertTrue(labelTester.getAttributeContains("class", "form-label"))
        val formComponentTester =
            TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "formComponent")
        Assertions.assertTrue(formComponentTester.getAttributeContains("class", "form-control"))
        Assertions.assertTrue(formComponentTester.getAttributeContains("type", "text"))
        Assertions.assertTrue(formComponentTester.getAttributeContains("value", "Value"))
        Assertions.assertTrue(formComponentTester.getAttributeContains("placeholder", "Label"))
        val helpBlockTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "helpBlock")
        Assertions.assertNull(helpBlockTester)
    }

    @Test
    fun testValidationError() {
        val formPanel = TestFormPanel("id")
        val formGroupInputText = FormGroupInputText("formGroup", Model("Label"), Model())
        formGroupInputText.setRequired(true)
        formGroupInputText.formComponent.validate()
        formPanel.form.add(formGroupInputText)
        val componentMarkup = ComponentRenderer.renderComponent(formPanel)
        val formGroupTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "formGroup")
        val formComponentTester =
            TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "formComponent")
        Assertions.assertTrue(formComponentTester.getAttributeContains("required", "required"))
        Assertions.assertTrue(formComponentTester.getAttributeContains("class", "is-invalid"))
        val helpBlockTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "helpBlock")
        Assertions.assertNotNull(helpBlockTester)
        val messagesTesters =
            TagTester.createTagsByAttribute(componentMarkup.toString(), "wicket:id", "messages", false)
        Assertions.assertEquals(1, messagesTesters.size)
        val messageTester = messagesTesters[0]
        Assertions.assertTrue(messageTester.getAttributeContains("class", "invalid-feedback"))
        Assertions.assertEquals("&#039;Label&#039; is required.", messageTester.getChild("container").value)
    }

    @Test
    fun testHorizontalStyle() {
        val formPanel = TestFormPanel("id")
        formPanel.form.add(FormStyleBehavior().setHorizontal(ColumnSizeStack.FORM_DEFAULT))
        val formGroupInputText = FormGroupInputText("formGroup", Model("Label"), Model.of("Value"))
        formPanel.form.add(formGroupInputText)
        val componentMarkup = ComponentRenderer.renderComponent(formPanel)
        val labelTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "label")
        Assertions.assertTrue(labelTester.getAttributeContains("class", "col-sm-5"))
        Assertions.assertTrue(labelTester.getAttributeContains("class", "col-md-4"))
        Assertions.assertTrue(labelTester.getAttributeContains("class", "col-lg-3"))
        val containerTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "container")
        Assertions.assertTrue(containerTester.getAttributeContains("class", "col-sm-7"))
        Assertions.assertTrue(containerTester.getAttributeContains("class", "col-md-8"))
        Assertions.assertTrue(containerTester.getAttributeContains("class", "col-lg-9"))
    }
}