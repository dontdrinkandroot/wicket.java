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

class ProgressBar(
    id: String,
    model: IModel<Int>,
    val animatedModel: IModel<Boolean> = Model(false),
    val stripedModel: IModel<Boolean> = Model(false)
) : GenericPanel<Int>(id, model) {

    lateinit var bar: WebMarkupContainer
        private set

    override fun onInitialize() {
        super.onInitialize()
        this.add(CssClassAppender(BootstrapCssClass.PROGRESS))
        bar = WebMarkupContainer("bar")
        bar.add(AttributeModifier("aria-valuenow", this.model))
        bar.add(AttributeModifier("style") {
            String.format(
                "width:%d%%;",
                this@ProgressBar.modelObject
            )
        })

        /* Animated */
        bar.add(CssClassAppender(CssClassToggleModel(BootstrapCssClass.PROGRESS_BAR_ANIMATED, animatedModel)))

        /* Striped */
        bar.add(CssClassAppender(CssClassToggleModel(BootstrapCssClass.PROGRESS_BAR_STRIPED, stripedModel)))

        bar.outputMarkupId = true
        this.add(bar)
    }

    fun update(target: AjaxRequestTarget) {
        target.appendJavaScript(String.format("$('#%s').css({width: '%d%%'});", bar.markupId, this.modelObject))
        target.appendJavaScript(String.format("$('#%s').attr('aria-valuenow', %d);", bar.markupId, this.modelObject))
    }

    override fun detachModels() {
        super.detachModels()
        animatedModel.detach()
        stripedModel.detach()
    }
}