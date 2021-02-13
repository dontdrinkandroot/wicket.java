package net.dontdrinkandroot.wicket.bootstrap.component.feedback

import org.apache.wicket.Component
import org.apache.wicket.feedback.IFeedbackMessageFilter

class ClosableFencedFeedbackPanel(id: String, fence: Component? = null, filter: IFeedbackMessageFilter? = null) :
    FencedFeedbackPanel(id, fence, filter)