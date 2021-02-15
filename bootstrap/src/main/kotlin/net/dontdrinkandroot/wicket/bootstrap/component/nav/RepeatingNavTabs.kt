package net.dontdrinkandroot.wicket.bootstrap.component.nav

import net.dontdrinkandroot.wicket.bootstrap.behavior.NavTabsBehavior
import net.dontdrinkandroot.wicket.bootstrap.css.NavItemAlignment
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

open class RepeatingNavTabs<T> constructor(
    id: String,
    model: IModel<T>? = null,
    itemAlignmentModel: IModel<NavItemAlignment> = Model(null)
) : AbstractRepeatingNav<T>(id, model) {

    constructor(id: String, model: IModel<T>? = null, itemAlignment: NavItemAlignment?) :
            this(id, model, Model(itemAlignment))

    init {
        this.add(NavTabsBehavior(itemAlignmentModel))
    }
}

inline fun <T> repeatingNavTabs(
    id: String,
    crossinline populateItemsHandler: (itemView: RepeatingView) -> Unit,
    model: IModel<T>? = null,
    itemAlignmentModel: IModel<NavItemAlignment> = Model(null)
) = object : RepeatingNavTabs<T>(id, model, itemAlignmentModel) {
    override fun populateItems(itemView: RepeatingView) {
        populateItemsHandler(itemView)
    }
}