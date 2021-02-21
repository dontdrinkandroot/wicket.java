package net.dontdrinkandroot.wicket.markup.html.link

import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.ajax.markup.html.AjaxLink
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import net.dontdrinkandroot.wicket.markup.html.link.AjaxLink as DdrAjaxLink

open class AjaxLink<T>(
    id: String,
    model: IModel<T>? = null,
    behaviors: Collection<Behavior> = emptyList(),
    bodyModel: IModel<String> = Model(null),
    private val onClickHandler: DdrAjaxLink<T>.(target: AjaxRequestTarget?) -> Any?
) : AjaxLink<T>(id, model) {

    init {
        body = bodyModel
        behaviors.forEach { this.add(it) }
    }

    override fun onClick(target: AjaxRequestTarget?) {
        onClickHandler(this, target)
    }
}