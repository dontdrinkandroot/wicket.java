package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import net.dontdrinkandroot.wicket.bootstrap.test.TestFormPanel
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.model.Model
import org.apache.wicket.util.tester.TagTester
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class FormGroupCheckBoxTest : AbstractWicketTest() {

    @Test
    fun testDefaultMarkup() {
        val formPanel = TestFormPanel("id")
        val formGroup = FormGroupCheckBox("formGroup", Model("Label"), Model.of(true))
        formPanel.form.add(formGroup)
        val componentMarkup = ComponentRenderer.renderComponent(formPanel)
        val formGroupTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "formGroup")
        Assertions.assertTrue(formGroupTester.getAttributeContains("class", "form-group"))
        val labelTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "label")
        Assertions.assertEquals("Label", labelTester.value)
        val formComponentTester =
            TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "formComponent")
        Assertions.assertEquals("checkbox", formComponentTester.getAttribute("type"))
        Assertions.assertEquals("checked", formComponentTester.getAttribute("checked"))
    }
}