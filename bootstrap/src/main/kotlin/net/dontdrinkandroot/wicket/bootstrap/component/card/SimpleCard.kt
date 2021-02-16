package net.dontdrinkandroot.wicket.bootstrap.component.card

import net.dontdrinkandroot.wicket.component.basic.Heading
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.model.IModel

/**
 * A [Card] with a standard heading. The body can be rendered via wicket:extend.
 *
 * @param <T> Type of the Model Object.
 */
open class SimpleCard<T>(
    id: String,
    model: IModel<T>? = null,
    private val headingModel: IModel<String>,
    private val headingLevelModel: IModel<Heading.Level> = Heading.Level.H2.model(),
) : Card<T>(id, model) {

    override fun createHeader(id: String) = Heading(id, headingModel, headingLevelModel)
}