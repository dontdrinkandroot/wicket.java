package net.dontdrinkandroot.wicket.markup.html.link

import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.ajax.markup.html.AjaxLink
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.model.IModel
import net.dontdrinkandroot.wicket.markup.html.link.AjaxLink as DdrAjaxLink

class AjaxLink<T>(
    id: String,
    model: IModel<T>? = null,
    behaviors: Collection<Behavior> = emptyList(),
    private val onClickHandler: (context: DdrAjaxLink<T>, target: AjaxRequestTarget?) -> Any?
) : AjaxLink<T>(id, model) {

    init {
        behaviors.forEach { this.add(it) }
    }

    override fun onClick(target: AjaxRequestTarget?) {
        onClickHandler(this, target)
    }
}
