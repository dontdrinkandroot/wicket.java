package net.dontdrinkandroot.wicket.markup.html.panel

import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.Markup
import org.apache.wicket.markup.html.panel.GenericPanel
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel

abstract class RepeatingPanel<T>(
    id: String,
    model: IModel<T>? = null,
    private val childTag: String = "div",
    vararg behaviors: Behavior
) : GenericPanel<T>(id, model) {

    init {
        val childView = RepeatingView("child")
        populateChildren(childView)
        add(childView)
        add(*behaviors)
    }

    override fun getAssociatedMarkup(): Markup = Markup.of(
        """<wicket:panel xmlns:wicket>
    <$childTag wicket:id="child"></$childTag>
    </wicket:panel>"""
    )

    protected abstract fun populateChildren(childView: RepeatingView)
}

inline fun <T> repeatingPanel(
    id: String,
    model: IModel<T>,
    childTag: String = "div",
    vararg behaviors: Behavior,
    crossinline populateChildrenHandler: RepeatingView.(component: RepeatingPanel<T>) -> Any?
) = object : RepeatingPanel<T>(id, model, childTag, *behaviors) {
    override fun populateChildren(childView: RepeatingView) {
        populateChildrenHandler(childView, this)
    }
}

inline fun repeatingPanel(
    id: String,
    childTag: String = "div",
    vararg behaviors: Behavior,
    crossinline populateChildrenHandler: RepeatingView.(component: RepeatingPanel<Void>) -> Any?
) = object : RepeatingPanel<Void>(id, null, childTag, *behaviors) {
    override fun populateChildren(childView: RepeatingView) {
        populateChildrenHandler(childView, this)
    }
}