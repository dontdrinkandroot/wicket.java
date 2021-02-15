package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup

import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.model.IModel

class FormGroupStatic(id: String, model: IModel<String>, labelModel: IModel<String>) :
    FormGroup<String>(id, model, labelModel) {

    private lateinit var content: Label

    override fun createComponents() {
        super.createComponents()
        content = Label("content", this.model)
    }

    override fun addComponents() {
        super.addComponents()
        container.add(content)
    }
}