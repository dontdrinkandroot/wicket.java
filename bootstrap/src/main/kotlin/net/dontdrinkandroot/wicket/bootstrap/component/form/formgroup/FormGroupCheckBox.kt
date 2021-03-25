package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup

import net.dontdrinkandroot.wicket.bootstrap.behavior.form.FormContainerSizeBehavior
import net.dontdrinkandroot.wicket.bootstrap.behavior.form.FormLabelSizeBehavior
import net.dontdrinkandroot.wicket.bootstrap.behavior.form.FormRowBehavior
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.markup.html.form.CheckBox
import org.apache.wicket.model.IModel

class FormGroupCheckBox(id: String, model: IModel<Boolean>, labelModel: IModel<String>) :
    FormGroupFormComponent<Boolean, Boolean, CheckBox>(id, model, labelModel) {

    private lateinit var offset: WebMarkupContainer

    override fun createFormComponent(id: String): CheckBox = CheckBox(id, this.model)

    override fun createComponents() {
        super.createComponents()
        offset = WebMarkupContainer("offset")
    }

    override fun addComponents() {
        this.add(offset)
        this.add(container)
        container.add(formTextLabel)
        container.add(validationFeedbackPanel)
        container.add(label)
        container.add(formComponent)
    }

    override fun addBehaviors() {
        add(FormRowBehavior())
        offset.add(FormLabelSizeBehavior())
        container.add(FormContainerSizeBehavior())
    }
}