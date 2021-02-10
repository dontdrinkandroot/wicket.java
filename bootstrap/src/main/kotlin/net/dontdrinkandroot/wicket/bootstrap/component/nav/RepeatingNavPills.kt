package net.dontdrinkandroot.wicket.bootstrap.component.nav

import net.dontdrinkandroot.wicket.bootstrap.behavior.NavPillsBehavior
import net.dontdrinkandroot.wicket.bootstrap.css.NavItemAlignment
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

open class RepeatingNavPills<T> constructor(
    id: String,
    model: IModel<T>? = null,
    itemAlignmentModel: IModel<NavItemAlignment> = Model(null)
) : AbstractRepeatingNav<T>(id, model) {

    constructor(id: String) : this(id, null)

    constructor(id: String, model: IModel<T>? = null, itemAlignment: NavItemAlignment?) :
            this(id, model, Model(itemAlignment))

    init {
        this.add(NavPillsBehavior(itemAlignmentModel))
    }
}