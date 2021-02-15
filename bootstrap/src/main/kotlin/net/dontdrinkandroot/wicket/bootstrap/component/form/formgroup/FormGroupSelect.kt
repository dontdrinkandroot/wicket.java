package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup

import org.apache.wicket.markup.html.form.ChoiceRenderer
import org.apache.wicket.markup.html.form.DropDownChoice
import org.apache.wicket.markup.html.form.IChoiceRenderer
import org.apache.wicket.model.IModel

/**
 * @param <T> Type of the [DropDownChoice].
 */
class FormGroupSelect<T>(
    id: String,
    model: IModel<T>,
    labelModel: IModel<String>,
    private val choicesModel: IModel<List<T>>,
    choiceRenderer: IChoiceRenderer<T> = ChoiceRenderer()
) : FormGroupFormComponent<T, T, DropDownChoice<T>>(id, model, labelModel) {

    init {
        formComponent.setChoices(choicesModel)
        formComponent.choiceRenderer = choiceRenderer
    }

    override fun createFormComponent(id: String): DropDownChoice<T> {
        return DropDownChoice(id, model, choicesModel)
    }

    fun setNullValid(nullValid: Boolean) {
        formComponent.isNullValid = nullValid
    }
}