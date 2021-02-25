package net.dontdrinkandroot.wicket.bootstrap.component.nav

import net.dontdrinkandroot.wicket.bootstrap.behavior.NavPillsBehavior
import net.dontdrinkandroot.wicket.bootstrap.css.NavItemAlignment
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

class RepeatingNavPills<T> constructor(
    id: String,
    model: IModel<T>? = null,
    populateItemsHandler: AbstractRepeatingNav<T>.(itemView: RepeatingView) -> Any?,
    itemAlignmentModel: IModel<NavItemAlignment> = Model(null)
) : AbstractRepeatingNav<T>(id, model, populateItemsHandler) {

    init {
        this.add(NavPillsBehavior(itemAlignmentModel))
    }
}