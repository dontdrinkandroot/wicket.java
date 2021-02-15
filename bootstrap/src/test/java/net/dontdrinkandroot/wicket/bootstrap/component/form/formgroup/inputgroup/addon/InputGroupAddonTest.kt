package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.inputgroup.addon

import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupInputText
import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.addon.InputGroupButton
import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.addon.InputGroupLabel
import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import net.dontdrinkandroot.wicket.bootstrap.test.TestFormPanel
import net.dontdrinkandroot.wicket.bootstrap.test.TestHomePage
import org.apache.wicket.Component
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.markup.html.link.BookmarkablePageLink
import org.apache.wicket.model.Model
import org.apache.wicket.util.tester.TagTester
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class InputGroupAddonTest : AbstractWicketTest() {

    @Test
    fun testMarkup() {
        val formPanel = TestFormPanel("id")
        val formGroupInputText: FormGroupInputText =
            object : FormGroupInputText("formGroup", Model("Label"), Model.of("Value")) {
                override fun createInputGroupPrepend(id: String): Component {
                    return InputGroupLabel(id, Model.of("Label"))
                }

                override fun createInputGroupAppend(id: String): Component {
                    return object : InputGroupButton<Void>(id) {
                        override fun createLink(id: String): Component {
                            return BookmarkablePageLink<Any, TestHomePage>(id, TestHomePage::class.java)
                        }
                    }
                }
            }
        formPanel.form.add(formGroupInputText)
        val componentMarkup = ComponentRenderer.renderComponent(formGroupInputText)
        val inputGroupAddonBefore =
            TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "inputGroupPrepend")
        Assertions.assertEquals("input-group-addon", inputGroupAddonBefore.getAttribute("class"))
        val inputGroupAddonAfter =
            TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "inputGroupAppend")
        Assertions.assertEquals("input-group-btn", inputGroupAddonAfter.getAttribute("class"))
    }
}