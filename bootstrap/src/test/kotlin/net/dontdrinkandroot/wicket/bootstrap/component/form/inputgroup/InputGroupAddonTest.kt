package net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup

import net.dontdrinkandroot.wicket.bootstrap.component.button.button
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupInputText
import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import net.dontdrinkandroot.wicket.bootstrap.test.TestFormPanel
import org.apache.wicket.Component
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.model.Model
import org.apache.wicket.util.tester.TagTester
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class InputGroupAddonTest : AbstractWicketTest() {

    @Test
    fun testMarkup() {
        val formPanel = TestFormPanel("id")
        val formGroupInputText: FormGroupInputText<String> =
            object : FormGroupInputText<String>("formGroup", Model.of("Value"), Model("Label")) {
                override fun createInputGroupPrepend(id: String): Component =
                    InputGroupTextLabel(id, Model.of("Label"))

                override fun createInputGroupAppend(id: String): Component =
                    button<Void>(id, bodyModel = Model("Button")) {}
            }
        formPanel.form.add(formGroupInputText)
        val componentMarkup = ComponentRenderer.renderComponent(formGroupInputText)
        val inputGroupAddonBefore =
            TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "inputGroupPrepend")
        Assertions.assertEquals("input-group-text", inputGroupAddonBefore.getAttribute("class"))
        val inputGroupAddonAfter =
            TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "inputGroupAppend")
        Assertions.assertEquals("btn btn-secondary", inputGroupAddonAfter.getAttribute("class"))
    }
}