package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup

import org.apache.wicket.markup.html.form.AbstractChoice
import org.apache.wicket.markup.html.form.RadioChoice
import org.apache.wicket.model.IModel

/**
 * @param <T> Type of the model object.
 */
class FormGroupRadioChoice<T>(
    id: String,
    model: IModel<T>,
    labelModel: IModel<String>,
    private var choicesModel: IModel<List<T>>
) :
    FormGroupFormComponent<T, T, RadioChoice<T>>(id, model, labelModel) {

    init {
        formComponent.setChoices(choicesModel)
    }

    override fun createFormComponent(id: String): RadioChoice<T> {
        val radioChoice = RadioChoice(id, model, choicesModel)
        radioChoice.prefix = "<div class=\"radio\">"
        radioChoice.suffix = "</div>"
        radioChoice.setLabelPosition(AbstractChoice.LabelPosition.WRAP_AFTER)
        return radioChoice
    }
}