package net.dontdrinkandroot.wicket.markup.html.form

import org.apache.wicket.MarkupContainer
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.form.TextField
import org.apache.wicket.model.IModel

fun <T> MarkupContainer.addTextField(id: String, model: IModel<T>, vararg behaviors: Behavior): TextField<T> {
    val textField = TextField(id, model).apply { add(*behaviors) }
    add(textField)
    return textField
}