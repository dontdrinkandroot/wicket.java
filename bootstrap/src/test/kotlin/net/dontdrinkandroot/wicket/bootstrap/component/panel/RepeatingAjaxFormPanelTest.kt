package net.dontdrinkandroot.wicket.bootstrap.component.panel

import net.dontdrinkandroot.wicket.bootstrap.component.button.SubmitLabelButton
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupInputText
import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.Model
import org.apache.wicket.util.tester.TagTester
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class RepeatingAjaxFormPanelTest : AbstractWicketTest() {

    @Test
    fun testMarkup() {
        val component: RepeatingAjaxFormPanel<Void> =
            object : RepeatingAjaxFormPanel<Void>("id", null, Model("title")) {
                override fun populateFormGroups(formGroupView: RepeatingView) {
                    super.populateFormGroups(formGroupView)
                    formGroupView.add(
                        FormGroupInputText(
                            formGroupView.newChildId(),
                            Model("Text"),
                            Model()
                        )
                    )
                }

                override fun populateActions(buttonView: RepeatingView) {
                    super.populateActions(buttonView)
                    buttonView.add(SubmitLabelButton(buttonView.newChildId(), Model.of("Submit")))
                }
            }
        val componentMarkup = ComponentRenderer.renderComponent(component)
        val formTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id")
        Assertions.assertTrue(formTester.getAttributeContains("class", "panel"))
        Assertions.assertTrue(formTester.getAttributeContains("class", "panel-default"))
    }
}