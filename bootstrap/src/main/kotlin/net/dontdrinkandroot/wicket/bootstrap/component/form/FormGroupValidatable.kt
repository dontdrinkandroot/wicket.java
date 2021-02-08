package net.dontdrinkandroot.wicket.bootstrap.component.form

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.behavior.ForComponentIdBehavior
import net.dontdrinkandroot.wicket.bootstrap.behavior.form.FormGroupAjaxValidationBehavior
import net.dontdrinkandroot.wicket.bootstrap.component.feedback.FencedFeedbackPanel
import net.dontdrinkandroot.wicket.bootstrap.css.ValidationState
import net.dontdrinkandroot.wicket.model.KModel
import org.apache.wicket.Component
import org.apache.wicket.ajax.attributes.ThrottlingSettings
import org.apache.wicket.feedback.FeedbackMessage
import org.apache.wicket.markup.html.form.FormComponent
import org.apache.wicket.model.IModel
import org.apache.wicket.validation.IValidator
import java.time.Duration

/**
 * @param <T> Type of the Model Object.
 * @param <M> Type of the FormComponent Model Object.
 * @param <F> Type of the Form Component.
 */
abstract class FormGroupValidatable<T, M, F : FormComponent<M>> constructor(
    id: String,
    labelModel: KModel<String?>,
    model: IModel<T>?,
    type: Class<T>? = null
) : FormGroup<T>(id, labelModel, model) {

    lateinit var helpBlock: FencedFeedbackPanel
        protected set

    protected var helpTextModel: IModel<String?>? = null

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
                if (helpTextModel?.getObject() != null) {
                    this.info(helpTextModel.getObject())
                }
                this.outputMarkupPlaceholderTag = !this.anyMessage()
                this.isVisible = this.anyMessage()
            }
        }
        helpBlock.outputMarkupId = true
        this.add(CssClassAppender { validationState })
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
    fun addAjaxValidation(eventName: String?, throttlingSettings: ThrottlingSettings? = null) {
        formComponent.add(FormGroupAjaxValidationBehavior(eventName, this, throttlingSettings))
    }

    val validationState: ValidationState?
        get() {
            if (!formComponent.isValid) {
                return ValidationState.ERROR
            }
            if (helpBlock.anyMessage(FeedbackMessage.FATAL) || helpBlock.anyMessage(FeedbackMessage.ERROR)) {
                return ValidationState.ERROR
            }
            if (helpBlock.anyMessage(FeedbackMessage.WARNING)) {
                return ValidationState.WARNING
            }
            if (helpBlock.anyMessage(FeedbackMessage.SUCCESS)) {
                return ValidationState.SUCCESS
            }
            return if (formComponent.isRequired && null == this.modelObject) {
                ValidationState.WARNING
            } else null
        }

    fun addValidator(validator: IValidator<M>?) {
        formComponent.add(validator)
    }

    fun setHelpText(helpTextModel: IModel<String?>?) {
        this.helpTextModel = helpTextModel
    }

    abstract val formComponent: F
}