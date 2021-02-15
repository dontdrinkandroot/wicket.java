package net.dontdrinkandroot.wicket.bootstrap.component.button

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle
import net.dontdrinkandroot.wicket.model.CssClassToggleModel
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.ajax.markup.html.AjaxLink
import org.apache.wicket.markup.html.panel.GenericPanel
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.apache.wicket.model.util.ListModel

/**
 * @param <T> Type of the model object.
 */
class ButtonGroupChoice<T>(
    id: String,
    model: IModel<T>?,
    choicesModel: IModel<List<T>>,
    buttonStyleModel: IModel<ButtonStyle> = ButtonStyle.SECONDARY.model(),
    buttonSizeModel: IModel<ButtonSize> = Model(null)
) : GenericPanel<T>(id, model) {

    private val buttonBehavior = ButtonBehavior(buttonStyleModel, buttonSizeModel)

    constructor(
        id: String, model: IModel<T>?,
        choices: List<T>?,
        buttonStyleModel: IModel<ButtonStyle> = ButtonStyle.SECONDARY.model(),
        buttonSizeModel: IModel<ButtonSize> = Model(null)
    ) : this(id, model, ListModel<T>(choices), buttonStyleModel, buttonSizeModel)

    init {
        this.outputMarkupId = true
        this.add(CssClassAppender(BootstrapCssClass.BTN_GROUP))
        val choicesView = RepeatingView("choice")
        choicesView.outputMarkupId = true
        this.add(choicesView)
        for (choice in choicesModel.getObject()) {
            val choiceId = choicesView.newChildId()
            val choiceLink = createChoiceButton(choiceId, choice)
            choicesView.add(choiceLink)
        }
    }

    /**
     * Creates the Button for the the given choice.
     */
    protected fun createChoiceButton(id: String, choice: T): AjaxLink<Void> {
        val choiceLink: AjaxLink<Void> = object : AjaxLink<Void>(id) {
            override fun onClick(target: AjaxRequestTarget) {
                onSelectionChanged(choice, target)
            }
        }
        choiceLink.body = getDisplayModel(choice)
        choiceLink.add(buttonBehavior)
        choiceLink.add(
            CssClassAppender(
                CssClassToggleModel(
                    BootstrapCssClass.ACTIVE,
                    { this@ButtonGroupChoice.modelObject == choice })
            )
        )
        return choiceLink
    }

    protected fun onSelectionChanged(choice: T, target: AjaxRequestTarget) {
        this.modelObject = choice
        target.add(this@ButtonGroupChoice)
    }

    protected fun getDisplayModel(choice: T): IModel<String> {
        return Model(choice.toString())
    }
}