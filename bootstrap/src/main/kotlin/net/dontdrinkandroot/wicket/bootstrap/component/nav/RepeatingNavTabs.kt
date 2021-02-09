package net.dontdrinkandroot.wicket.bootstrap.component.nav

import net.dontdrinkandroot.wicket.bootstrap.behavior.NavTabsBehavior
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.model.IModel

open class RepeatingNavTabs<T> @JvmOverloads constructor(
    id: String,
    model: IModel<T>? = null,
    justifiedModel: IModel<Boolean> = false.model()
) : AbstractRepeatingNav<T>(id, model) {

    constructor(id: String, model: IModel<T>? = null, justified: Boolean) : this(id, model, justified.model())

    init {
        this.add(NavTabsBehavior(justifiedModel))
    }
}