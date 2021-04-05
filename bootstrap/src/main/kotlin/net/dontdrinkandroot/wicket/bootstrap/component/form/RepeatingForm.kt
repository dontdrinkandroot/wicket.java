package net.dontdrinkandroot.wicket.bootstrap.component.form

import net.dontdrinkandroot.wicket.bootstrap.component.feedback.FencedFeedbackPanel
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupActions
import org.apache.wicket.Component
import org.apache.wicket.IQueueRegion
import org.apache.wicket.MarkupContainer
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.ComponentTag
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.markup.html.panel.FeedbackPanel
import org.apache.wicket.markup.html.panel.IMarkupSourcingStrategy
import org.apache.wicket.markup.html.panel.PanelMarkupSourcingStrategy
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel

/**
 * @param <T> Type of the Model object.
 */
open class RepeatingForm<T>(id: String, model: IModel<T>? = null) : Form<T>(id, model), IQueueRegion {

    lateinit var feedbackPanel: FeedbackPanel
        private set

    override fun onInitialize() {
        super.onInitialize()
        feedbackPanel = FencedFeedbackPanel("feedback", this).apply {
            outputMarkupId = true
        }
        add(feedbackPanel)
        val formGroupView = RepeatingView("formGroup")
        populateFormGroups(formGroupView)
        this.add(formGroupView)
        val formGroupActions = createActionsView("actions")
        this.add(formGroupActions)
    }

    protected open fun createActionsView(id: String): Component {
        return object : FormGroupActions<Void>(id) {
            override fun populateActions(actionView: RepeatingView) {
                this@RepeatingForm.populateActions(actionView)
            }
        }
    }

    override fun newMarkupSourcingStrategy(): IMarkupSourcingStrategy = PanelMarkupSourcingStrategy(false)

    override fun onComponentTag(tag: ComponentTag) {
        tag.name = "form"
        super.onComponentTag(tag)
    }

    protected open fun populateFormGroups(formGroupView: RepeatingView) {
        /* Hook */
    }

    protected open fun populateActions(buttonView: RepeatingView) {
        /* Hook */
    }
}

inline fun <T> MarkupContainer.addForm(
    id: String,
    model: IModel<T>,
    crossinline formGroups: RepeatingView.(component: RepeatingForm<T>) -> Any?,
    vararg behaviors: Behavior,
    crossinline submit: RepeatingForm<T>.() -> Any? = {}
): RepeatingForm<T> {
    val form = object : RepeatingForm<T>(id, model) {

        override fun populateFormGroups(formGroupView: RepeatingView) {
            formGroups(formGroupView, this)
        }

        override fun onSubmit() {
            submit()
        }
    }.apply { add(*behaviors) }
    add(form)
    return form
}

inline fun MarkupContainer.addForm(
    id: String,
    crossinline formGroups: RepeatingView.(component: RepeatingForm<Void>) -> Any?,
    vararg behaviors: Behavior,
    crossinline submit: RepeatingForm<Void>.() -> Any? = {}
): RepeatingForm<Void> {
    val form = object : RepeatingForm<Void>(id) {

        override fun populateFormGroups(formGroupView: RepeatingView) {
            formGroups(formGroupView, this)
        }

        override fun onSubmit() {
            submit()
        }
    }.apply {
        add(*behaviors)
    }
    add(form)
    return form
}
