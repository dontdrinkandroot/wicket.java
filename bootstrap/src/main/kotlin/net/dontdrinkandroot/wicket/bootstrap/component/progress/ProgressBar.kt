package net.dontdrinkandroot.wicket.bootstrap.component.progress

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.model.CssClassToggleModel
import org.apache.wicket.AttributeModifier
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.markup.html.panel.GenericPanel
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

class ProgressBar : GenericPanel<Int> {

    lateinit var bar: WebMarkupContainer
        private set

    var isAnimated = false
        private set

    var isStriped = false
        private set

    @JvmOverloads
    constructor(id: String, model: IModel<Int> = Model(0)) : super(id, model)

    constructor(id: String, model: IModel<Int>, striped: Boolean) : super(id, model) {
        isStriped = striped
    }

    constructor(id: String, model: IModel<Int>, striped: Boolean, animated: Boolean) : super(id, model) {
        isAnimated = animated
        isStriped = striped
    }

    override fun onInitialize() {
        super.onInitialize()
        this.add(CssClassAppender(BootstrapCssClass.PROGRESS))
        bar = WebMarkupContainer("bar")
        bar.add(AttributeModifier("aria-valuenow", this.model))
        bar.add(AttributeModifier("style") { String.format("width: %d%%;", this@ProgressBar.modelObject) })

        /* Animated */
        bar.add(CssClassAppender(CssClassToggleModel(BootstrapCssClass.PROGRESS_BAR_ANIMATED, { isAnimated })))

        /* Striped */
        bar.add(CssClassAppender(CssClassToggleModel(BootstrapCssClass.PROGRESS_BAR_STRIPED, { isStriped })))

        bar.outputMarkupId = true
        this.add(bar)
    }

    fun setAnimated(animated: Boolean): ProgressBar {
        isAnimated = animated
        return this
    }

    fun setStriped(striped: Boolean): ProgressBar {
        isStriped = striped
        return this
    }

    fun update(target: AjaxRequestTarget) {
        target.appendJavaScript(String.format("$('#%s').css({width: '%d%%'});", bar.markupId, this.modelObject))
        target.appendJavaScript(String.format("$('#%s').attr('aria-valuenow', %d);", bar.markupId, this.modelObject))
    }
}