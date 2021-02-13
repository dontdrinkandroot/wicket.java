package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.behavior.ForComponentIdBehavior
import net.dontdrinkandroot.wicket.bootstrap.behavior.form.FormGroupAjaxValidationBehavior
import net.dontdrinkandroot.wicket.bootstrap.component.feedback.FencedFeedbackPanel
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.bootstrap.css.ValidationState
import org.apache.wicket.Component
import org.apache.wicket.ajax.attributes.ThrottlingSettings
import org.apache.wicket.feedback.FeedbackMessage
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
    val helpTextModel: IModel<String> = Model(null)
) : FormGroup<T>(id, model, labelModel) {

    lateinit var helpBlock: FencedFeedbackPanel
        protected set

    override fun createComponents() {
        super.createComponents()
        helpBlock = object : FencedFeedbackPanel("helpBlock", this) {
            override fun getCSSClass(message: FeedbackMessage): String {
                return message.levelAsString.toLowerCase()
            }

            override fun onConfigure() {
                super.onConfigure()

                /* Always renotify of help text if set so it gets rendered every time */
                val helpTextModel = helpTextModel
                if (helpTextModel.getObject() != null) {
                    this.info(helpTextModel.getObject())
                }
                this.outputMarkupPlaceholderTag = !this.anyMessage()
                this.isVisible = this.anyMessage()
            }
        }
        helpBlock.add(CssClassAppender(BootstrapCssClass.FORM_TEXT))
        helpBlock.outputMarkupId = true
        formComponent.add(CssClassAppender { validationState })
    }

    override fun addComponents() {
        super.addComponents()
        container.add(helpBlock)
    }

    override fun createLabel(id: String): Component {
        val label = super.createLabel(id)
        label.add(ForComponentIdBehavior(formComponent))
        return label
    }

    fun setRequired(required: Boolean) {
        formComponent.isRequired = required
    }

    /**
     * Enables Ajax Validation for the "input" event with default thresholding of 250ms.
     */
    fun addDefaultAjaxInputValidation() {
        addAjaxValidation("input", ThrottlingSettings(Duration.ofMillis(250), true))
    }

    @JvmOverloads
    fun addAjaxValidation(eventName: String, throttlingSettings: ThrottlingSettings? = null) {
        formComponent.add(FormGroupAjaxValidationBehavior(eventName, this, throttlingSettings))
    }

    val validationState: ValidationState?
        get() = when {
            !formComponent.isValid -> ValidationState.INVALID
//            formComponent. formComponent.isValid -> ValidationState.VALID
            helpBlock.anyMessage(FeedbackMessage.FATAL) -> ValidationState.INVALID
            helpBlock.anyMessage(FeedbackMessage.ERROR) -> ValidationState.INVALID
            helpBlock.anyMessage(FeedbackMessage.SUCCESS) -> ValidationState.VALID
            else -> null
        }

    fun addValidator(validator: IValidator<M>) {
        formComponent.add(validator)
    }

    fun setHelpText(helpText: String?) {
        this.helpTextModel.setObject(helpText)
    }

    abstract val formComponent: F
}