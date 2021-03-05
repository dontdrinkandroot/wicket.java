package net.dontdrinkandroot.wicket.example.component

import net.dontdrinkandroot.wicket.bootstrap.component.button.AjaxSubmitButton
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupInputText
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupStatic
import net.dontdrinkandroot.wicket.bootstrap.component.modal.FormModal
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

class SimpleFormModal(id: String) : FormModal<Void>(id) {

    override fun createHeadingModel(): IModel<String> {
        return Model.of("This is a form modal")
    }

    override fun populateFormGroups(formGroupView: RepeatingView) {
        formGroupView.add(
            FormGroupStatic(
                formGroupView.newChildId(),
                Model.of("A static label"),
                Model(FormGroupStatic::class.java.simpleName)
            )
        )
        formGroupView.add(
            FormGroupInputText(
                formGroupView.newChildId(),
                Model.of(""),
                Model(FormGroupInputText::class.java.simpleName)
            )
        )
    }

    override fun populateFormActions(formActionView: RepeatingView) {
        formActionView.add(object : AjaxSubmitButton(formActionView.newChildId(), form, Model.of("Submit")) {})
    }
}