package net.dontdrinkandroot.wicket.bootstrap.component.modal

import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupInputText
import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import net.dontdrinkandroot.wicket.bootstrap.test.ComponentTestPage
import net.dontdrinkandroot.wicket.bootstrap.test.FormTestPage
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.apache.wicket.util.tester.TagTester
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class AjaxFormModalTest : AbstractWicketTest() {

    @Test
    fun testDefaultMarkup() {
        val component: AjaxFormModal<String> = object : AjaxFormModal<String>("modalId") {
            override fun createHeadingModel(): IModel<String> {
                return Model.of("Modal Heading")
            }
        }
        val componentMarkup = ComponentRenderer.renderComponent(component).toString()
        var tester: TagTester
        tester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "modalId")
        Assertions.assertTrue(tester.getAttributeContains("class", "modal"))
        Assertions.assertTrue(tester.getAttributeContains("class", "fade"))
        tester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "heading")
        Assertions.assertEquals("Modal Heading", tester.value)
    }

    @Test
    fun testSubmit() {
        val testStringModel: IModel<String?> = Model()

        val component: AjaxFormModal<String?> =
            object : AjaxFormModal<String?>(FormTestPage.COMPONENT_ID, testStringModel) {
                override fun createHeadingModel(): IModel<String> {
                    return Model.of("Heading")
                }

                override fun populateFormGroups(formGroupView: RepeatingView) {
                    super.populateFormGroups(formGroupView)
                    val formGroup = FormGroupInputText(
                        formGroupView.newChildId(),
                        testStringModel,
                        Model("Label")
                    )
                    formGroup.setRequired(true)
                    formGroupView.add(formGroup)
                }

                override fun onError(target: AjaxRequestTarget?) {
                    super.onError(target)
                    testStringModel.setObject("error")
                }
            }
        val page = ComponentTestPage(component)
        tester.startPage(page)

        /* Default submit with error */
        var formTester = tester.newFormTester(FormTestPage.COMPONENT_ID + ":form", false)
        formTester.submit()

        /* Ajax submit with error */
        tester.executeAjaxEvent(component.form, "submit")
        Assertions.assertEquals("error", testStringModel.getObject())

        /* Default submit with success */
        formTester = tester.newFormTester(FormTestPage.COMPONENT_ID + ":form", false)
        formTester.setValue("formGroup:1:container:inputGroup:formComponent", "default")
        formTester.submit()
        Assertions.assertEquals("default", testStringModel.getObject())

        /* Ajax submit with success */
        formTester = tester.newFormTester(FormTestPage.COMPONENT_ID + ":form", false)
        formTester.setValue("formGroup:1:container:inputGroup:formComponent", "ajax")
        tester.executeAjaxEvent(component.form, "submit")
        Assertions.assertEquals("ajax", testStringModel.getObject())
    }
}