package net.dontdrinkandroot.wicket.example.component

import net.dontdrinkandroot.wicket.bootstrap.component.button.AjaxSubmitButton
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupInputText
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupStatic
import net.dontdrinkandroot.wicket.bootstrap.component.modal.FormModal
import net.dontdrinkandroot.wicket.model.model
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
                FormGroupStatic::class.java.simpleName.model()
            )
        )
        formGroupView.add(
            FormGroupInputText(
                formGroupView.newChildId(),
                Model.of(""),
                FormGroupInputText::class.java.simpleName.model()
            )
        )
    }

    override fun populateFormActions(formActionView: RepeatingView) {
        formActionView.add(object : AjaxSubmitButton(formActionView.newChildId(), form, Model.of("Submit")) {})
    }
}