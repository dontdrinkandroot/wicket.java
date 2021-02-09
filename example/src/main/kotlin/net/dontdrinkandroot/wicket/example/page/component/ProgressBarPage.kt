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
        defaultBar.add(
            CssClassAppender(
                Spacing(
                    Spacing.Property.MARGIN,
                    Spacing.Side.BOTTOM,
                    Spacing.Size.HALF
                )
            )
        )
        this.add(defaultBar)
        val updateButton: AjaxLink<Void> = object : AjaxLink<Void>("updateButton")
        {
            override fun onClick(target: AjaxRequestTarget)
            {
                valueModel.setObject((Math.random() * 100).roundToInt())
                defaultBar.update(target)
            }
        }
        updateButton.body = Model.of("update")
        updateButton.add(ButtonBehavior())
        this.add(updateButton)
        val stripedBar = ProgressBar("stripedBar", valueModel, true, false)
        this.add(stripedBar)
        val animatedBar = ProgressBar("animatedBar", valueModel, true, true)
        this.add(animatedBar)
    }
}