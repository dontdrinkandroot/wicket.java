package net.dontdrinkandroot.wicket.bootstrap.component.panel

import net.dontdrinkandroot.wicket.component.basic.Heading
import net.dontdrinkandroot.wicket.model.KModel
import net.dontdrinkandroot.wicket.model.kModel
import org.apache.wicket.Component
import org.apache.wicket.model.IModel

/**
 * A [Panel] with a standard heading. The body can be rendered via wicket:extend.
 *
 * @param <T> Type of the Model Object.
 */
open class SimplePanel<T>(
    id: String,
    model: IModel<T>? = null,
    private val headingModel: KModel<String>,
    private val headingLevelModel: KModel<Heading.Level> = Heading.Level.H2.kModel()
) : Panel<T>(id, model) {

    override fun createHeading(id: String): Component {
        return PanelHeading(id, headingModel, headingLevelModel)
    }
}