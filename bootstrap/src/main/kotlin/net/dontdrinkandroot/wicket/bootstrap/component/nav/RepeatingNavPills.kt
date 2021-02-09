package net.dontdrinkandroot.wicket.bootstrap.component.nav

import net.dontdrinkandroot.wicket.bootstrap.behavior.NavPillsBehavior
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.model.IModel

open class RepeatingNavPills<T> @JvmOverloads constructor(
    id: String,
    model: IModel<T>? = null,
    justifiedModel: IModel<Boolean> = false.model(),
    stackedModel: IModel<Boolean> = false.model()
) : AbstractRepeatingNav<T>(id, model) {

    constructor(id: String, model: IModel<T>? = null, justified: Boolean = false, stacked: Boolean = false) :
            this(id, model, justified.model(), stacked.model())

    init {
        this.add(NavPillsBehavior(justifiedModel, stackedModel))
    }
}