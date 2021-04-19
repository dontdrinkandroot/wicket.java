package net.dontdrinkandroot.wicket.behavior.ajax

import org.apache.wicket.MarkupContainer
import org.apache.wicket.ajax.AbstractAjaxTimerBehavior
import org.apache.wicket.ajax.AjaxRequestTarget
import java.time.Duration

inline fun MarkupContainer.addAjaxTimer(
    duration: Duration,
    crossinline onTimerHandler: (target: AjaxRequestTarget) -> Unit
) {
    val behavior = object : AbstractAjaxTimerBehavior(duration) {
        override fun onTimer(target: AjaxRequestTarget) {
            onTimerHandler(target)
        }
    }
}