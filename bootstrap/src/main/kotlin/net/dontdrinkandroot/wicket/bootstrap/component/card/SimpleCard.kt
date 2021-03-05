package net.dontdrinkandroot.wicket.bootstrap.component.card

import net.dontdrinkandroot.wicket.component.basic.Heading
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

/**
 * A [Card] with a standard heading. The body can be rendered via wicket:extend.
 *
 * @param <T> Type of the Model Object.
 */
open class SimpleCard<T>(
    id: String,
    model: IModel<T>? = null,
    private val headingModel: IModel<String>,
    private val headingLevelModel: IModel<Heading.Level> = Model(Heading.Level.H2),
) : Card<T>(id, model) {

    override fun createHeader(id: String) = Heading(id, headingModel, headingLevelModel)
}