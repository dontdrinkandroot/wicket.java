package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup

import org.apache.wicket.markup.html.form.AbstractChoice
import org.apache.wicket.markup.html.form.CheckBoxMultipleChoice
import org.apache.wicket.markup.html.form.ChoiceRenderer
import org.apache.wicket.markup.html.form.IChoiceRenderer
import org.apache.wicket.model.IModel

class FormGroupCheckBoxMultipleChoice<T>(
    id: String,
    model: IModel<out Collection<T>>,
    labelModel: IModel<String>,
    choices: List<T>,
    choiceRenderer: IChoiceRenderer<T> = ChoiceRenderer()
) : FormGroupFormComponent<Collection<T>, Collection<T>, CheckBoxMultipleChoice<T>>(
    id, (model as IModel<Collection<T>>), labelModel
) {

    init {
        formComponent.choices = choices
        formComponent.choiceRenderer = choiceRenderer
    }

    override fun createFormComponent(id: String): CheckBoxMultipleChoice<T> {
        val formComponent = CheckBoxMultipleChoice(id, this.model, emptyList())
        formComponent.prefix = "<div class=\"checkbox\">"
        formComponent.suffix = "</div>"
        formComponent.setLabelPosition(AbstractChoice.LabelPosition.WRAP_AFTER)
        return formComponent
    }
}