package net.dontdrinkandroot.wicket.component.form

import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior
import org.apache.wicket.markup.html.form.ChoiceRenderer
import org.apache.wicket.markup.html.form.DropDownChoice
import org.apache.wicket.markup.html.form.IChoiceRenderer
import org.apache.wicket.model.IModel

open class AjaxDropDownChoice<T>(
    id: String,
    model: IModel<T>? = null,
    choicesModel: IModel<List<T>>,
    renderer: IChoiceRenderer<T> = ChoiceRenderer()
) : DropDownChoice<T>(id, model, choicesModel, renderer) {

    override fun onInitialize() {
        super.onInitialize()
        this.outputMarkupId = true
        this.add(object : AjaxFormComponentUpdatingBehavior("change") {
            override fun onUpdate(target: AjaxRequestTarget) {
                onSelectionChanged(target)
            }
        })
    }

    protected open fun onSelectionChanged(target: AjaxRequestTarget) {
        /* Hook */
    }
}