package net.dontdrinkandroot.wicket.component.form

import net.dontdrinkandroot.wicket.test.FormComponentTestPage
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.apache.wicket.model.util.ListModel
import org.apache.wicket.util.tester.WicketTestCase
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class AjaxDropDownChoiceTest : WicketTestCase() {

    @Test
    fun testAjaxBehavior() {
        val model: IModel<String> = Model()
        val selectionChangedCalled: IModel<Boolean> = Model.of(java.lang.Boolean.FALSE)
        val dropDownChoice: AjaxDropDownChoice<String> =
            object : AjaxDropDownChoice<String>("id", model, ListModel(listOf("Red", "Green", "Blue"))) {
                override fun onSelectionChanged(target: AjaxRequestTarget) {
                    super.onSelectionChanged(target)
                    selectionChangedCalled.setObject(java.lang.Boolean.TRUE)
                }
            }
        val formComponentTestPage: FormComponentTestPage = object : FormComponentTestPage(dropDownChoice) {
            override val formComponentMarkup: String
                get() = "<select wicket:id=\"id\"></select>"
        }
        tester.startPage(formComponentTestPage)
        val formTester = tester.newFormTester("form")
        formTester.select("id", 1)
        tester.executeAjaxEvent(dropDownChoice, "change")
        Assertions.assertTrue(selectionChangedCalled.getObject())
        Assertions.assertEquals("Green", model.getObject())
    }
}