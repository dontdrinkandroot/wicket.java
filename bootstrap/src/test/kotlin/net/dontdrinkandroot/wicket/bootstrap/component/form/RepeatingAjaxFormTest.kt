package net.dontdrinkandroot.wicket.bootstrap.component.form

import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupInputText
import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import net.dontdrinkandroot.wicket.bootstrap.test.FormTestPage
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.Model
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

class RepeatingAjaxFormTest : AbstractWicketTest() {

    @Test
    fun testPlainMarkup() {
        val component: RepeatingAjaxForm<*> = RepeatingAjaxForm<Any?>("id")
        val componentMarkup = ComponentRenderer.renderComponent(component)
        Assertions.assertEquals(
            """<wicket:form wicket:id="id" id="id1" method="post" action="./wicket/page?0-0.-id"><wicket:panel>
		<div wicket:id="feedback" id="feedback2"><wicket:panel>
		
	</wicket:panel></div>
		
		<div wicket:id="actions" id="actions3" class="form-group"><wicket:panel>
		<label wicket:id="label" class="form-label"></label>
		<div wicket:id="container">
			<wicket:child><wicket:extend>
    <div class="btn-toolbar">
        
    </div>
</wicket:extend></wicket:child>
		</div>
	</wicket:panel></div>
	</wicket:panel></wicket:form>""",
            componentMarkup.toString()
        )
    }

    @Test
    fun testSubmit() {
        val callSet: MutableSet<String> = HashSet()
        val component: RepeatingAjaxForm<Void> = object : RepeatingAjaxForm<Void>(FormTestPage.COMPONENT_ID) {
            override fun populateFormGroups(formGroupView: RepeatingView) {
                super.populateFormGroups(formGroupView)
                val formGroup = FormGroupInputText(formGroupView.newChildId(), Model("Label"), Model())
                formGroup.setRequired(true)
                formGroupView.add(formGroup)
            }

            override fun onSubmit(target: AjaxRequestTarget?) {
                super.onSubmit(target)
                callSet.add("onSubmit")
                if (null != target) {
                    callSet.add("onSubmitAjax")
                }
            }

            override fun onAfterSubmit(target: AjaxRequestTarget?) {
                super.onAfterSubmit(target)
                callSet.add("onAfterSubmit")
                if (null != target) {
                    callSet.add("onAfterSubmitAjax")
                }
            }

            override fun onError(target: AjaxRequestTarget?) {
                super.onError(target)
                callSet.add("onError")
                if (null != target) {
                    callSet.add("onErrorAjax")
                }
            }
        }
        val page = FormTestPage(component)
        tester.startPage(page)

        /* Default submit with error */
        var formTester = tester.newFormTester(FormTestPage.COMPONENT_ID, false)
        formTester.submit()
        Assertions.assertFalse(callSet.contains("onSubmit"))
        Assertions.assertFalse(callSet.contains("onSubmitAjax"))
        Assertions.assertFalse(callSet.contains("onAfterSubmit"))
        Assertions.assertFalse(callSet.contains("onAfterSubmitAjax"))
        Assertions.assertTrue(callSet.contains("onError"))
        Assertions.assertFalse(callSet.contains("onErrorAjax"))

        /* Ajax submit with error */callSet.clear()
        tester.executeAjaxEvent(component, "submit")
        Assertions.assertFalse(callSet.contains("onSubmit"))
        Assertions.assertFalse(callSet.contains("onSubmitAjax"))
        Assertions.assertFalse(callSet.contains("onAfterSubmit"))
        Assertions.assertFalse(callSet.contains("onAfterSubmitAjax"))
        Assertions.assertTrue(callSet.contains("onError"))
        Assertions.assertTrue(callSet.contains("onErrorAjax"))

        /* Populating textfield */formTester = tester.newFormTester(FormTestPage.COMPONENT_ID, false)
        formTester.setValue("formGroup:1:container:inputGroup:formComponent", "valid")

        /* Default submit with success */callSet.clear()
        formTester.submit()
        Assertions.assertTrue(callSet.contains("onSubmit"))
        Assertions.assertFalse(callSet.contains("onSubmitAjax"))
        Assertions.assertTrue(callSet.contains("onAfterSubmit"))
        Assertions.assertFalse(callSet.contains("onAfterSubmitAjax"))
        Assertions.assertFalse(callSet.contains("onError"))
        Assertions.assertFalse(callSet.contains("onErrorAjax"))

        /* Ajax submit with success */callSet.clear()
        tester.executeAjaxEvent(component, "submit")
        Assertions.assertTrue(callSet.contains("onSubmit"))
        Assertions.assertTrue(callSet.contains("onSubmitAjax"))
        Assertions.assertTrue(callSet.contains("onAfterSubmit"))
        Assertions.assertTrue(callSet.contains("onAfterSubmitAjax"))
        Assertions.assertFalse(callSet.contains("onError"))
        Assertions.assertFalse(callSet.contains("onErrorAjax"))
    }
}