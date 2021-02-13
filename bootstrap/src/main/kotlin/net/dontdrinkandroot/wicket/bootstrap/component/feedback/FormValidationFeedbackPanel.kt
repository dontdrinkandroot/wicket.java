package net.dontdrinkandroot.wicket.bootstrap.component.feedback

import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupValidatable
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import org.apache.wicket.feedback.FeedbackMessage
import org.apache.wicket.model.IModel

class FormValidationFeedbackPanel(
    id: String,
    fence: FormGroupValidatable<*, *, *>,
    val helpTextModel: IModel<String>
) : FencedFeedbackPanel(id, fence) {

    override fun getCSSClass(message: FeedbackMessage) = when (message.level) {
        FeedbackMessage.SUCCESS -> BootstrapCssClass.VALID_FEEDBACK.classString
        FeedbackMessage.INFO -> BootstrapCssClass.FORM_TEXT.classString
        FeedbackMessage.ERROR -> BootstrapCssClass.INVALID_FEEDBACK.classString
        else -> BootstrapCssClass.FORM_TEXT.classString
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