package net.dontdrinkandroot.wicket.bootstrap.component.feedback

import org.apache.wicket.Component
import org.apache.wicket.feedback.FeedbackMessage
import org.apache.wicket.feedback.FencedFeedbackPanel
import org.apache.wicket.feedback.IFeedbackMessageFilter
import org.apache.wicket.markup.html.basic.Label

open class FencedFeedbackPanel(id: String, fence: Component? = null, filter: IFeedbackMessageFilter? = null) :
    FencedFeedbackPanel(id, fence, filter) {

    override fun getCSSClass(message: FeedbackMessage): String =
        FeedbackPanel.messageToBootstrapAlertCss(message).classString

    override fun newMessageDisplayComponent(id: String, message: FeedbackMessage): Component {
        val serializable = message.message
        val label = Label(id, serializable?.toString() ?: "")
        label.escapeModelStrings = this.escapeModelStrings
        label.outputMarkupId = false
        return label
    }
}