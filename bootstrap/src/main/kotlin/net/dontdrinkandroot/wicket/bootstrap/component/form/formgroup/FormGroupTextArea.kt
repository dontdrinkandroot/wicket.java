package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup

import org.apache.wicket.behavior.AttributeAppender
import org.apache.wicket.markup.html.HTML5Attributes
import org.apache.wicket.markup.html.form.TextArea
import org.apache.wicket.model.IModel

/**
 * @param <T> Type of the model object.
 */
class FormGroupTextArea<T>(id: String, model: IModel<T>, labelModel: IModel<String>) :
    FormGroupFormComponent<T, T, TextArea<T>>(id, model, labelModel) {

    private var rows = 5
    override fun createFormComponent(id: String): TextArea<T> {
        val textArea = TextArea(id, model)
        textArea.add(AttributeAppender("rows") { rows })
        textArea.add(HTML5Attributes())
        return textArea
    }

    fun setRows(rows: Int) {
        this.rows = rows
    }
}