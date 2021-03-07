package net.dontdrinkandroot.wicket.markup.html.form

import org.apache.wicket.MarkupContainer
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.ajax.markup.html.form.AjaxCheckBox
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.model.IModel

inline fun createAjaxCheckBox(
    id: String,
    model: IModel<Boolean>,
    vararg behaviors: Behavior,
    crossinline onUpdateHandler: AjaxCheckBox.(target: AjaxRequestTarget?) -> Any?
) = object : AjaxCheckBox(id, model) {
    init {
        add(*behaviors)
    }

    override fun onUpdate(target: AjaxRequestTarget?) {
        onUpdateHandler(target)
    }
}

inline fun MarkupContainer.ajaxCheckbox(
    id: String,
    model: IModel<Boolean>,
    vararg behaviors: Behavior,
    crossinline onUpdateHandler: AjaxCheckBox.(target: AjaxRequestTarget?) -> Any?
) {
    add(createAjaxCheckBox(id, model, behaviors = behaviors, onUpdateHandler))
}