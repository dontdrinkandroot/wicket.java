package net.dontdrinkandroot.wicket.bootstrap.component.nav

import net.dontdrinkandroot.wicket.bootstrap.behavior.NavTabsBehavior
import net.dontdrinkandroot.wicket.model.KModel
import net.dontdrinkandroot.wicket.model.kModel
import org.apache.wicket.model.IModel

class RepeatingNavTabs<T> @JvmOverloads constructor(
    id: String,
    model: IModel<T>? = null,
    justifiedModel: KModel<Boolean> = false.kModel()
) :
    AbstractRepeatingNav<T>(id, model) {

    init {
        this.add(NavTabsBehavior(justifiedModel))
    }
}