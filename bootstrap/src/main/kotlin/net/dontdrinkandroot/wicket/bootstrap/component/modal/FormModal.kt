package net.dontdrinkandroot.wicket.bootstrap.component.modal

import net.dontdrinkandroot.wicket.bootstrap.component.feedback.FencedFeedbackPanel
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel

/**
 * @param <T> Type of the model object
 */
abstract class FormModal<T>(id: String, model: IModel<T>? = null) : Modal<T>(id, model) {

    lateinit var form: Form<T>
        private set

    protected lateinit var feedbackPanel: FencedFeedbackPanel
        private set

    override fun onInitialize() {
        super.onInitialize()

        form = createForm("form")
        this.add(form)

        feedbackPanel = FencedFeedbackPanel("feedback", this)
        feedbackPanel.outputMarkupId = true
        form.add(feedbackPanel)

        val formGroupView = RepeatingView("formGroup")
        populateFormGroups(formGroupView)
        form.add(formGroupView)

        val formActionView = RepeatingView("formAction")
        populateFormActions(formActionView)
        form.add(formActionView)
    }

    protected open fun createForm(id: String): Form<T> {
        return object : Form<T>(id, this.model) {
            override fun onError() {
                this@FormModal.onError()
            }

            override fun onSubmit() {
                this@FormModal.onSubmit()
            }
        }
    }

    override fun addFooter() {
        /* Noop */
    }

    protected open fun populateFormActions(formActionView: RepeatingView) {
        /* Hook */
    }

    protected open fun populateFormGroups(formGroupView: RepeatingView) {
        /* Hook */
    }

    /**
     * @see Form.onError
     */
    protected open fun onError() {
        /* Hook */
    }

    /**
     * @see Form.onSubmit
     */
    protected open fun onSubmit() {
        /* Hook */
    }
}