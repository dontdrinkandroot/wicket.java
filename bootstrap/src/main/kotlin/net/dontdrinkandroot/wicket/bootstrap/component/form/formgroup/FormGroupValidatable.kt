package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.behavior.ForComponentIdBehavior
import net.dontdrinkandroot.wicket.behavior.cssClass
import net.dontdrinkandroot.wicket.behavior.visible
import net.dontdrinkandroot.wicket.bootstrap.behavior.form.FormGroupAjaxValidationBehavior
import net.dontdrinkandroot.wicket.bootstrap.component.feedback.FormValidationFeedbackPanel
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.bootstrap.css.ValidationState
import net.dontdrinkandroot.wicket.markup.html.basic.label
import org.apache.wicket.Component
import org.apache.wicket.ajax.attributes.ThrottlingSettings
import org.apache.wicket.feedback.FeedbackMessage
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.form.FormComponent
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.apache.wicket.validation.IValidator
import java.time.Duration

/**
 * @param <T> Type of the Model Object.
 * @param <M> Type of the FormComponent Model Object.
 * @param <F> Type of the Form Component.
 */
abstract class FormGroupValidatable<T, M, F : FormComponent<M>>(
    id: String,
    model: IModel<T>,
    labelModel: IModel<String>,
    val formText: IModel<String> = Model(null)
) : FormGroup<T>(id, model, labelModel) {

    lateinit var formTextLabel: Label

    lateinit var validationFeedbackPanel: FormValidationFeedbackPanel
        protected set

    override fun createComponents() {
        super.createComponents()
        formTextLabel = label("formText", formText, cssClass(BootstrapCssClass.FORM_TEXT), visible(formText.isPresent))
        validationFeedbackPanel = FormValidationFeedbackPanel("validationFeedback", this)
        validationFeedbackPanel.outputMarkupId = true
        formComponent.add(CssClassAppender { validationState })
    }

    override fun addComponents() {
        super.addComponents()
        container.add(formTextLabel)
        container.add(validationFeedbackPanel)
    }

    override fun createLabel(id: String): Component {
        val label = super.createLabel(id)
        label.add(ForComponentIdBehavior(formComponent))
        return label
    }

    fun setRequired(required: Boolean) {
        formComponent.isRequired = required
    }

    fun addAjaxValidation(
        eventName: String = "input",
        delay: Duration = Duration.ofMillis(250),
        postponeTimerOnUpdate: Boolean = true
    ) {
        formComponent.add(
            FormGroupAjaxValidationBehavior(eventName, this, ThrottlingSettings(delay, postponeTimerOnUpdate))
        )
    }

    val validationState: ValidationState?
        get() = when {
            !formComponent.isValid -> ValidationState.INVALID
//            formComponent. formComponent.isValid -> ValidationState.VALID
            validationFeedbackPanel.anyMessage(FeedbackMessage.ERROR) -> ValidationState.INVALID
            validationFeedbackPanel.anyMessage(FeedbackMessage.SUCCESS) -> ValidationState.VALID
            else -> null
        }

    fun addValidator(validator: IValidator<M>) {
        formComponent.add(validator)
    }

    fun setFormText(formText: String?) {
        this.formText.setObject(formText)
    }

    abstract val formComponent: F
}