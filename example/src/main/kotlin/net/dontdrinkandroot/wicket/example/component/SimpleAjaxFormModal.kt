package net.dontdrinkandroot.wicket.example.component

import net.dontdrinkandroot.wicket.bootstrap.component.button.SubmitLabelButton
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupInputText
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupStatic
import net.dontdrinkandroot.wicket.bootstrap.component.modal.AjaxFormModal
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

class SimpleAjaxFormModal(id: String) : AjaxFormModal<Void>(id) {

    override fun createHeadingModel(): IModel<String> = Model("This is a form modal")

    override fun populateFormGroups(formGroupView: RepeatingView) {
        formGroupView.add(
            FormGroupStatic(
                formGroupView.newChildId(),
                Model("A static label"),
                Model(FormGroupStatic::class.java.simpleName)
            )
        )
        val formGroupInputText = FormGroupInputText(
            formGroupView.newChildId(),
            Model(""),
            Model(FormGroupInputText::class.java.simpleName)
        )
        formGroupInputText.setRequired(true)
        formGroupInputText.addAjaxValidation()
        formGroupView.add(formGroupInputText)
    }

    override fun populateFormActions(formActionView: RepeatingView)
    {
        formActionView.add(SubmitLabelButton(formActionView.newChildId(), Model.of("Submit")))
    }
}