package net.dontdrinkandroot.wicket.markup.html.link

import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.ajax.markup.html.AjaxLink
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

inline fun <T> ajaxLink(
    id: String,
    model: IModel<T>? = null,
    bodyModel: IModel<String> = Model(null),
    vararg behaviors: Behavior,
    crossinline onClickHandler: AjaxLink<T>.(target: AjaxRequestTarget?) -> Any?
) = object : AjaxLink<T>(id, model) {
    init {
        body = bodyModel
        behaviors.forEach { this.add(it) }
    }

    override fun onClick(target: AjaxRequestTarget?) {
        onClickHandler(target)
    }
}