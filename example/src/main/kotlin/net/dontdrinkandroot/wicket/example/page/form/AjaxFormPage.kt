package net.dontdrinkandroot.wicket.example.page.form

import net.dontdrinkandroot.wicket.bootstrap.component.button.SubmitLabelButton
import net.dontdrinkandroot.wicket.bootstrap.component.form.RepeatingAjaxForm
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupInputText
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

class AjaxFormPage(parameters: PageParameters) : FormPage(parameters) {

    private var submitCount = 0
    override fun createPageHeadingModel() = "Ajax Form".model()

    override fun onInitialize() {
        super.onInitialize()
        val simpleAjaxForm: RepeatingAjaxForm<Void> = object : RepeatingAjaxForm<Void>("simpleAjaxForm") {
            override fun populateFormGroups(formGroupView: RepeatingView) {
                super.populateFormGroups(formGroupView)
                formGroupView.add(
                    FormGroupInputText(
                        formGroupView.newChildId(),
                        "TextField".model(),
                        Model()
                    )
                )
            }

            override fun populateActions(buttonView: RepeatingView) {
                super.populateActions(buttonView)
                buttonView.add(SubmitLabelButton(buttonView.newChildId(), Model.of("Submit")))
            }

            override fun onSubmit(target: AjaxRequestTarget?) {
                super.onSubmit(target)
                submitCount++
                this.info(String.format("Submitted %d times", submitCount))
                target?.add(this.feedbackPanel)
            }
        }
        this.add(simpleAjaxForm)
    }
}