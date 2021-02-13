package net.dontdrinkandroot.wicket.bootstrap.component.feedback

import net.dontdrinkandroot.wicket.bootstrap.css.AlertStyle
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.css.CompositeCssClass
import net.dontdrinkandroot.wicket.css.CssClass
import org.apache.wicket.Component
import org.apache.wicket.feedback.FeedbackMessage
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.panel.FeedbackPanel

open class FeedbackPanel(id: String) : FeedbackPanel(id) {

    override fun getCSSClass(message: FeedbackMessage): String {
        return messageToBootstrapAlertCss(message).classString
    }

    override fun newMessageDisplayComponent(id: String, message: FeedbackMessage): Component {
        val serializable = message.message
        val label = Label(id, serializable?.toString() ?: "")
        label.escapeModelStrings = this.escapeModelStrings
        label.outputMarkupId = false
        return label
    }

    companion object {

        fun messageToBootstrapAlertCss(message: FeedbackMessage): CssClass {
            return CompositeCssClass(
                BootstrapCssClass.ALERT,
                levelToBootstrapAlertStyle(message.level)
            )
        }

        fun levelToBootstrapAlertStyle(level: Int): CssClass? = when (level) {
            FeedbackMessage.WARNING, FeedbackMessage.DEBUG -> AlertStyle.WARNING
            FeedbackMessage.SUCCESS -> AlertStyle.SUCCESS
            FeedbackMessage.INFO -> AlertStyle.INFO
            FeedbackMessage.ERROR, FeedbackMessage.FATAL -> AlertStyle.DANGER
            else -> null
        }
    }
}