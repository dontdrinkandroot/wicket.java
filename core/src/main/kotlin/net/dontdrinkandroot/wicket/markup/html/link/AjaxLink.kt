package net.dontdrinkandroot.wicket.markup.html.link

import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.apache.wicket.ajax.markup.html.AjaxLink as WicketAjaxLink

abstract class AjaxLink<T>(
    id: String,
    model: IModel<T>? = null,
    behaviors: Collection<Behavior> = emptyList(),
    bodyModel: IModel<String> = Model(null),
) : WicketAjaxLink<T>(id, model) {

    init {
        body = bodyModel
        behaviors.forEach { this.add(it) }
    }
}

fun <T> ajaxLink(
    id: String,
    model: IModel<T>? = null,
    behaviors: Collection<Behavior> = emptyList(),
    bodyModel: IModel<String> = Model(null),
    onClickHandler: AjaxLink<T>.(target: AjaxRequestTarget?) -> Any?
) = object : AjaxLink<T>(id, model, behaviors = behaviors, bodyModel = bodyModel) {
    override fun onClick(target: AjaxRequestTarget?) {
        onClickHandler(target)
    }
}