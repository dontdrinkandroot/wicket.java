package net.dontdrinkandroot.wicket.bootstrap.component.panel

import net.dontdrinkandroot.wicket.bootstrap.css.PanelStyle
import net.dontdrinkandroot.wicket.component.basic.Heading
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.model.IModel

/**
 * A [Panel] with a standard heading. The body can be rendered via wicket:extend.
 *
 * @param <T> Type of the Model Object.
 */
open class SimplePanel<T>(
    id: String,
    model: IModel<T>? = null,
    styleModel: IModel<PanelStyle> = PanelStyle.DEFAULT.model(),
    private val headingModel: IModel<String>,
    private val headingLevelModel: IModel<Heading.Level> = Heading.Level.H2.model(),
) : Panel<T>(id, model, styleModel) {

    override fun createHeading(id: String) = PanelHeading(id, headingModel, headingLevelModel)
}