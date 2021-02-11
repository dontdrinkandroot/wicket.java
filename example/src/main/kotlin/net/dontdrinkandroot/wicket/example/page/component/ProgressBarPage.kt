package net.dontdrinkandroot.wicket.example.page.component

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior
import net.dontdrinkandroot.wicket.bootstrap.component.progress.ProgressBar
import net.dontdrinkandroot.wicket.bootstrap.css.Spacing
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.ajax.markup.html.AjaxLink
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters
import kotlin.math.roundToInt

class ProgressBarPage(parameters: PageParameters) : ComponentPage(parameters) {

    override fun createPageHeadingModel() = "Progress Bars".model()

    override fun onInitialize() {
        super.onInitialize()

        val valueModel: IModel<Int> = Model(33)

        val defaultBar = ProgressBar("defaultBar", valueModel)
        defaultBar.add(CssClassAppender(Spacing.MARGIN_BOTTOM_HALF))
        this.add(defaultBar)

        val stripedBar = ProgressBar("stripedBar", valueModel, true, false)
        stripedBar.add(CssClassAppender(Spacing.MARGIN_BOTTOM_HALF))
        this.add(stripedBar)

        val animatedBar = ProgressBar("animatedBar", valueModel, true, true)
        animatedBar.add(CssClassAppender(Spacing.MARGIN_BOTTOM_HALF))
        this.add(animatedBar)

        val updateButton: AjaxLink<Void> = object : AjaxLink<Void>("updateButton") {
            override fun onClick(target: AjaxRequestTarget?) {
                valueModel.setObject((Math.random() * 100).roundToInt())
                target?.let {
                    defaultBar.update(it)
                    stripedBar.update(it)
                    animatedBar.update(it)
                }
            }
        }
        updateButton.body = Model.of("update")
        updateButton.add(ButtonBehavior())
        this.add(updateButton)

    }
}