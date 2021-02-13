package net.dontdrinkandroot.wicket.bootstrap.behavior.form

import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupInputEmail
import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import net.dontdrinkandroot.wicket.bootstrap.test.FormGroupTestPage
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.model.Model
import org.apache.wicket.util.tester.TagTester
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class FormGroupAjaxValidationBehaviorTest : AbstractWicketTest() {

    @Test
    fun testError() {
        val page: FormGroupTestPage<FormGroupInputEmail> = object : FormGroupTestPage<FormGroupInputEmail>() {
            override fun createFormGroup(id: String): FormGroupInputEmail {
                val formGroup = FormGroupInputEmail(id, Model("Label"), Model())
                formGroup.addAjaxValidation("blur")
                return formGroup
            }
        }
        tester.startPage(page)
        val formTester = tester.newFormTester("form", false)
        formTester.setValue("formGroup:container:inputGroup:formComponent", "invalid")
        tester.executeAjaxEvent(page.formGroup.formComponent, "blur")
        val componentMarkup = ComponentRenderer.renderComponent(page.formGroup)
        val formGroupTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "formGroup")
        Assertions.assertTrue(formGroupTester.getAttributeContains("class", "form-group"))
        val formComponentTester =
            TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "formComponent")
        Assertions.assertTrue(formComponentTester.getAttributeContains("class", "is-invalid"))
        val messagesTesters =
            TagTester.createTagsByAttribute(componentMarkup.toString(), "wicket:id", "messages", false)
        Assertions.assertEquals(1, messagesTesters.size)
        val messageTester = messagesTesters[0]
        Assertions.assertTrue(messageTester.getAttributeContains("class", "invalid-feedback"))
        Assertions.assertEquals(
            "The value of &#039;Label&#039; is not a valid email address.",
            messageTester.getChild("container").value
        )

        //TODO: Test jQuery validations
    }
}