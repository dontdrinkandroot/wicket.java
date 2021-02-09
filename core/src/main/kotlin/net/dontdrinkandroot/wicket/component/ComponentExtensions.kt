package net.dontdrinkandroot.wicket.component

import net.dontdrinkandroot.wicket.model.KModel
import net.dontdrinkandroot.wicket.model.toKModel
import org.apache.wicket.IGenericComponent

val <T, C : IGenericComponent<T, *>> IGenericComponent<T, C>.kModel: KModel<T>
    get() = this.model.toKModel()